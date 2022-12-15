package Others;

import AdminDB.AdminDashboardController;
import AdminDB.TeamDashboardController;
import AdminDB.UserDashboardController;
import BloodBank.BloodBankController;
import Post.AddPostController;
import Sign_in.SigninController;
import UserProfile.ProfileController;
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
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class TeamApproveController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public String username="";
    public String role="";


    public void set(String username,String role) {
        user.setText(username);
        rolee.setText("@"+role);
        this.role = role;
        this.username = username;
    }
    @FXML
    private Button b;

    @FXML
    private Button bbutton;

    @FXML
    private ImageView bimage;

    @FXML
    private Button bt1;

    @FXML
    private ChoiceBox<String> choice;

    @FXML
    private ImageView imageview;

    @FXML
    private ImageView imageview1;

    @FXML
    private ImageView logoimage;

    @FXML
    private Label rolee;

    @FXML
    private Label user;
    @FXML
    void TeamApprove(ActionEvent event) {
        try{
            Others.FXMLScene scene =  Others.FXMLScene.load("TeamApprove.fxml");
            Parent root = scene.root;
            TeamApproveController admin= (TeamApproveController) scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Team Approve");
            stage.show();
        }catch (Exception e){
            System.out.println("vul hoilo Teamaopprove TeamApproveController"+e.getMessage());
        }
    }

     @FXML
    void H(ActionEvent event) {
        try{
            Others.FXMLScene scene =  Others.FXMLScene.load("TeamApprove.fxml");
            Parent root = scene.root;
            TeamApproveController admin= (TeamApproveController) scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Team Approve");
            stage.show();
        }catch (Exception e){
            System.out.println("vul hoilo Teamaopprove TeamApproveController"+e.getMessage());
        }
    }

    @FXML
    void Cevent(ActionEvent event) {

    }
    @FXML
    void Control(ActionEvent event) {

    }
    @FXML
    void BbankxClick(ActionEvent event) {

    }

    @FXML
    void ChoiceClick(MouseEvent event) {

    }

    @FXML
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
    void Dashboard(ActionEvent event) {
        try {
            if (role.equals("User")) {
                AdminDB.FXMLScene scene = AdminDB.FXMLScene.load("UserDashboard.fxml");
                Parent root = scene.root;
                UserDashboardController adminController = (UserDashboardController) scene.controller;
                adminController.set(username, role);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("UserProfile");
                stage.show();
            }else if(role.equals("Admin")){
                AdminDB.FXMLScene scene = AdminDB.FXMLScene.load("AdminDashboard.fxml");
                Parent root = scene.root;
                AdminDashboardController adminController = (AdminDashboardController) scene.controller;
                adminController.set(username, role);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("UserProfile");
                stage.show();

            }else {
                AdminDB.FXMLScene scene = AdminDB.FXMLScene.load("TeamDashboard.fxml");
                Parent root = scene.root;
                TeamDashboardController adminController = (TeamDashboardController) scene.controller;
                adminController.set(username, role);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("TeamDashboard");
                stage.show();
            }
        }catch(IOException e){
            System.out.println("vul hoilo add post er dashboard "+e.getMessage());
        }

    }

    @FXML
    void Diaster(ActionEvent event) {

    }

    @FXML
    void task(ActionEvent event) {

    }

    @FXML
    void vapprove(ActionEvent event) {

    }

    @FXML
    void hresponse(ActionEvent event) {

    }

    @FXML
    void addpost(ActionEvent event) {
        try{
            Post.FXMLScene scene =  Post.FXMLScene.load("AddPost.fxml");
            Parent root = scene.root;
            AddPostController admin= (AddPostController) scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Post Diaster");
            stage.show();


        }catch (Exception e ){

        }
    }

    @FXML
    void chat(ActionEvent event) {

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
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String []choice1={"Profile","Logout"};
        choice.getItems().addAll(choice1);
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
        file1 = new File("src/main/Font/search.png");
        Image image6 = new Image(file1.toURI().toString());
        //search.setImage(image6);
    }
    @FXML
    public void vnear(ActionEvent event) {
        try{
            Shoinik.FXMLScene scene =  Shoinik.FXMLScene.load("Volunteerfromarea.fxml");
            Parent root = scene.root;
            Shoinik.VolunteerfromareaController admin= (Shoinik.VolunteerfromareaController) scene.controller;
            // admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("VolunteerfromareaController");
            stage.show();
        }catch(IOException e){
            System.out.println("vul hoilo F button userdashboard controller "+e.getMessage());
        }

    }

    public void BbankClick(MouseEvent mouseEvent) {
    }
}
