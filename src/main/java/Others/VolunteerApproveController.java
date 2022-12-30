package Others;

import AdminDB.User;
import DB.ConnectionDb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.sql.*;
import java.util.Optional;

public class VolunteerApproveController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public String username = "";
    public String role = "";
    Connection con;


    public void set(String username, String role) {
        this.role = role;
        this.username = username;
        con=ConnectionDb.DBC();
        loadtable();
    }
    @FXML
   ImageView imageview;

    BorderPane pane;
    @FXML
    private Label BG;

    @FXML
    private Label District;

    @FXML
    private Label Division;

    @FXML
    private Label NID;

    @FXML
    private TableColumn<User, String> Namet;


    @FXML
    private Label  Name;
    @FXML
    private Label Phone;

    @FXML
    private TableColumn<User, String> Username;

    @FXML
    private TableView<User> alluser;

    @FXML
    private Label mail;

    @FXML
    private Label showuser;
    String user="";

    @FXML
    void Approve(ActionEvent event) {
        try {
            con=ConnectionDb.DBC();
            PreparedStatement ps = con.prepareStatement("Update volunteer set Approve=1 where Username='"+user+"'");
            ps.executeUpdate();
            ps.close();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("User Approved!");
            alert.setHeaderText("User Approve Succesfully!");
            // alert.setContentText("");
            File file = new File("src/main/Font/icon1.png");
            Image image = new Image(file.toURI().toString());
            stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(image);
            Optional<ButtonType> result=alert.showAndWait();
            loadtable();
        }catch(Exception e){
            System.out.println(e.getMessage());

        }
    }

    public void set(String username, String role, BorderPane pane) {
        this.pane = pane;
        // user.setText(username);
        // rolee.setText("@"+role);
        this.role = role;
        this.username = username;
        con=ConnectionDb.DBC();
        loadtable();


    }
    ObservableList<User> list = FXCollections.observableArrayList();

    ObservableList<User> loadusers(){
        ObservableList<User>list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT Name,Username FROM volunteer where Teams='"+username+"' And approve=0");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getString(1),rs.getString(2)));
            }
        }catch(Exception e){
            System.out.println(e.getMessage());

        }


        return list;
    }
    void loadtable() {
        System.out.println("table");
        Namet.setCellValueFactory(new PropertyValueFactory<User,String>("Name"));
        Username.setCellValueFactory(new PropertyValueFactory<User, String>("Username"));
        list = loadusers();
       alluser.setItems(list);
        load("Sabbir");

    }

    void load(String s) {
        try {
            con=ConnectionDb.DBC();
            Statement stmt = con.createStatement();
            String sql = "SELECT Name,Username,Phone,Division,District,Mail,ID,BG FROM Volunteer Where Username = \'" + s + "\'";
            //String sql = "SELECT * FROM `userlist` Where Username = '"+1+"'";
            //System.out.println("'"+user.getText()+"'");
            //SELECT Name,ID FROM `userlist` WHERE Username= "Nuha";
            //String s1="select * from teacher where Subject='PHYSICS'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                Name.setText(rs.getString(1));
                showuser.setText(rs.getString(2));
                Phone.setText(rs.getString(3));
                Division.setText(rs.getString(4));
                District.setText(rs.getString(5));
                mail.setText(rs.getString(6));
                NID.setText(rs.getString(7));
                BG.setText(rs.getString(8));

            }
            user=showuser.getText().toString();
            rs.close();
            stmt.close();
            con.close();
          /*  Name.setText(Name.getText().toString());
            String uname = showuser.getText().toString();*/
           /* System.out.println(uname);
            System.out.println(username);*/
            //System.out.println(user.getText().toString());
           /* if (username.toString().equals(uname)) {
                // pfield.setText("Edit"); //pore add korbo
            } else {

            }*/
            showuser.setText("@" + showuser.getText().toString());
        } catch (
                SQLException ex) {
            System.out.println("onk error at table on volunteer approve");
            System.err.println(ex.getMessage());
        }
    }
    @FXML
    void click(MouseEvent event) {
        load(alluser.getSelectionModel().getSelectedItem().getUsername().toString());

}

}
