package UserProfile;

import AdminProfile.ControlPanelController;
import BloodBank.User;
import Chat.ChatPrivateController;
import Chat.CommunityChatHandelar;
import DB.ConnectionDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;
import java.beans.BeanProperty;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {
    Connection con;
    String username="";
    String role="";
    private String user2;
    private String name2;
    BorderPane pane;
    @FXML
    private Button delete;
    String tname="";
    @FXML
    Label maill;

    public void set(String username, String role, String name2, String user2,BorderPane pane) {
        if(role.equals("Admin"))delete.setVisible(true);

        this.pane = pane;
        con=ConnectionDb.DBC();
        this.role = role;
        this.username = username;

        this.user2 = user2;
        this.name2 = name2;
        pfield.setText("Edit Profile");
        String sname = username;
        if (!username.equals(user2)) {
            sname=user2;
            pfield.setText("Chat");
        }
        System.out.println(user2);
        tname=user2;
        output();
        System.out.println(username);
    }
    public void set(String username, String role,BorderPane pane) {
        if(role.equals("Admin"))delete.setVisible(true);

        this.pane=pane;
        con= ConnectionDb.DBC();
        role=role;
        this.role = role;
        this.username = username;
        tname=username;
        output();

        // alertcount();
        //alertnum.setText(String.valueOf(newcount));
        // Thread t=new HelpRequest.AlertThread();
        //t.start();


    }
    public void set(String username, String role) {
        if(role.equals("Admin"))delete.setVisible(true);

        pane=pane;
        con= ConnectionDb.DBC();
        role=role;
        this.role = role;
        this.username = username;
        tname=username;
        output();

        // alertcount();
        //alertnum.setText(String.valueOf(newcount));
        // Thread t=new HelpRequest.AlertThread();
        //t.start();


    }
    @FXML
    void mail(ActionEvent e){

        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.MAIL)) {
                    URI mailto = new URI("mailto:"+maill.getText().toString());
                  desktop.mail(mailto);
                }
            }
        }catch (Exception ee )
        {
            System.out.println(ee.getMessage());
        }
    }  @FXML
    void whatsapp(ActionEvent e){

        try {

            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI("https://wa.me/88"+Phone.getText().toString()));
            }
        }catch (Exception ee) {
            System.out.println(ee.getMessage());
        }


    }

    @FXML
    private Label BG;

    @FXML
    private Label District;

    @FXML
    private Label Division;

    @FXML
    private Label NID;

    @FXML
    private Label Name;

    @FXML
    private Label Phone;

    @FXML
    private Label field;

    @FXML
    private Button pfield;

    @FXML
    private Label showuser;
    @FXML
    void Delete(){
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

    @FXML
    void paction(ActionEvent event) {
        try {
            if (pfield.getText().equals("Chat")) {
                FXMLLoader fxmlLoader=new FXMLLoader();
                fxmlLoader.setLocation(Chat.ChatPrivateController.class.getResource("ChatPrivate.fxml"));
                AnchorPane ap=fxmlLoader.load();
                ChatPrivateController padmin=fxmlLoader.getController();
                padmin.set(username,role,name2,user2,pane);
                pane.setCenter(ap);
            } else {
                FXMLLoader fxmlLoader=new FXMLLoader();
                fxmlLoader.setLocation(UserProfile.ProfileEditController.class.getResource("ProfileEdit.fxml"));
                AnchorPane ap=fxmlLoader.load();
                ProfileEditController padmin=fxmlLoader.getController();
                padmin.set(username,role);
                pane.setCenter(ap);
            }
        } catch (Exception e) {
            System.out.println("paction profile controller " + e.getMessage());
        }

    }
    public String uname;

    public void output() {
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT Name,Username,Phone,ID,Division,District,Extra,Mail,BG FROM userlist Where Username = \'" + tname + "\'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                Name.setText(rs.getString(1));
                showuser.setText(rs.getString(2));
                Phone.setText(rs.getString(3));
                NID.setText(rs.getString(4));
                District.setText(rs.getString(6));
                Division.setText(rs.getString(5));
                field.setText(rs.getString(7));
                BG.setText(rs.getString(9));
                maill.setText(rs.getString(8));

            }
            rs.close();
            stmt.close();
            con.close();
            uname = showuser.getText().toString();
        }catch (Exception e){

        }
        }
        @FXML
    Button  maili;
    @FXML
    Button whats;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ImageView i=new ImageView(new javafx.scene.image.Image(new File("src/main/Font/new.png").toURI().toString()));
        i.setFitHeight(20);
        maili.setGraphic(i);
        ImageView i1=new ImageView(new Image(new File("src/main/Font/whats/100.png").toURI().toString()));
        i.setFitWidth(20); i1.setFitHeight(20);
        i1.setFitWidth(20);
        whats.setGraphic(i1);
    }
}
/* System.out.println(uname);
            System.out.println(username);*//*

            //System.out.println(user.getText().toString());
            if (user.getText().toString().equals(uname)) {
                // pfield.setText("Edit"); //pore add korbo
            } else {

            }
            showuser.setText("@" + showuser.getText().toString());
        } catch (SQLException ex) {
            System.out.println("onk error");
            System.err.println(ex.getMessage());
        }
    }

}



/*
package UserProfile;
import AdminDB.*;
import Chat.ChatPrivateController;
import Chat.CommunityChatHandelar;
import DB.ConnectionDb;
import PostBox.AddPostController;
import Sign_in.SigninController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;


public class ProfileController implements Initializable {
    @FXML
    private BorderPane pane1;

    private Stage stage;
    private Scene scene;
    private Parent root;
    public String username = "";
    public String role1 = "";
    @FXML
    private Button pfield;
    private String user2;
    private String name2;
    String sname=username;

    public void set(String username, String role, String name2, String user2) {
        this.role1 = role;
        this.username = username;
        user.setText(username);
        rolee.setText("@"+role1);
        this.user2 = user2;
        this.name2 = name2;
        pfield.setText("Edit Profile");
        sname=username;
        if (!username.equals(user2)) {
            sname=user2;
            pfield.setText("Chat");
        }
        output();
    }

    @FXML
    void paction(ActionEvent event) {
        try {
            if (pfield.getText().equals("Chat")) {
                Chat.FXMLScene scene = Chat.FXMLScene.load("ChatPrivate.fxml");
                Parent root = scene.root;
                ChatPrivateController adminController = (ChatPrivateController) scene.controller;
                adminController.set(username, role1, name2, user2);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Chat");
                stage.show();
            } else {
                UserProfile.FXMLScene scene = UserProfile.FXMLScene.load("ProfileEdit.fxml");
                Parent root = scene.root;
                ProfileEditController adminController = (ProfileEditController) scene.controller;
                adminController.set(username, role1);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Chat");
                stage.show();
            }
        } catch (Exception e) {
            System.out.println("paction profile controller " + e.getMessage());
        }

    }


    @FXML
    private ChoiceBox<String> choice;
    @FXML
    private ImageView userimage;
    @FXML
    private ImageView imageview;
    @FXML
    private ImageView bimage;

    @FXML
    void BbankClick(ActionEvent event) {

    }

    @FXML
    private Button b;

    @FXML
    private Button bbutton;


    @FXML
    private ImageView imageview1;

    @FXML
    private ImageView logoimage;

    @FXML
    void BbankClick(MouseEvent event) {

    }

    @FXML
    private ScrollPane spane;
    Connection con;

    public ProfileController() {
        con = ConnectionDb.DBC();

    }


    @FXML
    void Dashboard(ActionEvent event) {
        try {
            if (role1.equals("User")) {
                AdminDB.FXMLScene scene = AdminDB.FXMLScene.load("UserDashboard.fxml");
                Parent root = scene.root;
                UserDashboardController adminController = (UserDashboardController) scene.controller;
                adminController.set(username, role1);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("UserProfile");
                stage.show();
            } else if (role1.equals("Admin")) {
                AdminDB.FXMLScene scene = AdminDB.FXMLScene.load("UserDashboard.fxml");
                Parent root = scene.root;
                UserDashboardController adminController = (UserDashboardController) scene.controller;
                adminController.set(username, role1);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("UserProfile");
                stage.show();
               */
