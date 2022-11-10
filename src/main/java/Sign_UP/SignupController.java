package Sign_UP;

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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
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
    @FXML
    void Sign_up(ActionEvent event) {
        try {

            root = FXMLLoader.load(Sign_inController.class.getResource("Sign_in.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("SIGN_IN");
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
        String []user={"User","Volunteer"};
        cb_sign_up.getItems().addAll(user);
        String []division={"Dhaka","Rajshahi","Chattogram","Barishal","Rangpur","Sylet","Khulna", "Maymensingh"};
        cbdivision.getItems().addAll(division);
    }
}
