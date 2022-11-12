package Sign_UP;

import DB.ConnectionDb;
import Sign_in.Sign_inController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    private TextField pass;

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
        connection = (Connection) ConnectionDb.DB();
    }
    @FXML
    void Signin(ActionEvent event) {
        try {

            root = FXMLLoader.load(Sign_inController.class.getResource("Sign_in.fxml"));
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
        try {
            String st = "INSERT INTO userlist (Name,Username,Password,Division,District,DOB,ID,Gender,Volunteer,B.G.,Phone,Mail) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            preparedStatement = (PreparedStatement) connection.prepareStatement(st);
            preparedStatement.setString(1, name.getText());
            preparedStatement.setString(2, username.getText());
            preparedStatement.setString(3, pass.getText());
            preparedStatement.setString(4, cbdivision.getValue().toString());
            preparedStatement.setString(5, cbdistrict.getValue().toString());
            preparedStatement.setString(6,dob.getValue().toString());
            preparedStatement.setString(7, "1963890981");
            preparedStatement.setString(8, cbGender.getValue().toString());
            preparedStatement.setString(9, cbgroup.getValue().toString());
            preparedStatement.setString(10, bloodgroup.getValue().toString());
            preparedStatement.setString(11, phone.getText());
            preparedStatement.setString(12, mail.getText());
            preparedStatement.executeUpdate();
            connection.close();
        }catch (SQLException e) {

        }

        try {

            root = FXMLLoader.load(Sign_inController.class.getResource("Sign_in.fxml"));
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
    void Select(ActionEvent event) {
        String divisionname;
        try{
            divisionname=cbdivision.getSelectionModel().getSelectedItem().toString();
        }catch(Exception e ){
            divisionname="";
        }
        if(divisionname.equals("Dhaka")){
            cbdistrict.getItems().removeAll(cbdistrict.getItems());
            String []ditrict={"Dhaka","Gazipur","Chattogram","Barishal","Rangpur","Sylet","Khulna", "Maymensingh"};
            cbdistrict.getItems().addAll(ditrict);
        }else if(divisionname.equals("Rajshahi")){
            cbdistrict.getItems().removeAll(cbdistrict.getItems());

            String []ditrict={"Rajshahi","Sirajgong","Chattogram","Barishal","Rangpur","Sylet","Khulna", "Maymensingh"};
            cbdistrict.getItems().addAll(ditrict);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String []user={"User","Volunteer Team"};
        cb_sign_up.getItems().addAll(user);
        String []division={"Dhaka","Rajshahi","Chattogram","Barishal","Rangpur","Sylet","Khulna", "Maymensingh"};
        cbdivision.getItems().addAll(division);
        String []user1={"Male","Female","Others"};
        cbGender.getItems().addAll(user1);
        String []user2={"EarthQuake","Blood"};
        cbgroup.getItems().addAll(user2);
        String []user3={"A+","A-","B+","B-","AB+","AB-","O+","O-"};
        bloodgroup.getItems().addAll(user3);
    }
}