/* AdminDB.FXMLScene scene = AdminDB.FXMLScene.load("AdminDashboard1.fxml");
                Parent root = scene.root;
                AdminDashboardController adminController = (AdminDashboardController) scene.controller;
                adminController.set(username, role1);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("AdminDashboard");
                stage.show();*//*

            } else {
                AdminDB.FXMLScene scene = AdminDB.FXMLScene.load("UserDashboard.fxml");
                Parent root = scene.root;
                UserDashboardController adminController = (UserDashboardController) scene.controller;
                adminController.set(username, role1);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("UserProfile");
                stage.show();
           */
/* AdminDB.FXMLScene scene = AdminDB.FXMLScene.load("TeamDashboard1.fxml");
                Parent root = scene.root;
                TeamDashboardController adminController = (TeamDashboardController) scene.controller;
                adminController.set(username, role1);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("TeamDashboard");
                stage.show();*//*

            }
        } catch (IOException e) {
            System.out.println("vul hoilo Profile controller dashboard " + e.getMessage());
        }


        System.out.println("vaiya ki khobor " + username);

    }

    @FXML
    void Diaster(ActionEvent event) throws IOException {

    }

    @FXML
    void hrequest(ActionEvent event) throws IOException {

    }

    @FXML
    void F(ActionEvent event) {

    }

    @FXML
    void G(ActionEvent event) {

    }

    @FXML
    void H(ActionEvent event) {

    }

    @FXML
    void Vnear(ActionEvent event) {

    }


    @FXML
    void chat(ActionEvent event) {
        try {

            Chat.FXMLScene scene = Chat.FXMLScene.load("CommunityChat.fxml");
            Parent root = scene.root;
            CommunityChatHandelar adminController = (CommunityChatHandelar) scene.controller;
            adminController.set(username, role1);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Chat");
            stage.show();
        } catch (Exception e) {

        }

    }

    @FXML
    void logout(ActionEvent event) {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Logout Confirmation");
            alert.setHeaderText("Are you sure you want to log out?");
            File file = new File("src/main/Font/icon1.png");
            Image image = new Image(file.toURI().toString());
            stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(image);
            // alert.initOwner(stage);
            //alert.setGraphic(new ImageView(image));
            //user.setImage(image);
            Optional<ButtonType> result = alert.showAndWait();
            if (alert.getResult().getText().equals("OK")) {
                root = FXMLLoader.load(SigninController.class.getResource("Sign_in.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("SIGN IN");
                stage.show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    Pane p;


    @FXML
    void profile(ActionEvent event) {
        try {
            UserProfile.FXMLScene scene = UserProfile.FXMLScene.load("Profile.fxml");
            Parent root = scene.root;
            ProfileController admin = (ProfileController) scene.controller;
            admin.set(username, role1);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Profile");
            stage.show();
        } catch (Exception e) {
            System.out.println("vul hoilo profile controller ");
        }

    }

    @FXML
    void Choiceclick(ActionEvent event) {
        if (choice.getValue().toString().equals("Logout")) {
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Logout Confirmation");
                alert.setHeaderText("Are you sure you want to log out?");
                File file = new File("src/main/Font/icon1.png");
                Image image = new Image(file.toURI().toString());
                stage = (Stage) alert.getDialogPane().getScene().getWindow();
                stage.getIcons().add(image);
                // alert.initOwner(stage);
                //alert.setGraphic(new ImageView(image));
                //user.setImage(image);
                Optional<ButtonType> result = alert.showAndWait();
                if (alert.getResult().getText().equals("OK")) {
                    root = FXMLLoader.load(SigninController.class.getResource("Sign_in.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setTitle("SIGN IN");
                    stage.show();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                  */
