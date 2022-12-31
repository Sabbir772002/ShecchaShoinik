package com.example.sheccashoinik;

import AdminDB.HomeboardController;
import Sign_UP.TeamSignUp;
import Sign_in.SigninController;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    SliderThread sliderThread = new SliderThread();
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
    private Button Signinb;
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
    private  int i =0,f=1;

    @FXML
    void TeamSignup(ActionEvent event) {
        try {
            //fxmlLoader.setLocation(Sign_UP.TeamSignUp.class.getResource("TeamSignUp.fxml"));
          //  AnchorPane ap = fxmlLoader.load();
           // Sign_UP.TeamSignUp sadmin = fxmlLoader.getController();
            root = FXMLLoader.load(Sign_UP.TeamSignUp.class.getResource("TeamSignUp.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Team Sign Up");
            stage.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
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
    //int i=0;
    //@FXML
    void backjao(/*ActionEvent event*/) {
       // if(i==0)i=6;
      /*  if(i==0){
            translate(1,pane1,800);
           *//* pane1.setVisible(false);
            pane2.setVisible(false);
            pane3.setVisible(false);
            pane4.setVisible(false);
            pane5.setVisible(false);
            pane6.setVisible(false);
            pane7.setVisible(true);*//*
            System.out.println("back problem");

        }
        else*//* if(i==1){
           *//* pane1.setVisible(false);
            pane2.setVisible(false);
            pane3.setVisible(false);
            pane4.setVisible(false);
            pane5.setVisible(false);
            pane6.setVisible(false);
            pane7.setVisible(false);*//*
            translate(1,pane1,800);i--;

        }else*/
      /*  if(i==0){
           *//* pane1.setVisible(false);
            pane2.setVisible(true);
            pane3.setVisible(false);
            pane4.setVisible(false);
            pane5.setVisible(false);
            pane6.setVisible(false);
            pane7.setVisible(false);*//*
            translate(1,pane1,700);i++;
        }*/
        if(i==1){
            System.out.println(" backjao "+i+" pane2");
            f=1;

           /* pane1.setVisible(false);
            pane2.setVisible(true);
            pane3.setVisible(false);
            pane4.setVisible(false);
            pane5.setVisible(false);
            pane6.setVisible(false);
            pane7.setVisible(false);*/
            translate(0.5,pane2,900);i--;
        }else if(i==2){
            System.out.println(" backjao "+i+" pane3");

           /* pane1.setVisible(false);
            pane2.setVisible(false);
            pane3.setVisible(true);
            pane4.setVisible(false);
            pane5.setVisible(false);
            pane6.setVisible(false);
            pane7.setVisible(false);*/
            translate(0.5,pane3,900);i--;
        }else if(i==3){
            System.out.println(" backjao "+i+" pane4");

           /* pane1.setVisible(false);
            pane2.setVisible(false);
            pane3.setVisible(false);
            pane4.setVisible(true);
            pane5.setVisible(false);
            pane6.setVisible(false);*/
            //pane7.setVisible(false);
            translate(0.5,pane4,900);i--;
        }else if(i==4){
            System.out.println(" backjao "+i+" pane5");

            /*pane1.setVisible(false);
            pane2.setVisible(false);
            pane3.setVisible(false);
            pane4.setVisible(false);
            pane5.setVisible(true);
            pane6.setVisible(false);*/
           // pane7.setVisible(false);
            translate(0.5,pane5,900);i--;
        }else if(i==5){
            System.out.println(" back jao "+i+" pane6");

           /* pane1.setVisible(false);
            pane2.setVisible(false);
            pane3.setVisible(false);
            pane4.setVisible(false);
            pane5.setVisible(false);
            pane6.setVisible(true);*/
           // pane7.setVisible(false);
            //System.out.println("back problem");
            translate(0.5,pane6,900);i--;
        }

    }
    void backjao1(/*ActionEvent event*/) {

        if(i==1){
            System.out.println(" back jao1 "+i+" pane6");

            translate(0.5,pane6,900);i--;
        }else if(i==2){
            System.out.println(" back jao1 "+i+" pane5");
            translate(0.5,pane6,900);i--;

        }else if(i==3){
            System.out.println(" back jao1 "+i+" pane4");

            translate(0.5,pane4,900);i--;
        }else if(i==4){
            System.out.println(" back jao1 "+i+" pane3");

            translate(0.5,pane3,900);//i--;
        }/*else if(i==5){
            System.out.println(" backjao1 "+i+" pane2");

            translate(0.5,pane2,900);i--;
        }*/

    }

    //@FXML
    void fontjao(/*ActionEvent event*/) {

    //if(i==images.length-1)i=0;
   /* if(i==0){translate(1,pane1,-800);i++;}
    else*/ if(i==0){
            System.out.println(" frontjao "+i+" pane2");
            translate(0.5,pane2,-900);i++;
    }else if(i==1){
            System.out.println(" frontjao "+i+" pane3");
            translate(0.5,pane3,-903);i++;
    }else if(i==2){
            System.out.println(" frontjao "+i+" pane4");
            translate(0.5,pane4,-903);i++;
    }else if(i==3){
            System.out.println(" frontjao "+i+" pane5");
            translate(0.5,pane5,-902);i++;
    }else if(i==4){
            System.out.println(" frontjao "+i+" pane6");
        translate(0.5,pane6,-906);i++;
        f=0;
    }

    }
    void fontjao1(/*ActionEvent event*/) {

    //if(i==images.length-1)i=0;
   /* if(i==0){translate(1,pane1,-800);i++;}
    else*/ if(i==0){
            System.out.println(" frontjao1 "+i+" pane6");
        translate(0.5,pane6,-900);i++;
    }else if(i==1){
            System.out.println(" frontjao1 "+i+" pane5");
        translate(0.5,pane5,-903);i++;
    }else if(i==2){
            System.out.println(" frontjao1 "+i+" pane4");
        translate(0.5,pane4,-903);i++;
    }else if(i==3){
            System.out.println(" frontjao1 "+i+" pane3");
        translate(0.5,pane3,-902);i++;
    }else if(i==4){
            System.out.println(" frontjao1 "+i+" pane2");
            f=0;
        translate(0.5,pane2,-906);i++;
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

    class SliderThread extends Thread {
        /*public void translate(double duration,Node node, double width){
            TranslateTransition tr=new TranslateTransition(Duration.seconds(duration),node);
            tr.setByX(width);
            tr.play();
        }*/
        //  int i = 0;
        int flag = 1;

        public void run() {
            while (true) {
                try {
                    if (flag == 1 && f==1) {
                        //sleep(500);
                        fontjao();
                        // i++;
                        if (i == 5) {
                            i=0;
                            flag++;
                            //sleep(1000);
                        }
                        sleep(1000);

                    }else if(flag==2 && f==0){
                        fontjao1();
                        // i++;
                        if (i == 5) {
                            flag++;
                           // sleep(1000);
                        }
                        sleep(1000);


                    }
                    if(flag == 3){
                      //  if (f == 0){
                            backjao1();
                        //i--;
                        if (i == 0) {
                            i=5;
                            flag ++;
                        }

                        sleep(1000);
                    }else if(flag == 4) {
                        //  if (f == 0){
                        backjao();
                        //i--;
                        if (i == 0) {
                            flag = 1;
                        }
                        sleep(1000);
                    }
                    //}
                    // backjao();
                } catch (Exception e) {

                }
            }
        }
        /*public void run1(){
            try {
                while (true) {
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

                }
            } catch (Exception e){
                System.out.println("error");
                throw new RuntimeException(e.getMessage());

            }*/
     /*   }
    }*/
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
            //sliderThread.stop();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //sliderThread.stop();

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
    @FXML
    private ImageView loginimage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ImageView imageView = new ImageView(new Image(new File("src/main/Font/login0.png").toURI().toString()));
        imageView.setFitHeight(31);
        imageView.setLayoutX(240);
        imageView.setLayoutY(569);
        imageView.setFitWidth(35);
        Signinb.setGraphic(imageView);
        sliderThread.start();
       // loginimage.setImage(new Image(new File("src/main/Font/mlogin0.png").toURI().toString()));
        File file = new File("src/main/Font/logo.png");
        Image image0 = new Image(file.toURI().toString());
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
        //front.setImage(new Image(new File("src/main/Font/front.png").toURI().toString()));
        //back.setImage(new Image(new File("src/main/Font/back.png").toURI().toString()));
        //  translate(1,pane1,800);
       /* translate(1,pane2,800);
        translate(1,pane3,800);  translate(1,pane4,800);
        translate(1,pane5,800);  translate(1,pane6,800);
        translate(1,pane7,800);  translate(1,pane1,800);
        translate(1,pane2,800);  translate(1,pane3,800);
        translate(1,pane4,800);  translate(1,pane5,800);
        translate(1,pane6,800);
        translate(1,pane7,800);*/
        translate(0.5, pane2, 900);
        translate(0.5, pane3, 900);
        translate(0.5, pane4, 900);
        translate(0.5, pane5, 900);
        translate(0.5, pane6, 900);/* translate(1, pane2, 700);
        translate(1, pane3, 700);
        translate(1, pane4, 700);
        translate(1, pane5, 700);
        translate(1, pane6, 700);*/
    }
    }
