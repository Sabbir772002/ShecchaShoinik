package Chat;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class MyServer {

    private static ArrayList<UserWrite> clients = new ArrayList<UserWrite>();

    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket socket;

        try {
            serverSocket = new ServerSocket(5000);
            while (true){
                System.out.println("Waiting");
                socket = serverSocket.accept();
                System.out.println("Connected");
                UserWrite thread = new UserWrite(socket,clients);
                clients.add(thread);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}












/*
public class MyServer {
    static int i=0;
    public static void main(String []args) {
        try {
            System.out.println("Server wait kortese.");
            ServerSocket serverSocket = new ServerSocket(1000);
            while (true){
                Socket sc = serverSocket.accept();
                Client client = new Client(sc);
                Thread t = new Thread(client);
                t.start();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
*/

