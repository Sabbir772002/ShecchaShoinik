package Chat;

import DB.ConnectionDb;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PrivateThread extends Thread {
    TextArea msgbox;
    BufferedReader reader;
    Connection con;
    String username;
    String user2;
    public PrivateThread(TextArea msgbox,String username, String user2) {
        this.msgbox = msgbox;
       this.username = username;
       this.user2 = user2;
    }
    void refresh(){
        msgbox.clear();
        try {
            con= ConnectionDb.DBC();
            String sql = "SELECT * FROM privatechat Where Sender = ? OR Sender = ? OR Reciver = ? OR Reciver = ?";
/*
            OR Sender = ? OR Sender = ? OR Reciver = ? OR Reciver = ?
*/
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, username + user2);
            preparedStatement.setString(2, user2 + username);
            preparedStatement.setString(3, user2 + username);
            preparedStatement.setString(4, username+user2);
         /*   preparedStatement.setString(5, username + "Nuha");
            preparedStatement.setString(6, "Nuha" + username);
            preparedStatement.setString(7, "Sabbir" + username);
            preparedStatement.setString(8, username+"Sabbir");*/
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                msgbox.appendText(resultSet.getString(3));
                msgbox.appendText("\n");
            }
            //sleep(1000);
            resultSet.close();
            con.close();

        } catch (Exception ex) {
            System.out.println("sudu vul");
            System.out.println(ex.getMessage());

        }
    }

    @Override
    public void run() {
        while (true) {
           // System.out.println("1bar");
            try {
                refresh();
                sleep(2000);
            }  catch (Exception e) {
                System.out.println("ki plbm " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
