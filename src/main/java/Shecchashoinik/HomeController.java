package Shecchashoinik;

import Sign_in.Sign_inController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void createvt(ActionEvent event) {

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
    void SignUp (ActionEvent event) {
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
}