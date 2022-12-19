package TeamPostBox;

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
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;
import java.util.ResourceBundle;

public class AddPostController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public String username="";
    public String role="";
    Connection con;
    public AddPostController(){
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
    private TextField address;


    @FXML
    private TextField address1;

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
    String imagef="src/main/Font/1.png";
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
        System.out.println(imagef);
            if (file != null) {
                System.out.println(file);
                imagef = file.getAbsolutePath();
                System.out.println(imagef);
                String s[]=imagef.split("\\\\");
                //System.out.println(imagef);
              //  System.out.println(s[s.length - 1]);
                imageup.setText(s[s.length - 1]);
               // File f= new File("src/main/file.image");

                // openFile(file);
                // where my problem is
               image1 = new Image(file.toURI().toString());


            }


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


            }else{
                FXMLScene scene = FXMLScene.load("TeamDashboard.fxml");
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
    void H(ActionEvent event) {

    }

    @FXML
    void vnear(ActionEvent event) {

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
    @FXML
    void Submit(ActionEvent event) {
        System.out.println("i am at add post");
        File file1 = new File(imagef);

        try {
            FileInputStream fis=new FileInputStream(file1);
            con=ConnectionDb.DBC();
            String st = "INSERT INTO diasterlist (Title,Type, Address, Division, District,AddInfo,Image) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(st);
            preparedStatement.setString(1, diastertitle.getText());
            preparedStatement.setString(2, diaster.getValue().toString());
            preparedStatement.setString(3, address.getText());
            preparedStatement.setString(4, division.getValue().toString());
            preparedStatement.setString(5, district.getValue().toString());
            preparedStatement.setString(6, address1.getText().toString());
            preparedStatement.setBinaryStream(7,fis,(int)file1.length());
            preparedStatement.execute();
            preparedStatement.close();
            con.close();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("AddPostConfirmation!");
            alert.setHeaderText("Your Post Added!\nNow this will be show on Timeline");
            // alert.setContentText("");
            File file = new File("src/main/Font/icon1.png");
            Image image = new Image(file.toURI().toString());
            stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(image);
            Optional<ButtonType> result=alert.showAndWait();
            System.out.println("THIK ASE INPUT");
        } catch (Exception e) {
            System.out.println("some error at add post/n"+e.getMessage());

        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String []division1={"Dhaka","Rajshahi","Chattogram","Barishal","Rangpur","Sylhet","Khulna", "Mymensingh"};
        division.getItems().addAll(division1);
        division.getSelectionModel().selectFirst();
        String []user={"EarthQuake","Storm Surge","Wildfire","Cyclone","Flood","Drought","Tsunami","Typhoon","LandSlide","Epidemic","Structural Collapse","Transport Disasters","Mining Accidents","Explosions and Fires","Others"};
        diaster.getItems().addAll(user);
        diaster.getSelectionModel().selectFirst();
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
