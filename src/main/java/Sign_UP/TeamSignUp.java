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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class TeamSignUp implements Initializable {
Connection connection;
public TeamSignUp(){
    connection = ConnectionDb.DBC();
}
    @FXML
    private ComboBox<String> cbdistrict;

    @FXML
    private ComboBox<String > cbdivision;

    @FXML
    private ComboBox<String> cbgroup;

    @FXML
    private TextField mail;

    @FXML
    private TextField name;

    @FXML
    private TextField password;

    @FXML
    private TextField phone;

    @FXML
    private Button sign;

    @FXML
    private TextField username;
    @FXML
    void Sign_up(ActionEvent event) {
       Stage stage;

        if(name.getText().isEmpty() || username.getText().isEmpty() || password.getText().isEmpty()|| cbdivision.getSelectionModel().isEmpty() ||cbdistrict.getSelectionModel().isEmpty() || phone.getText().isEmpty() || mail.getText().isEmpty()){
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
            // Connection con;
            // con=DB.ConnectionDb.DBC();
            String sql = "SELECT * FROM Teams Where username = ?";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username.getText().toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Sign up Error!");
                    alert.setHeaderText("Username already taken!\nPlease use another one.");
                    // alert.setContentText("");
                    File file = new File("src/main/Font/icon1.png");
                    Image image = new Image(file.toURI().toString());
                    stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(image);
                    Optional<ButtonType> result = alert.showAndWait();

                } else {
                    try {
                        String st = "INSERT INTO Teams (Name,Username,Pass,Division,District,License,Type,Phone,Mail) VALUES (?,?,?,?,?,?,?,?,?)";
                       // String st1 = "INSERT INTO volunteer (Name,Username,Password,Division,District,DOB,ID,Gender,Volunteer,BG,Phone,Mail) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
                        preparedStatement = (PreparedStatement) connection.prepareStatement(st);
                        preparedStatement.setString(1, name.getText());
                        preparedStatement.setString(2, username.getText());
                        preparedStatement.setString(3, password.getText());
                        preparedStatement.setString(4, cbdivision.getValue().toString());
                        preparedStatement.setString(5, cbdistrict.getValue().toString());
                        preparedStatement.setString(6, cbdivision.getValue().toString().substring(0,3)+(int)(Math.random()*100)+10);
                        preparedStatement.setString(7, cbgroup.getValue().toString());
                        preparedStatement.setString(8, phone.getText());
                        preparedStatement.setString(9, mail.getText());
                        preparedStatement.execute();
                        preparedStatement.close();
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Sign Up Confirmation!");
                        alert.setHeaderText("Sign Up Successfully!\nPlease wait for admin contact to continue!\n" +
                                "We will notify you when your team Approved.");
                        // alert.setContentText("");
                        File file = new File("src/main/Font/icon1.png");
                        Image image = new Image(file.toURI().toString());
                        stage = (Stage) alert.getDialogPane().getScene().getWindow();
                        stage.getIcons().add(image);
                        Optional<ButtonType> result = alert.showAndWait();
                        Parent root = FXMLLoader.load(SigninController.class.getResource("Sign_in.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                       Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.setTitle("SIGN IN");
                        stage.show();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());

            }

        }

    }

    @FXML
    void Signin(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(SigninController.class.getResource("Sign_in.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("SIGN IN");
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
     @FXML
    void Select(ActionEvent event){
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
                    cbdistrict.getSelectionModel().select(0);

                }else if(divisionname.equals("Rajshahi")){
                cbdistrict.getItems().removeAll(cbdistrict.getItems());

                String []ditrict={"Rajshahi","Sirajgonj","Bogra","Chapinawabganj","Joypurhat","Naogaon","Natore","Pabna"};
                cbdistrict.getItems().addAll(ditrict);
                    cbdistrict.getSelectionModel().select(0);

                }
                else if(divisionname.equals("Chattogram")){
                cbdistrict.getItems().removeAll(cbdistrict.getItems());

                String []ditrict={"Chattogram","Cox's Bazar", "Rangamati", "Bandarban", "Khagrachhari", "Feni", "Lakshmipur", "Comilla"," Noakhali", "Brahmanbaria" ,"Chandpur"};
                cbdistrict.getItems().addAll(ditrict);
                    cbdistrict.getSelectionModel().select(0);

                }
                else if(divisionname.equals("Barishal")){
                cbdistrict.getItems().removeAll(cbdistrict.getItems());

                String []ditrict={"Barishal", "Barguna", "Bhola", "Jhalokati", "Pirojpur","Patuakhali"};
                cbdistrict.getItems().addAll(ditrict);
                    cbdistrict.getSelectionModel().select(0);

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
                    cbdistrict.getSelectionModel().select(0);

                }
                else if(divisionname.equals("Khulna")){
                cbdistrict.getItems().removeAll(cbdistrict.getItems());

                String []ditrict={"Khulna","Bagherhat","Chuadanga","Jessore","Jinaidaha","Magura","Meherpur","Narail","Satkhira" };
                cbdistrict.getItems().addAll(ditrict);
                    cbdistrict.getSelectionModel().select(0);

                }
                else if(divisionname.equals("Rangpur")){
                cbdistrict.getItems().removeAll(cbdistrict.getItems());

                String []ditrict={"Rangpur","Kurigram","Gaibandha","Thakurgaon","Dinajpur","Nilphamari","Panchagarh","Lalmonirhat" };
                cbdistrict.getItems().addAll(ditrict);
                    cbdistrict.getSelectionModel().select(0);

                }
                }

@Override
public void initialize(URL url, ResourceBundle resourceBundle) {
        String []division={"Dhaka","Rajshahi","Chattogram","Barishal","Rangpur","Sylhet","Khulna", "Mymensingh"};
        cbdivision.getItems().addAll(division);
        cbdivision.getSelectionModel().select(0);
    String []ditrict={"Dhaka","Gazipur","Faridpur","Gopalganj","Jamalpur","Kishoreganj","Madaripur","Manikganj","Munshiganj","Narayanganj","Narshingdi","Rajbari","Shariatpur","Tangail"};
    cbdistrict.getItems().addAll(ditrict);
    cbdistrict.getSelectionModel().select(0);
        String []user2={"EarthQuake","Storm Surge","Wildfire","Cyclone","Flood","Drought","Tsunami","Typhoon","LandSlide","Epidemic","Structural Collapse","Transport Disasters","Mining Accidents","Explosions and Fires","Others"};
        cbgroup.getItems().addAll(user2);
    ImageView i=new ImageView(new Image(new File("src/main/Font/add1.png").toURI().toString()));
        i.setFitHeight(27);
        i.setFitWidth(27);
        sign.setGraphic(i);
        }
        }

