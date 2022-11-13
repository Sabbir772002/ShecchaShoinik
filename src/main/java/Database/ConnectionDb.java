/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;


public class ConnectionDb {
  //  Connection conn;
    public static Connection DB()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shecchashoinik","root","");
            return con;
        } catch (Exception e) {
            System.err.println("Connection paitese na vai");
           return null;
        }
    }

}
