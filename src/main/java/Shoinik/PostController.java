package Shoinik;

import AdminDB.AdminDashboardController;
import AdminDB.FXMLScene;
import AdminDB.TeamDashboardController;
import AdminDB.UserDashboardController;
import DB.ConnectionDb;
import Others.HelpResponseController;
import Sign_in.SigninController;
import UserProfile.ProfileController;
import com.example.sheccashoinik.Application;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.Optional;
import java.util.ResourceBundle;

public class PostController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public String username="";
    public String role="";
    Connection con;
    public PostController(){
        con=ConnectionDb.DBC();
    }


    public void set(String username,String role) {
        user.setText(username);
        rolee.setText("@"+role);
        this.username = username;
        this.role = role;
        System.out.println(username);
    }
    @FXML
    private Label address;



    @FXML
    private Button b;

    @FXML
    private Button bbutton;

    @FXML
    private ImageView bimage;

    @FXML
    private ChoiceBox<String> choice;

    @FXML
    private TextField diastertitle;

    @FXML
    private Label division;

    @FXML
    private ComboBox<String> diaster;

    @FXML
    private Label district;

    @FXML
    private ImageView imageview;

    @FXML
    private ImageView imageview1;

    @FXML
    private ImageView logoimage;

    @FXML
    private BorderPane pane1;
    String imagef="src/main/Font/1.jpg";
    Image image1;
    @FXML
    private Button imageup;

    @FXML
    void BbankClick(MouseEvent event) {

    }
    @FXML
    void ChoiceClick(ActionEvent event) {

    }
    @FXML
    void upimage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        //final Button openButton = new Button("Choose Background Image");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Select Image","*.jpg","*.png"));
        // fileChooser.setInitialDirectory(new File("C:\\Users\\USER\\Pictures"));
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            imagef = file.getAbsolutePath();
            String s[]=imagef.split("\\\\");
            //System.out.println(imagef);
            System.out.println(s[s.length - 1]);
            imageup.setText(s[s.length - 1]);
            // File f= new File("src/main/file.image");

            // openFile(file);
            // where my problem is
            image1 = new Image(file.toURI().toString());

            // what I tried to do
            // Image image1 = new Image(file);
            //ImageView ip = new ImageView(image1);
            /*BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);*/
/*
                BackgroundImage backgroundImage = new BackgroundImage(image1, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
*/
        }


    }

    @FXML
    void ChoiceClick(MouseEvent event) {

    }

    @FXML
    void Dashboard(ActionEvent event) {
        try {
            if (role.equals("User")) {
                FXMLScene scene = FXMLScene.load("UserDashboard.fxml");
                Parent root = scene.root;
                UserDashboardController adminController = (UserDashboardController) scene.controller;
                adminController.set(username, role);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("UserProfile");
                stage.show();
            }else if(role.equals("Admin")){
                FXMLScene scene = FXMLScene.load("AdminDashboard.fxml");
                Parent root = scene.root;
                AdminDashboardController adminController = (AdminDashboardController) scene.controller;
                adminController.set(username, role);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("UserProfile");
                stage.show();

               /* AdminDB.FXMLScene scene = AdminDB.FXMLScene.load("AdminDashboard1.fxml");
                Parent root = scene.root;
                AdminDashboardController adminController = (AdminDashboardController) scene.controller;
                adminController.set(username, role);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("AdminDashboard");
                stage.show();*/
            }else{
                FXMLScene scene = FXMLScene.load("TeamDashboard.fxml");
                Parent root = scene.root;
                TeamDashboardController adminController = (TeamDashboardController) scene.controller;
                adminController.set(username, role);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("TeamDashboard");
                stage.show();
                /*AdminDB.FXMLScene scene = AdminDB.FXMLScene.load("TeamDashboard1.fxml");
                Parent root = scene.root;
                TeamDashboardController adminController = (TeamDashboardController) scene.controller;
                adminController.set(username, role);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("TeamDashboard");
                stage.show();*/
            }
        }catch(IOException e){
            System.out.println("vul hoilo add post er dashboard "+e.getMessage());
        }
    }



    @FXML
    void Diaster(ActionEvent event) {

    }

    @FXML
    void F(ActionEvent event) {

        //System.out.println("vaiya ki khobor "+username);
        try{
            Others.FXMLScene scene =  Others.FXMLScene.load("Post.fxml");
            Parent root = scene.root;
            HelpResponseController admin= (HelpResponseController) scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Help Response");
            stage.show();
        }catch(Exception e){
            System.out.println("vul hoilo F button userdashboard controller");
        }

    }

    @FXML
    void G(ActionEvent event) {

    }

    @FXML
    void hrequest(ActionEvent event) {

    }

    @FXML
    void vnear(ActionEvent event) {

    }

    @FXML
    void addpost(ActionEvent event) {

    }
    @FXML
    void Event(ActionEvent event) {

    }

    @FXML
    void chat(ActionEvent event) {

    }
    @FXML
    void viewmap(ActionEvent event) {

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
            Optional<ButtonType> result=alert.showAndWait();
            if(alert.getResult().getText().equals("OK")){
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
    @FXML
    void chatclick(ActionEvent e){


    }

    @FXML
    void profile(ActionEvent event) {

        try{
            UserProfile.FXMLScene scene =  UserProfile.FXMLScene.load("Profile.fxml");
            Parent root = scene.root;
            ProfileController admin= (ProfileController) scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Profile");
            stage.show();
        }catch (Exception e){
            System.out.println("vul hoilo add post controller");
        }

    } @FXML
    void Choiceclick(ActionEvent event) {
        if(choice.getValue().toString().equals("Logout")){
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
                Optional<ButtonType> result=alert.showAndWait();
                if(alert.getResult().getText().equals("OK")){
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
        }else {
            try{
                UserProfile.FXMLScene scene =  UserProfile.FXMLScene.load("Profile.fxml");
                Parent root = scene.root;
                ProfileController adminController = (ProfileController) scene.controller;
                adminController.set(username,role);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Profile");
                stage.show();

            }catch (Exception e){

            }

        }

    }
    @FXML
    private Label rolee;

    @FXML
    private Label user;


    public void set(String username) {
        user.setText(username);
        rolee.setText("@"+role);
        this.username = username;
        System.out.println(username);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String []division1={"Dhaka","Rajshahi","Chattogram","Barishal","Rangpur","Sylhet","Khulna", "Mymensingh"};
        //division.getItems().addAll(division1);
        String []user={"EarthQuake","Storm Surge","Wildfire","Cyclone","Flood","Drought","Tsunami","Typhoon","LandSlide","Epidemic","Structural Collapse","Transport Disasters","Mining Accidents","Explosions and Fires","Others"};
        diaster.getItems().addAll(user);
        String []choiceb={"Profile","Logout"};
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
        username= Application.oname;

    }

}
