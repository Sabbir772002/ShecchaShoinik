package Post;

import UserProfile.ProfileController;
import Sign_in.SigninController;
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
import AdminDB.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AddPostController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public String username="";
    public String role="";


    public void set(String username,String role) {
        user.setText(username);
        rolee.setText("@"+role);
        this.username = username;
        this.role = role;
        System.out.println(username);
    }
    @FXML
    private TextArea address;


    @FXML
    private TextArea address1;

    @FXML
    private Button b;

    @FXML
    private Button bbutton;

    @FXML
    private ImageView bimage;

    @FXML
    private ChoiceBox<String> choice;

    @FXML
    private TextArea diastertitle;

    @FXML
    private ComboBox<String> division;

    @FXML
    private ComboBox<String> diaster;

    @FXML
    private ComboBox<String> district;

    @FXML
    private ImageView imageview;

    @FXML
    private ImageView imageview1;

    @FXML
    private ImageView logoimage;

    @FXML
    private BorderPane pane1;

    @FXML
    void BbankClick(MouseEvent event) {

    }
    @FXML
    void ChoiceClick(ActionEvent event) {

    }

    @FXML
    void ChoiceClick(MouseEvent event) {

    }
    @FXML
    void select(ActionEvent event) {
        String divisionname;
        try{
            divisionname=division.getSelectionModel().getSelectedItem().toString();
        }catch(Exception e ){
            divisionname="";
        }
        if(divisionname.equals("Dhaka")){
            district.getItems().removeAll(district.getItems());
            String []ditrict={"Dhaka","Gazipur","Faridpur","Gopalganj","Jamalpur","Kishoreganj","Madaripur","Manikganj","Munshiganj","Narayanganj","Narshingdi","Rajbari","Shariatpur","Tangail"};
            district.getItems().addAll(ditrict);
        }else if(divisionname.equals("Rajshahi")){
            district.getItems().removeAll(district.getItems());

            String []ditrict={"Rajshahi","Sirajgonj","Bogra","Chapinawabganj","Joypurhat","Naogaon","Natore","Pabna"};
            district.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Chattogram")){
            district.getItems().removeAll(district.getItems());

            String []ditrict={"Chattogram","Cox's Bazar", "Rangamati", "Bandarban", "Khagrachhari", "Feni", "Lakshmipur", "Comilla"," Noakhali", "Brahmanbaria" ,"Chandpur"};
            district.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Barishal")){
            district.getItems().removeAll(district.getItems());

            String []ditrict={"Barishal", "Barguna", "Bhola", "Jhalokati", "Pirojpur","Patuakhali"};
            district.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Sylhet")){
            district.getItems().removeAll(district.getItems());

            String []ditrict={"Sylhet","Habiganj","Moulvibazar","Sunamganj" };
            district.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Mymensingh")){
            district.getItems().removeAll(district.getItems());

            String []ditrict={"Mymensingh","Jamalpur","Netrokona","Sherpur" };
            district.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Khulna")){
            district.getItems().removeAll(district.getItems());

            String []ditrict={"Khulna","Bagherhat","Chuadanga","Jessore","Jinaidaha","Magura","Meherpur","Narail","Satkhira" };
            district.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Rangpur")){
            district.getItems().removeAll(district.getItems());

            String []ditrict={"Rangpur","Kurigram","Gaibandha","Thakurgaon","Dinajpur","Nilphamari","Panchagarh","Lalmonirhat" };
            district.getItems().addAll(ditrict);
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
                stage.setTitle("AdminDashboard");
                stage.show();
            }else{
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
            System.out.println("vul hoilo add post er dashboard ");
            }
        }



    @FXML
    void Diaster(ActionEvent event) {

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
    void addpost(ActionEvent event) {

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
                  /* root = FXMLLoader.load(ProfileController.class.getResource("Profile.fxml"));
                   stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                   scene = new Scene(root);
                   stage.setScene(scene);
                   stage.setTitle("SIGN IN");
                   stage.show();*/
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

                }*/
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
        division.getItems().addAll(division1);
        String []user={"EarthQuake","Blood","Fire","Cyclone","Cidor","Others"};
        diaster.getItems().addAll(user);
        String []choiceb={"Profile","Logout"};
        choice.getItems().addAll(choiceb);
        File file = new File("src/main/Font/user1.png");
        Image image = new Image(file.toURI().toString());
        imageview.setImage(image);
        File file1 = new File("src/main/Font/1297136.png");
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
