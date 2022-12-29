package Chat;

import javafx.scene.control.TextArea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class WriteThread extends Thread {
    TextArea showArea;
    BufferedReader reader;

    public WriteThread(TextArea showArea, BufferedReader reader) {
        this.showArea = showArea;
        this.reader = reader;
    }

    @Override
    public void run() {
        while (true) {
           // System.out.println("1bar");
            try {
               // System.out.println("likhtesi");
                String data = reader.readLine()+"\n";
               //String[] sentences =data.split(":");
                showArea.appendText(data);

            } catch (SocketException e) {
                showArea.appendText("Connection lost!\n");
                break;
            } catch (IOException e) {
                System.out.println("hoi na kn " + e.getMessage());

            } catch (Exception e) {
                System.out.println("ki plbm " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
