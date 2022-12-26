package Chat;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class Client implements Runnable{
    String clientName;
    BufferedReader reader;
    Socket sc;
    BufferedWriter writer;
    final static ArrayList<Client> clients = new ArrayList<>();
    Client(Socket sc){
        try {
            this.sc = sc;
            OutputStreamWriter o = new OutputStreamWriter(sc.getOutputStream());
            writer = new BufferedWriter(o);
            InputStreamReader isr = new InputStreamReader(sc.getInputStream());
            reader = new BufferedReader(isr);
            clientName = reader.readLine();
            clients.add(this);
            System.out.println("Client: " + clientName + " on live.");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while(true){
            try {
                String data = reader.readLine();
                data = clientName + ": " + data + "\n";
                synchronized (clients){
                    for(Client client: clients){
                        OutputStreamWriter o = new OutputStreamWriter(sc.getOutputStream());
                        writer = new BufferedWriter(o);
                        client.writer.write(data);
                        client.writer.flush();
                    }
                }
            }
            catch (SocketException e){
                System.out.println("vul je "+ e.getMessage());
                break;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}