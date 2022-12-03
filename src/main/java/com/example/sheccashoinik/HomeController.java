package com.example.sheccashoinik;

import Sign_in.SigninController;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

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
    private ImageView front;
    @FXML
    private ImageView back;

    @FXML
    private ImageView logo1;
    @FXML
    private ImageView image;
    @FXML
    private ImageView image1;
    @FXML
    private ImageView image2;
    @FXML
    private AnchorPane pane1;

    @FXML
    private AnchorPane pane2;
    @FXML
    private ImageView image3;
    @FXML
    private AnchorPane pane3;
    @FXML
    private ImageView image4;
    @FXML
    private AnchorPane pane4;
    @FXML
    private ImageView image5;
    @FXML
    private AnchorPane pane5;
    @FXML
    private ImageView image6;
    @FXML
    private AnchorPane pane6;
    @FXML
    private ImageView image7;
    @FXML
    private AnchorPane pane7;

    String images[]={
            //"src/main/Font/Hand.png",
            "src/main/Font/1.jpg",
            "src/main/Font/2.jpg",
           // "src/main/Font/2.png",
            "src/main/Font/3.jpg",
            "src/main/Font/4.jpg",
            "src/main/Font/5.jpg",
            "src/main/Font/6.jpg",
            //"src/main/Font/HelpCar.jpg",
            //  "src/main/Font/1.png",
            /*"src/main/Font/group2.png",
            "src/main/Font/group1.png",
            "src/main/Font/1.png",
            "src/main/Font/2.png",
            "src/main/Font/HelpCar.jpg",
            "src/main/Font/donate.png",
            "src/main/Font/blood.png"*/};
   /* int i=0;
   // while(true){
        // image.setLayoutX(image.getFitWidth());

        if (i >= images.length) i = 0;
        *//* if(i==0*//**//*||i==8*//**//*){
                        image1.setVisible(true);
                        image1.setImage(new Image(new File(images[i]).toURI().toString()));
                        image.setVisible(false);
                        image2.setVisible(false);
                    }
                        else {*//*
        if (i % 2 == 0) {
            image.setVisible(true);
            image.setImage(new Image(new File(images[i]).toURI().toString()));
            image1.setVisible(false);
            translate(1, pane1, -400);
            //translate(1, pane2, +200);

        } else {
            image2.setVisible(true);
            image2.setImage(new Image(new File(images[i]).toURI().toString()));
            image1.setVisible(false);
            translate(1, pane2, 400);
            //translate(1, pane1, -20);
        }

        if (i % 2 == 0) {
            // translate(1, pane1, -50);


        } else {
            //translate(1, pane2, +50);

        }
        //translate(0.5, image, -829);
        // sleep(500); //1 sec
        i++;

    //}*/
    int i=0;
    @FXML
    void backjao(ActionEvent event) {
       // if(i==0)i=6;
        if(i==0){
            translate(1,pane7,800);i=6;
            pane1.setVisible(false);
            pane2.setVisible(false);
            pane3.setVisible(false);
            pane4.setVisible(false);
            pane5.setVisible(false);
            pane6.setVisible(false);
            pane7.setVisible(true);
            System.out.println("back problem");

        }
        else if(i==1){
            pane1.setVisible(false);
            pane2.setVisible(false);
            pane3.setVisible(false);
            pane4.setVisible(false);
            pane5.setVisible(false);
            pane6.setVisible(false);
            pane7.setVisible(false);
            translate(1,pane1,800);i=0;
        }else if(i==2){
            pane1.setVisible(false);
            pane2.setVisible(true);
            pane3.setVisible(false);
            pane4.setVisible(false);
            pane5.setVisible(false);
            pane6.setVisible(false);
            pane7.setVisible(false);
            translate(1,pane2,800);i=1;
        }else if(i==3){
            pane1.setVisible(false);
            pane2.setVisible(false);
            pane3.setVisible(true);
            pane4.setVisible(false);
            pane5.setVisible(false);
            pane6.setVisible(false);
            pane7.setVisible(false);
            translate(1,pane3,800);i=2;
        }else if(i==4){
            pane1.setVisible(false);
            pane2.setVisible(false);
            pane3.setVisible(false);
            pane4.setVisible(true);
            pane5.setVisible(false);
            pane6.setVisible(false);
            //pane7.setVisible(false);
            translate(1,pane4,800);i=3;
        }else if(i==5){
            pane1.setVisible(false);
            pane2.setVisible(false);
            pane3.setVisible(false);
            pane4.setVisible(false);
            pane5.setVisible(true);
            pane6.setVisible(false);
           // pane7.setVisible(false);
            translate(1,pane5,800);i=4;
        }else if(i==6){
            pane1.setVisible(false);
            pane2.setVisible(false);
            pane3.setVisible(false);
            pane4.setVisible(false);
            pane5.setVisible(false);
            pane6.setVisible(true);
           // pane7.setVisible(false);
            //System.out.println("back problem");
            translate(1,pane6,800);i=5;
        }

    }

    @FXML
    void fontjao(ActionEvent event) {

    //if(i==images.length-1)i=0;
    if(i==0){translate(1,pane1,-800);i=1;}
    else if(i==1){
        translate(1,pane2,-800);i=2;
    }else if(i==2){
        translate(1,pane3,-800);i=3;
    }else if(i==3){
        translate(1,pane4,-800);i=4;
    }else if(i==4){
        translate(1,pane5,-800);i=5;
    }else if(i==5){
        translate(1,pane6,-800);i=0;
    }/*else if(i==6){
        System.out.println("back problem nai");
        translate(1,pane7,-800);i=0;
    }*/

    }
    public void translate(double duration,Node node, double width){
        TranslateTransition tr=new TranslateTransition(Duration.seconds(duration),node);
        tr.setByX(width);
        tr.play();
    }

    class SliderThread extends Thread{
        public void translate(double duration,Node node, double width){
            TranslateTransition tr=new TranslateTransition(Duration.seconds(duration),node);
            tr.setByX(width);
            tr.play();
        }
        int i = 0;
        public void run(){
            try {
                while (true) {
                    // image.setLayoutX(image.getFitWidth());

                    if (i >= images.length) i = 0;
                    /* if(i==0*//*||i==8*//*){
                        image1.setVisible(true);
                        image1.setImage(new Image(new File(images[i]).toURI().toString()));
                        image.setVisible(false);
                        image2.setVisible(false);
                    }
                        else {*/
                    if (i % 2 == 0) {
                        image.setVisible(true);
                        image.setImage(new Image(new File(images[i]).toURI().toString()));
                        image1.setVisible(false);
                        translate(1, pane1, -400);
                        //translate(1, pane2, +200);

                    } else {
                        image2.setVisible(true);
                        image2.setImage(new Image(new File(images[i]).toURI().toString()));
                        image1.setVisible(false);
                        translate(1, pane2, 400);
                        //translate(1, pane1, -20);
                    }

                    if (i % 2 == 0) {
                       // translate(1, pane1, -50);


                    } else {
                        //translate(1, pane2, +50);

                    }
                    //translate(0.5, image, -829);
                   // sleep(500); //1 sec
                    i++;

                }
            } catch (Exception e){
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
       /* SliderThread sliderThread = new SliderThread();
        sliderThread.start();*/

        File file = new File("src/main/Font/logo.png");
        Image image0 = new Image(file.toURI().toString());
        //backfont.setImage(image);
        file = new File("src/main/Font/icon1.png");
        image0 = new Image(file.toURI().toString());
        logo.setImage(image0);
        file = new File("src/main/Font/blacklogo.png");
        image0 = new Image(file.toURI().toString());
        logo1.setImage(image0);
        image.setImage(new Image(new File(images[0]).toURI().toString()));
        image2.setImage(new Image(new File(images[1]).toURI().toString()));
        image3.setImage(new Image(new File(images[2]).toURI().toString()));
        image4.setImage(new Image(new File(images[3]).toURI().toString()));
        image5.setImage(new Image(new File(images[4]).toURI().toString()));
        image6.setImage(new Image(new File(images[5]).toURI().toString()));
        //image7.setImage(new Image(new File(images[6]).toURI().toString()));
        front.setImage(new Image(new File("src/main/Font/front.png").toURI().toString()));
        back.setImage(new Image(new File("src/main/Font/back.png").toURI().toString()));
        translate(1,pane1,800);
       /* translate(1,pane2,800);
        translate(1,pane3,800);  translate(1,pane4,800);
        translate(1,pane5,800);  translate(1,pane6,800);
        translate(1,pane7,800);  translate(1,pane1,800);
        translate(1,pane2,800);  translate(1,pane3,800);
        translate(1,pane4,800);  translate(1,pane5,800);
        translate(1,pane6,800);
        translate(1,pane7,800);*/
    }
    }
