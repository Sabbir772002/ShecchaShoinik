package TeamProfile;

import DB.ConnectionDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.net.URI;
import java.sql.*;
import java.util.Optional;

public class TeamProfileController {
    Connection con;

    @FXML
    private Label Name;

    @FXML
    private Button bt11;

    @FXML
    private Label district;

    @FXML
    private Label division;

    @FXML
    private Label mail;

    @FXML
    private TextField name;

    @FXML
    private Label phone;

    @FXML
    private Label showuser;
    @FXML
    private Label License;
    String username;
    String role;
    @FXML
    private Button delete;
    private String name2;
    private String username1;

    @FXML
    void Delete(ActionEvent event) {
        try {
            con=ConnectionDb.DBC();
            String st = "Delete from userlist WHERE Username='" + showuser.getText().toString()+"'";
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(st);
            preparedStatement.execute();
            System.out.println("User deleted");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("User deleted Successfully");
            alert.setHeaderText("Click ok to Back!");
            File file = new File("src/main/Font/icon1.png");
            Image image = new Image(file.toURI().toString());
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(image);
            // alert.initOwner(stage);
            //alert.setGraphic(new ImageView(image));
            //user.setImage(image);
            Optional<ButtonType> result = alert.showAndWait();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("hey ki khobor");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(AdminDB.ControlPanelController.class.getResource("ControlPanel.fxml"));
            AnchorPane ap = fxmlLoader.load();
            AdminDB.ControlPanelController sadmin = fxmlLoader.getController();
            sadmin.set(username, role, pane);
            pane.setCenter(ap);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }




    }
    public void set(String username, String role) {
        if(role.equals("Admin"))delete.setVisible(true);

        con = ConnectionDb.DBC();
        role = role;
        this.role = role;
        this.username = username;
        output();

        // alertcount();
        //alertnum.setText(String.valueOf(newcount));
        // Thread t=new HelpRequest.AlertThread();
        //t.start();


    } public void set(String username, String role,String name2, String username1,BorderPane pane) {
        if(role.equals("Admin"))delete.setVisible(true);

        con = ConnectionDb.DBC();
        role = role;
        this.role = role;
        this.username = username;
        this.name2 = name2;
        this.username1 = username1;
        this.pane = pane;
        username2=username;
        output();

        // alertcount();
        //alertnum.setText(String.valueOf(newcount));
        // Thread t=new HelpRequest.AlertThread();
        //t.start();


    }
    String username2="";
    BorderPane pane;

    public void set(String username, String role, BorderPane pane) {
        if(role.equals("Admin"))delete.setVisible(true);

        con= ConnectionDb.DBC();
        this.pane=pane;
        // user.setText(username);
        // rolee.setText("@"+role);
        this.role = role;
        this.username = username;
        username2=username;
        output();
    }


   @FXML
     void mail(MouseEvent e){

        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.MAIL)) {
                    URI mailto = new URI("mailto:"+mail.getText().toString());
                    desktop.mail(mailto);
                }
            }
        }catch (Exception ee )
        {
            System.out.println(ee.getMessage());
        }
    }

    public void output(){
        try{
            Statement stmt=con.createStatement();
            String sql = "SELECT Name,Username,Phone,Division,District,Mail,License FROM teams Where Username = \'"+username2+"\'";
            //String sql = "SELECT * FROM `userlist` Where Username = '"+1+"'";
            //System.out.println("'"+user.getText()+"'");
            //SELECT Name,ID FROM `userlist` WHERE Username= "Nuha";
            //String s1="select * from teacher where Subject='PHYSICS'";
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next()) {
                Name.setText(rs.getString(1));
                showuser.setText(rs.getString(2));
                phone.setText(rs.getString(3));
                division.setText(rs.getString(4));
                district.setText(rs.getString(5));
                mail.setText(rs.getString(6));
                License.setText(rs.getString(7));


            }
            rs.close();
            stmt.close();
            con.close();
           // name.setText(Name.getText().toString());
            String uname = showuser.getText().toString();
           /* System.out.println(uname);
            System.out.println(username);*/
            //System.out.println(user.getText().toString());
            if(username.toString().equals(uname)) {
                // pfield.setText("Edit"); //pore add korbo
            }else{

            }
            showuser.setText("@"+showuser.getText().toString());
        } catch (SQLException ex) {
            System.out.println("onk error");
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    void request(ActionEvent event) {


    }
    @FXML
    void join(ActionEvent event) {



    }
    @FXML
    void Save(ActionEvent event) {
        Stage stage;
        Parent root;



        PreparedStatement preparedStatement;
        try {
            con= ConnectionDb.DBC();
            String st = "update userlist set Name=?,Phone=?,Division=?,District=?,Mail=? WHERE Username ='"+username+"'";
            preparedStatement = (PreparedStatement) con.prepareStatement(st);
            preparedStatement.setString(1, name.getText());
            preparedStatement.setString(2, phone.getText());
            preparedStatement.setString(3, division.getText());
            preparedStatement.setString(4, district.getText());
            preparedStatement.setString(5, mail.getText());
            preparedStatement.execute();
            preparedStatement.close();
            con.close();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Profile Update");
            alert.setHeaderText("Profile Updated Succesfully!");
            // alert.setContentText("");
            File file = new File("src/main/Font/icon1.png");
            Image image = new Image(file.toURI().toString());
            stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(image);
            Optional<ButtonType> result=alert.showAndWait();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

