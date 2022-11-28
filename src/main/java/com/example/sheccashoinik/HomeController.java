package com.example.sheccashoinik;

import Sign_in.Sign_inController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView backfont;
    @FXML
    private ImageView logo;

    @FXML
    private ImageView logo1;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("src/main/Font/logo.png");
        Image image = new Image(file.toURI().toString());
        //backfont.setImage(image);
        file = new File("src/main/Font/icon1.png");
        image = new Image(file.toURI().toString());
        logo.setImage(image);
        file = new File("src/main/Font/blacklogo.png");
        image = new Image(file.toURI().toString());
        logo1.setImage(image);
    }
    }