/* root = FXMLLoader.load(ProfileController.class.getResource("Profile.fxml"));
                   stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                   scene = new Scene(root);
                   stage.setScene(scene);
                   stage.setTitle("SIGN IN");
                   stage.show();*//*

                UserProfile.FXMLScene scene = UserProfile.FXMLScene.load("Profile.fxml");
                Parent root = scene.root;
                UserProfile.ProfileController adminController = (UserProfile.ProfileController) scene.controller;
                adminController.set(username, role1);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Profile");
                stage.show();

            } catch (Exception e) {

            }
               */
/* try {
                    //  FxmlLoader o = new FxmlLoader();
                    p = FXMLLoader.load(Profile.ProfileController.class.getResource("Profile.fxml"));

                    pane1.setCenter(p);
                    stage.setTitle("Profile");
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                   stage.setScene(scene);
                    stage.setTitle("Profile");
                    stage.show();
                    System.out.println("helloApplication");
                } catch (Exception e) {

                }*//*

        }

    }

    @FXML
    void ChoiceClick(ActionEvent event) {

    }

    @FXML
    void addpost(ActionEvent event) {
        System.out.println("hello");
        try {
            PostBox.FXMLScene scene = PostBox.FXMLScene.load("AddPost.fxml");
            Parent root = scene.root;
            AddPostController admin = (AddPostController) scene.controller;
            admin.set(username, role1);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Post Diaster");
            stage.show();

          */
