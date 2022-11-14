package Sign_in;

import AdminDB.AdminDashboardController;
import AdminDB.FXMLScene;
import DB.ConnectionDb;
import Profile.ProfileController;
import com.example.sheccashoinik.Application;
import com.example.sheccashoinik.User;
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
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;

public class Sign_inController implements Initializable {
    Connection con;
    public Sign_inController() {
        con = ConnectionDb.DB();
        System.out.println("thik ase vai koibar bolboo");
    }
    @FXML
    private ComboBox<String> sign_in_box;
    @FXML
    private ImageView user;
    @FXML
    private ImageView pass;
    @FXML
    private PasswordField password;

    @FXML
    private TextField username;
    private Stage stage;

    private Scene scene;
     Parent root;
    String usern="";
    AdminDashboardController ad=new AdminDashboardController();



    @FXML
    void sign_in(ActionEvent event) {
   Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
       User u=new User();
       u.setname(usern);
            if (logIn().equals("Success")) {
                try {

                    FXMLScene scene =  FXMLScene.load("AdminDashboard.fxml");
                    Parent root = scene.root;
                    AdminDashboardController adminController = (AdminDashboardController) scene.controller;
                    adminController.set(usern);
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Dashboard");
                    stage.show();


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Sign in Error!");
                alert.setHeaderText("Please input correct info or Sign Up");
                File file = new File("src/main/Font/icon1.png");
                Image image = new Image(file.toURI().toString());
                stage = (Stage) alert.getDialogPane().getScene().getWindow();
                stage.getIcons().add(image);
                alert.initOwner(stage1);
                //alert.setGraphic(new ImageView(image));
                //user.setImage(image);
                Optional<ButtonType> result=alert.showAndWait();

            }

    }
    private String logIn() {
        String status = "Success";
        System.out.println( password.getText());
         usern = username.getText();
        ad.set(usern);
        String passw = password.getText();
        if(usern.isEmpty() || passw.isEmpty()) {
            //status = "Success";
            status = "Error";
        } else {
           // System.out.println("Inbox");
            String sql = "SELECT * FROM userlist Where username = ? and password = ?";
            try {
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, usern);
                preparedStatement.setString(2, passw);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                   // status = "Success";
                    status = "Error";
                } else {

                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                status = "Exception";
            }
        }

        return status;
    }


    @FXML
    void sign_up(ActionEvent event) {
        try {
            root = FXMLLoader.load(Sign_UP.SignupController.class.getResource("Sign_UP.fxml"));
            // root = FXMLLoader.load(ProfileController.class.getResource("Profile.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Profile");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String items[]={"User","Volunteer Leader","Admin"};
        sign_in_box.getItems().addAll(items);
        File file = new File("src/main/Font/user-fill.png");
        Image image = new Image(file.toURI().toString());
        user.setImage(image);
        file = new File("src/main/Font/lock-outline.png");
        image = new Image(file.toURI().toString());
        pass.setImage(image);
    }
}
