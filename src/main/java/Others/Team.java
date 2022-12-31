package Others;

import Chat.userlist;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static DB.ConnectionDb.DBC;

public class Team {
    public Team(String Name,String district,String username) {
        this.Name = Name;
        this.District = district;
       this.Username = username;
    }public Team(String Name,String username) {
        this.Name = Name;
       this.Username = username;
    }

    String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getLicense() {
        return License;
    }

    public void setLicense(String license) {
        License = license;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getDivision() {
        return Division;
    }

    public void setDivision(String division) {
        Division = division;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAvailablity() {
        return Availablity;
    }

    public void setAvailablity(String availablity) {
        Availablity = availablity;
    }

    String Username;
    String License;
    String Mail;
    String ID;
    String Pass;
    String District;
    String Division;
    String Type;
    String Phone;
    String Availablity;

    public Team() {
    }

    public Team(String name, String username, String license, String mail, String ID, String pass, String district, String division, String type, String phone, String availablity) {
        Name = name;
        Username = username;
        License = license;
        Mail = mail;
        this.ID = ID;
        Pass = pass;
        District = district;
        Division = division;
        Type = type;
        Phone = phone;
        Availablity = availablity;
    }




}
