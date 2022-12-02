package com.example.sheccashoinik;

import Sign_in.SigninController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private ImageView image;
    @FXML
    private ImageView image1;

    String images[]={
            "src/main/Font/Hand.png",
            "src/main/Font/1.jpg",
            "src/main/Font/2.jpg",
            "src/main/Font/2.jpg",
            "src/main/Font/3.jpg",
            "src/main/Font/4.jpg",
            "src/main/Font/5.jpg",
            "src/main/Font/6.jpg",
            "src/main/Font/HelpCar.jpg",
            //  "src/main/Font/1.png",
            /*"src/main/Font/group2.png",
            "src/main/Font/group1.png",
            "src/main/Font/1.png",
            "src/main/Font/2.png",
            "src/main/Font/HelpCar.jpg",
            "src/main/Font/donate.png",
            "src/main/Font/blood.png"*/};


    class SliderThread extends Thread{
        int i = 0;
        public void run(){
            try {
                while (true){
                    image.setLayoutX(image.getFitWidth());

                    if(i>=images.length)i=0;
                    if(i==0/*||i==8*/){image1.setVisible(true);image1.setImage(new Image(new File(images[i]).toURI().toString()));image.setVisible(false);}
                        else {image.setVisible(true);image.setImage(new Image(new File(images[i]).toURI().toString()));image1.setVisible(false);}
                    sleep(500); //1 sec
                    i++;
                }
            }
            catch (Exception e){
                System.out.println("error");
                throw new RuntimeException(e.getMessage());

            }
        }
    }

    @FXML
    void createvt(ActionEvent event) {

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
        SliderThread sliderThread = new SliderThread();
        sliderThread.start();

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
