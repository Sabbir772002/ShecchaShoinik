package com.example.sheccashoinik;

import AdminDB.Back;
import AdminDB.FXMLScene;
import Chat.CommunityChatHandelar;
import Others.HelpResponseController;
import Others.TaskCompletedController;
import Post.AddPostController;
import Sign_in.SigninController;
import UserProfile.ProfileController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Optional;


public class FunctionCode {
    String username;
    String role;
    private Stage stage;
/*
    @FXML
    void Dashboard(ActionEvent event) {
        //loadtable();
        //System.out.println("vaiya ki khobor "+username);
        try{
            //FXMLScene scene = FXMLScene.load("UserDashboard.fxml");
            AdminDB.FXMLScene scene = FXMLScene.load("BackgroundDesign.fxml");
            Parent root = scene.root;
            //AdminDashboardController adminController = (AdminDashboardController) scene.controller;
            Back adminController = (Back) scene.controller;
            adminController.set(username, role);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("UserProfile");
            stage.show();
        }catch(Exception e){
            System.out.println("vul hoilo Dashboard button userdashboard controller");
        }
    }
    @FXML
    void Diaster(ActionEvent event) throws IOException {

    }
    @FXML
    void G(ActionEvent event) {}

    @FXML
    void Event(ActionEvent event) {

    }

    @FXML
    void hrequest(ActionEvent event) {



    }
    @FXML
    void hresponse(ActionEvent event) {
        try{
            Others.FXMLScene scene =  Others.FXMLScene.load("HelpResponse.fxml");
            Parent root = scene.root;
            HelpResponseController admin= (HelpResponseController) scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Help Response");
            stage.show();
        }catch (Exception e){
            System.out.println("Bhul hoilo team dashboard button Help response controller "+e.getMessage());
        }


    }

    @FXML
    void task(ActionEvent event) {
        try{
            Others.FXMLScene scene =  Others.FXMLScene.load("TaskCompleted.fxml");
            Parent root = scene.root;
            TaskCompletedController admin= (TaskCompletedController) scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Task Completed");
            stage.show();
        }catch (Exception e){
            System.out.println("bhul hoilo team dashboard button G controller "+e.getMessage());
        }

    }

    @FXML
    void vapprove(ActionEvent event) {
        try{
            Others.FXMLScene scene =  Others.FXMLScene.load("VolunteerApprove.fxml");
            Parent root = scene.root;
            System.out.println("tao run hoi na");
            Others.VolunteerApproveController admin= (Others.VolunteerApproveController) scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Volunteer Approve");
            stage.show();
        }catch (Exception e){
            System.out.println("Bhul hoilo V approve button Team controller "+e.getMessage());
        }

    }

    @FXML
    void vnear(ActionEvent event) {
        try{
            Shoinik.FXMLScene scene =  Shoinik.FXMLScene.load("Volunteerfromarea.fxml");
            Parent root = scene.root;
            Shoinik.VolunteerfromareaController admin= (Shoinik.VolunteerfromareaController) scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Volunteer Near Me");
            stage.show();
        }catch(IOException e){
            System.out.println("vul hoilo F button userdashboard controller "+e.getMessage());
        }

    }




    @FXML
    void chat(ActionEvent event) {
        try{
            Chat.FXMLScene scene =Chat.FXMLScene.load("CommunityChat.fxml");
            Parent root = scene.root;
            //System.out.println("chat cole na");
            CommunityChatHandelar admin= (CommunityChatHandelar) scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Chat");
            stage.show();
        }catch (Exception e){
            System.out.println("vul hoilo chat button Userdashboard controller "+e.getMessage());
        }


    }

    @FXML
    void logout(ActionEvent event) {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Logout Confirmation");
            alert.setHeaderText("Are you sure you want to log out?");
            File file = new File("src/main/Font/icon1.png");
            Image image = new Image(file.toURI().toString());
            stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(image);
            // alert.initOwner(stage);
            //alert.setGraphic(new ImageView(image));
            //user.setImage(image);
            Optional<ButtonType> result=alert.showAndWait();
            if(alert.getResult().getText().equals("OK")){
                root = FXMLLoader.load(SigninController.class.getResource("Sign_in.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("SIGN IN");
                stage.show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    Pane p;

    @FXML
    void BbankClick(ActionEvent event){

    }
    @FXML
    void profile(ActionEvent event) {

        try{
            UserProfile.FXMLScene scene =  UserProfile.FXMLScene.load("Profile.fxml");
            Parent root = scene.root;
            ProfileController admin= (ProfileController) scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Profile");
            stage.show();
        }catch (Exception e){
            System.out.println("vul hoilo profile button Userdashboard controller "+e.getMessage());
        }

    }



    @FXML
    void ChoiceClick(MouseEvent event) {
        if(choice.getValue().toString().equals("Logout")){
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
    }
    @FXML
    void Choiceclick(ActionEvent event) {
        if(choice.getValue().toString().equals("Logout")){
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Logout Confirmation");
                alert.setHeaderText("Are you sure you want to log out?");
                File file = new File("src/main/Font/icon1.png");
                Image image = new Image(file.toURI().toString());
                stage = (Stage) alert.getDialogPane().getScene().getWindow();
                stage.getIcons().add(image);
                // alert.initOwner(stage);
                //alert.setGraphic(new ImageView(image));
                //user.setImage(image);
                Optional<ButtonType> result=alert.showAndWait();
                if(alert.getResult().getText().equals("OK")){
                    root = FXMLLoader.load(SigninController.class.getResource("Sign_in.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setTitle("SIGN IN");
                    stage.show();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            try{

                UserProfile.FXMLScene scene =  UserProfile.FXMLScene.load("Profile.fxml");
                Parent root = scene.root;
                ProfileController adminController = (ProfileController) scene.controller;
                adminController.set(username,role);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Profile");
                stage.show();

            }catch (Exception e){

            }
        }

    }
    @FXML
    void addpost(ActionEvent event) {
        System.out.println("hello");
        try{
            Post.FXMLScene scene =  Post.FXMLScene.load("AddPost.fxml");
            Parent root = scene.root;
            AddPostController admin= (AddPostController) scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Post Diaster");
            stage.show();


        }catch (Exception e ){

        }

    }*/
}
