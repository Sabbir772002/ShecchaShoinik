package Sign_UP;

import DB.ConnectionDb;
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
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;
import java.util.ResourceBundle;

public class SignupController implements Initializable {
    @FXML
    private ComboBox<String> bloodgroup;

    @FXML
    private ComboBox<String> cbdistrict;

    @FXML
    private ComboBox<String> cbdivision;

    @FXML
    private ComboBox<String> cbgroup;

    @FXML
    private ComboBox<String> cb_sign_up;

    @FXML
    private ComboBox<String> cbGender;

    @FXML
    private DatePicker dob;

    @FXML
    private TextField mail;

    @FXML
    private TextField name;

    @FXML
    private TextField password;

    @FXML
    private TextField phone;

    @FXML
    private TextField username;
    private Stage stage;
    private Scene scene;
    private Parent root;
    PreparedStatement preparedStatement;
    Connection connection;

    public SignupController() {
      //  ConnectionDb o=new ConnectionDb();

        connection = (Connection) ConnectionDb.DBC();
    }
    @FXML
    void Signin(ActionEvent event) {
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
    @FXML
    void Sign_up(ActionEvent event) {
        System.out.println("bhai aita ki hoilo");
        if(name.getText().isEmpty() || username.getText().isEmpty() || password.getText().isEmpty()||dob.getValue()==null|| cbdivision.getSelectionModel().isEmpty() ||cbdistrict.getSelectionModel().isEmpty() || cbgroup.getSelectionModel().isEmpty() || cbGender.getSelectionModel().isEmpty() || bloodgroup.getSelectionModel().isEmpty() || phone.getText().isEmpty() || mail.getText().isEmpty()){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Sign up Error!");
            alert.setHeaderText("Something went wrong!\nPlease try again with proper info.");
           // alert.setContentText("");
            File file = new File("src/main/Font/icon1.png");
            Image image = new Image(file.toURI().toString());
            stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(image);
            Optional<ButtonType> result=alert.showAndWait();
        }else {
            try {
                String st = "INSERT INTO userlist (Name,Username,Password,Division,District,DOB,ID,Gender,Volunteer,BG,Phone,Mail) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
                preparedStatement = (PreparedStatement) connection.prepareStatement(st);
                preparedStatement.setString(1, name.getText());
                preparedStatement.setString(2, username.getText());
                preparedStatement.setString(3, password.getText());
                preparedStatement.setString(4, cbdivision.getValue().toString());
                preparedStatement.setString(5, cbdistrict.getValue().toString());
                preparedStatement.setString(6, dob.getValue().toString());
                preparedStatement.setString(7, "1963890981");
                preparedStatement.setString(8, cbGender.getValue().toString());
                preparedStatement.setString(9, cbgroup.getValue().toString());
                preparedStatement.setString(10, bloodgroup.getValue().toString());
                preparedStatement.setString(11, phone.getText());
                preparedStatement.setString(12, mail.getText());
                preparedStatement.execute();
                preparedStatement.close();
                connection.close();
                System.out.println("THIK ASE INPUT");
               /* try{
                    Dashboard.FXMLScene scene =  Dashboard.FXMLScene.load("Profile.fxml");
                    Parent root = scene.root;
                    SigninController admin= (SigninController) scene.controller;
                    admin.set(username.getText().toString());
                    stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Post Diaster");
                    stage.show();
                }catch (Exception e){
                    System.out.println("vul hoilo profile button profile controller");
                }*/

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
    void Select(ActionEvent event) {
        String divisionname;
        try{
            divisionname=cbdivision.getSelectionModel().getSelectedItem().toString();
        }catch(Exception e ){
            divisionname="";
        }
        if(divisionname.equals("Dhaka")){
            cbdistrict.getItems().removeAll(cbdistrict.getItems());
            String []ditrict={"Dhaka","Gazipur","Faridpur","Gopalganj","Jamalpur","Kishoreganj","Madaripur","Manikganj","Munshiganj","Narayanganj","Narshingdi","Rajbari","Shariatpur","Tangail"};
            cbdistrict.getItems().addAll(ditrict);
        }else if(divisionname.equals("Rajshahi")){
            cbdistrict.getItems().removeAll(cbdistrict.getItems());

            String []ditrict={"Rajshahi","Sirajgonj","Bogra","Chapinawabganj","Joypurhat","Naogaon","Natore","Pabna"};
            cbdistrict.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Chattogram")){
            cbdistrict.getItems().removeAll(cbdistrict.getItems());

            String []ditrict={"Chattogram","Cox's Bazar", "Rangamati", "Bandarban", "Khagrachhari", "Feni", "Lakshmipur", "Comilla"," Noakhali", "Brahmanbaria" ,"Chandpur"};
            cbdistrict.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Barishal")){
            cbdistrict.getItems().removeAll(cbdistrict.getItems());

            String []ditrict={"Barishal", "Barguna", "Bhola", "Jhalokati", "Pirojpur","Patuakhali"};
            cbdistrict.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Sylhet")){
            cbdistrict.getItems().removeAll(cbdistrict.getItems());

            String []ditrict={"Sylhet","Habiganj","Moulvibazar","Sunamganj" };
            cbdistrict.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Mymensingh")){
            cbdistrict.getItems().removeAll(cbdistrict.getItems());

            String []ditrict={"Mymensingh","Jamalpur","Netrokona","Sherpur" };
            cbdistrict.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Khulna")){
            cbdistrict.getItems().removeAll(cbdistrict.getItems());

            String []ditrict={"Khulna","Bagherhat","Chuadanga","Jessore","Jinaidaha","Magura","Meherpur","Narail","Satkhira" };
            cbdistrict.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Rangpur")){
            cbdistrict.getItems().removeAll(cbdistrict.getItems());

            String []ditrict={"Rangpur","Kurigram","Gaibandha","Thakurgaon","Dinajpur","Nilphamari","Panchagarh","Lalmonirhat" };
            cbdistrict.getItems().addAll(ditrict);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String []user={"diasterlist","Volunteer Team"};
        cb_sign_up.getItems().addAll(user);
        String []division={"Dhaka","Rajshahi","Chattogram","Barishal","Rangpur","Sylhet","Khulna", "Mymensingh"};
        cbdivision.getItems().addAll(division);
        String []user2={"EarthQuake","Blood","Fire","Cyclone","Cidor","Others"};
        cbgroup.getItems().addAll(user2);
        String []user1={"Male","Female","Others"};
        cbGender.getItems().addAll(user1);

        String []user3={"A+","A-","B+","B-","AB+","AB-","O+","O-"};
        bloodgroup.getItems().addAll(user3);
    }
}
