package Others;

import AdminDB.User;
import DB.ConnectionDb;
import UserProfile.ProfileController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ConcurrentModificationException;

public class VolunteerList {
    Connection con;
    public VolunteerList(){
        con=ConnectionDb.DBC();

    }
    String Username,role;
    BorderPane pane;
    public void set(String username, String role, BorderPane pane) {
        con= ConnectionDb.DBC();
        this.role = role;
        this.Username = username;
        loadtable();
        this.pane=pane;
        loadtable();


    }

    @FXML
    private TableColumn<TeamMember, String> Name;

    @FXML
    private TableColumn<TeamMember, String> Phone;

    @FXML
    private TableColumn<TeamMember, String> mail;

    @FXML
    private TableView<TeamMember> teammember;

    @FXML
    private TableColumn<TeamMember, String> username;
    ObservableList<TeamMember> list = FXCollections.observableArrayList();

    ObservableList<TeamMember> loadusers(){
        ObservableList<TeamMember>list = FXCollections.observableArrayList();

        try {

            PreparedStatement ps = con.prepareStatement("SELECT Name,Username,Mail,Phone FROM Volunteer where Teams='" + Username + "'");
            ResultSet rs = ps.executeQuery();
           // System.out.println("Loading team members");
            while (rs.next()) {
                list.add(new TeamMember(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        }catch(Exception e){
            System.out.println(e.getMessage());

        }


        return list;
    }
    void loadtable() {
       // System.out.println("table");
        Name.setCellValueFactory(new PropertyValueFactory<TeamMember,String>("Name"));
        username.setCellValueFactory(new PropertyValueFactory<TeamMember, String>("Username"));
        mail.setCellValueFactory(new PropertyValueFactory<TeamMember, String>("Mail"));
        Phone.setCellValueFactory(new PropertyValueFactory<TeamMember, String>("Phone"));
        list = loadusers();
        teammember.setItems(list);

    }
    @FXML
    void tableclick(MouseEvent event) {
        String Name2=teammember.getSelectionModel().getSelectedItem().getName().toString();
        String user2= teammember.getSelectionModel().getSelectedItem().getUsername().toString();
        try{
            System.out.println("hey ki khobor");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(UserProfile.ProfileController.class.getResource("Profile.fxml"));
            AnchorPane ap = fxmlLoader.load();
            ProfileController sadmin = fxmlLoader.getController();
            sadmin.set(Username,role,Name2,user2,pane);
            //pane1.setVisible(false);
            pane.setCenter(ap);
            //.setCenter(ap);
           // System.out.println("kno holo na table click on volunteer list");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
