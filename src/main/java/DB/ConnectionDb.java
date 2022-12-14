/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Chat.userlist;
import com.example.sheccashoinik.diaster;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class ConnectionDb {
    Connection con;
    public static Connection DBC()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sheccashoinik","root","");
            return con;
        } catch (Exception e) {
            System.err.println("Connection paitese na vai");
           return null;
        }

    }
    public static ObservableList<diaster> getdiasterlist(){
        Connection con =DBC();
        ObservableList<diaster>list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps =  con.prepareStatement("SELECT * FROM `diasterlist` ORDER BY Id DESC;");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                //String Title,Type, Address, Division, District, Id,AddInfo
                list.add(new diaster((rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7)));
            }
        } catch (Exception e) {
            System.out.println("error at bd backlist");
        }finally{

            try {
               con.close();
            } catch (Exception e) {
            }
        }
        return list;
    }
    public static ObservableList<userlist> getuserlist(){
        Connection con =DBC();
        ObservableList<userlist>list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps =  con.prepareStatement("SELECT Name,Username FROM `userlist`");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                //String Title,Type, Address, Division, District, Id,AddInfo
                list.add(new userlist(rs.getString(1), rs.getString(2))); //rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7)));
            }
        } catch (Exception e) {
            System.out.println("error at db userlist");
        }finally{

            try {
               con.close();
            } catch (Exception e) {
            }
        }
        return list;
    }


}

