package Sign_in;

import AdminDB.AdminDashboardController;
import DB.ConnectionDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;



public class Sign_inController implements Initializable {
    Connection con;
    public Sign_inController() {
        con = ConnectionDb.DB();
        //System.out.println("thik ase vai");
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
    private Parent root;


    @FXML
    void sign_in(ActionEvent event) {

            if (logIn().equals("Success")) {
                try {
                    root = FXMLLoader.load(AdminDashboardController.class.getResource("AdminDashboard.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setTitle("Dashboard");
                    stage.show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

    }
    private String logIn() {
        String status = "Success";
        System.out.println( password.getText());
        String usern = username.getText();
        String passw = password.getText();
        if(usern.isEmpty() || passw.isEmpty()) {

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
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("SIGN UP");
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
