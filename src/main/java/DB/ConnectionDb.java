/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Chat.userlist;
import Others.Team;
import com.example.sheccashoinik.disaster;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;


public class ConnectionDb {
    Connection con;
    public static Connection DBC()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sheccashoinik","root","");
            return con;
        } catch (Exception e) {
            System.err.println("Connection paitese na vai"+e.getMessage());
           return null;
        }

    }
    public static ObservableList<disaster> getdiasterlist(){
        Connection con =DBC();
        ObservableList<disaster>list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps =  con.prepareStatement("SELECT * FROM `diasterlist` ORDER BY Id DESC;");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                //String Title,Type, Address, Division, District, Id,AddInfo
                list.add(new disaster((rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7)));
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
    public static ObservableList<Team> getTeamlist(String Division, String District){
        Connection con =DBC();
        ObservableList<Team>list = FXCollections.observableArrayList();
        try {

            PreparedStatement ps =  con.prepareStatement("SELECT Name,District,Username FROM Teams where District='"+District+"'");;
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                //String Title,Type, Address, Division, District, Id,AddInfo
                list.add(new Team(rs.getString(1), rs.getString(2),rs.getString(3))); //rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7)));
            }
            rs.close();
            PreparedStatement ps1 =  con.prepareStatement("SELECT Name,District,Username FROM Teams where Division='"+Division+"' And District!='"+District+"'");;
            ResultSet rs1 = ps1.executeQuery();

            while(rs1.next()){
                //System.out.println("rs1");
                //String Title,Type, Address, Division, District, Id,AddInfo
                list.add(new Team(rs1.getString(1), rs1.getString(2),rs1.getString(3))); //rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7)));
            }
            rs1.close();
            PreparedStatement ps2 =  con.prepareStatement("SELECT Name,District,Username FROM Teams where Division!='"+Division+"'");;
            ResultSet rs2 = ps2.executeQuery();
           // System.out.println(Division);
            while(rs2.next()){
               // System.out.println("rs2");
                //String Title,Type, Address, Division, District, Id,AddInfo
                list.add(new Team(rs2.getString(1), rs2.getString(2),rs2.getString(3))); //rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7)));
            }
            System.out.println(Division+" "+District);
            rs2.close();
        } catch (SQLException e) {
            System.out.println("error at db team "+e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {

            try {
                con.close();
            } catch (Exception e) {
            }
        }
        return list;
    }


}

