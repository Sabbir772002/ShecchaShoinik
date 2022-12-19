package Event;

import AdminDB.AdminDashboardController;
import AdminDB.FXMLScene;
import AdminProfile.AdminProfileController;
import BloodBank.BloodBankController;
import DB.ConnectionDb;
import Others.TeamApproveController;
import PostBox.AddPostController;
import Sign_in.SigninController;
import UserProfile.ProfileController;
import com.example.sheccashoinik.Application;
import com.example.sheccashoinik.disaster;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ApproveEVentController implements Initializable {
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
    private ChoiceBox<String > choice;

    @FXML
    private ImageView imageview;

    @FXML
    private ImageView imageview1;

    @FXML
    private ImageView logoimage;

    @FXML
    private BorderPane pane1;

    @FXML
    private Label rolee;

    @FXML
    private TableView<EventList> time;

    @FXML
    private TableColumn<EventList, String> title;

    @FXML
    private Label user;

    @FXML
    void BbankClick(MouseEvent event) {

    }
    @FXML
    void tapprove(MouseEvent event) {

    }
    @FXML
    void Event(ActionEvent event) {
        try {
            Event.FXMLScene scene = Event.FXMLScene.load("ApproveEVent.fxml");
            Parent root = scene.root;
            Event.ApproveEVentController admin = (Event.ApproveEVentController) scene.controller;
            admin.set(username, role);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Event");
            stage.show();
        } catch (IOException e) {
            System.out.println("vul hoilo Event button Teamshboard controller " + e.getMessage());
        }

    }


    @FXML
    void hresponse(ActionEvent event) {

    }

    @FXML
    void task(ActionEvent event) {

    }

    @FXML
    void vapprove(ActionEvent event) {

    }

    @FXML
    void vnear(ActionEvent event) {

    }

    @FXML
    void BbankClick(ActionEvent event) {
        try{
            BloodBank.FXMLScene scene =  BloodBank.FXMLScene.load("BloodBank.fxml");
            Parent root = scene.root;
            BloodBankController admin= (BloodBankController) scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Blood Bank ");
            stage.show();
        }catch (Exception e){
            System.out.println("vul hoilo AdminDashboardController "+e.getMessage());
        }
    }

    @FXML
    void Cevent(ActionEvent event) {

    }
    @FXML
    void Control(ActionEvent event) {

    }
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
            System.out.println("vul hoilo Teamaopprove AdminDashboardController"+e.getMessage());
        }
    }


    @FXML
    void Dashboard(ActionEvent event) {
        try{
            AdminDB.FXMLScene scene =  AdminDB.FXMLScene.load("AdminDashboard.fxml");
            Parent root = scene.root;
            AdminDashboardController admin= (AdminDashboardController) scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Admin Dashboard");
            stage.show();
        }catch (Exception e){
            System.out.println("vul hoilo AdminDashboardController"+e.getMessage());
        }

    }

    @FXML
    void Diaster(ActionEvent event) throws IOException {


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
        try{
            Shoinik.FXMLScene scene =  Shoinik.FXMLScene.load("Volunteerfromarea.fxml");
            Parent root = scene.root;
            Shoinik.VolunteerfromareaController admin= (Shoinik.VolunteerfromareaController) scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("VolunteerfromareaController");
            stage.show();
        }catch(IOException e){
            System.out.println("vul hoilo F button userdashboard controller "+e.getMessage());
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
    Pane p;


    @FXML
    void profile(ActionEvent event) {

        try{
            AdminDB.FXMLScene scene =  FXMLScene.load("AdminProfile.fxml");
            Parent root = scene.root;
            AdminProfileController admin= (AdminProfileController)scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Profile");
            stage.show();
        }catch (Exception e){
            System.out.println("vul hoilo Admin Dashbaord profile button profile controller");
        }
    }



    @FXML
    void ChoiceClick(MouseEvent event) {
        if(choice.getValue().toString().equals("Logout")){
            try {

                root = FXMLLoader.load(SigninController.class.getResource("Sign_in.fxml"));

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("SIGN IN");
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
    void addpost(ActionEvent event) {
        System.out.println("hello");
        try{
            PostBox.FXMLScene scene =  PostBox.FXMLScene.load("AddPost.fxml");
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
    void Homego(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*user.setText(username);
        rolee.setText(role);*/
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
        file1 = new File("src/main/Font/search.png");
        Image image6 = new Image(file1.toURI().toString());
    }

    @FXML
    void tableclick(MouseEvent event)
    {
        //System.out.println("kaj kore na");
        //System.out.println("click korse ");
        try{
            PostBox.FXMLScene scene =  PostBox.FXMLScene.load("PostView.fxml");
            Parent root = scene.root;
            PostBox.Post admin= (PostBox.Post) scene.controller;
          //  admin.set(username,role,table.getSelectionModel().getSelectedItem().getId());
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("PostBox");
            stage.show();


        }catch (Exception e ){
            System.out.println(e.getMessage());
        }


    }
}