/*  root = FXMLLoader.load(AddPostController.class.getResource("AddPost.fxml"));

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("SIGN IN");
            stage.show();*//*


        } catch (Exception e) {

        }

    }

    @FXML
    void Homego(MouseEvent event) {

    }

    @FXML
    private Label rolee;

    @FXML
    private Label user;


    public void set(String username, String role) {
        user.setText(username);
        rolee.setText("@" + role);
        this.username = username;
        this.role1 = role;
        user.setText(username);
        rolee.setText(role1);
        sname=username;
        output();
        // System.out.println("on set "+username);
    }


    @FXML
    private Label BG;

    @FXML
    private Label District;

    @FXML
    private Label Division;

    @FXML
    private Label NID;

    @FXML
    private Label Name;

    @FXML
    private Label Phone;
    @FXML
    private Label field;
    @FXML
    public Label showuser;
    public String uname;

    public void output() {
        try {
            Statement stmt = con.createStatement();
            System.out.println(sname);
            String sql = "SELECT Name,Username,Phone,ID,Division,District,Volunteer,BG FROM userlist Where Username = \'" + sname.toString() + "\'";
            //String sql = "SELECT * FROM `userlist` Where Username = '"+1+"'";
            //System.out.println("'"+user.getText()+"'");
            //SELECT Name,ID FROM `userlist` WHERE Username= "Nuha";
            //String s1="select * from teacher where Subject='PHYSICS'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                Name.setText(rs.getString(1));
                showuser.setText(rs.getString(2));
                Phone.setText(rs.getString(3));
                NID.setText(rs.getString(4));
                District.setText(rs.getString(6));
                Division.setText(rs.getString(5));
                field.setText(rs.getString(7));
                BG.setText(rs.getString(8));


            }
            rs.close();
            stmt.close();
            con.close();
            uname = showuser.getText().toString();
           */
/* System.out.println(uname);
            System.out.println(username);*//*

            //System.out.println(user.getText().toString());
            if (user.getText().toString().equals(uname)) {
                // pfield.setText("Edit"); //pore add korbo
            } else {

            }
            showuser.setText("@" + showuser.getText().toString());
        } catch (SQLException ex) {
            System.out.println("onk error");
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String[] choiceb = {"Profile", "Logout"};
        choice.getItems().addAll(choiceb);
        File file = new File("src/main/Font/user1.png");
        Image image = new Image(file.toURI().toString());
        imageview.setImage(image);
        File file1 = new File("src/main/Font/1.png");
        Image image1 = new Image(file1.toURI().toString());
        bimage.setImage(image1);
        file1 = new File("src/main/Font/logotext.png");
        Image image4 = new Image(file1.toURI().toString());
        logoimage.setImage(image4);
        file1 = new File("src/main/Font/icon1.png");
        Image image5 = new Image(file1.toURI().toString());
        imageview1.setImage(image5);
    }
}
*/
