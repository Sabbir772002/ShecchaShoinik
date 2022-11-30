package AdminDB;

import Dashboard.ProfileController;
import Post.AddPostController;
import Sign_in.SigninController;
import com.example.sheccashoinik.Application;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminDashboardController implements Initializable {

    @FXML
    private BorderPane pane1;

  /*  @FXML
    private Button Bbank;

    @FXML
    private Label Logo1;*/

    @FXML
    private ChoiceBox<String> choice;

    @FXML
    private ImageView imageview;
    @FXML
    private ImageView bimage;
    @FXML
    void BbankClick(ActionEvent event) {

    }
    @FXML
    private Button b;

    @FXML
    private Button bbutton;

   /* @FXML
    private ChoiceBox<?> choice;

    @FXML
    private ImageView imageview;
*/
    public String username="";


    public void set(String username) {
        this.username = username;
    }

    @FXML
    private ImageView imageview1;

    @FXML
    private ImageView logoimage;

    @FXML
    void BbankClick(MouseEvent event) {

    }
    @FXML
    private ScrollPane spane;



    @FXML
    void Dashboard(ActionEvent event) {
      /* *//* Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        // Step 2
        User u = (User) stage.getUserData();
        // Step 3
        String name = u.getname();*//*
       // String email = u.getEmail();*/
        System.out.println("vaiya ki khobor "+username);

    }

    @FXML
    void Diaster(ActionEvent event) throws IOException {



        //for cheking purposes only
                  /*  VBox vbox[]=new VBox[3];
                    for(int i =0;i<3;i++) {
                        p = FXMLLoader.load(SigninController.class.getResource("Sign_in.fxml"));
                        vbox[i]=new VBox();
                        vbox[i].getChildren().add(p);
                        *//*stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.setTitle("SIGN IN");
                        stage.show();*//*

                    }
                    //AnchorPane apane = new AnchorPane();
                    HBox a = new HBox();
                    a.getChildren().add(vbox);
                    pane1.setCenter(vbox);
            */


    }

    @FXML
    void F(ActionEvent event) {

    }

    @FXML
    void G(ActionEvent event) {

    }

    @FXML
    void H(ActionEvent event) {

    }

    @FXML
    void Vnear(ActionEvent event) {

    }


    @FXML
    void chat(ActionEvent event) {

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
    void profile(ActionEvent event) {
       /* try {
            System.out.println("ok");

          //Pane p = FXMLScene.loadpane("Profile1.fxml");
            FXMLLoader fxmlLoader = FXMLScene.loadpane("Profile1.fxml");
            p=fxmlLoader.load();
            //Parent root = scene.root;
            //p = FXMLLoader.load(getClass().getResource("Profile1.fxml"));
            // p=(Pane)scene;
           // FXMLLoader fxmlLoader = (FXMLLoader) (this.p.getScene().getUserData());
            AdminDashboardController controller = (AdminDashboardController) fxmlLoader.getController();
         //  AdminDashboardController adminController = (AdminDashboardController) scene.controller;
            controller.set(username+" vai");
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            //stage.setScene(new Scene(root));
            stage.setTitle("Profile");
            pane1.setCenter(p);
            stage.show();
        }
        catch (IOException e) {
            System.out.println("error vai \n"+e);

        }*/
        /*try {
            System.out.println("ok");

            *//*FXMLScene scene = FXMLScene.load("Profile1.fxml");
            Parent root = scene.root;*//*
            p = FXMLLoader.load(Dashboard.ProfileController.class.getResource("Profile1.fxml"));
           // p=(Pane)scene;
            pane1.setCenter(p);
           // AdminDashboardController adminController = (AdminDashboardController) scene.controller;
           // adminController.set(username);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            //stage.setScene(new Scene(root));
            stage.setTitle("Profile");
            stage.show();
        }
        catch (Exception e) {

        }*/




            try {
                // FXMLLoader o = new FXMLLoader(Profile.ProfileController.class.getResource("Profile1.fxml"));
                p = FXMLLoader.load(Profile.ProfileController.class.getResource("Profile.fxml"));
                pane1.setCenter(p);
                stage.setTitle("Profile");
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                stage.setTitle("Profile");
                stage.show();
               // System.out.println("helloApplication");
            } catch (Exception e) {

            }
        }


    private Stage stage;
    private Scene scene;
    private Parent root;

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
                  /* root = FXMLLoader.load(ProfileController.class.getResource("Profile1.fxml"));
                   stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                   scene = new Scene(root);
                   stage.setScene(scene);
                   stage.setTitle("SIGN IN");
                   stage.show();*/
                   FXMLScene scene =  AdminDB.FXMLScene.load("Profile1.fxml");
                   Parent root = scene.root;
                   ProfileController adminController = (ProfileController) scene.controller;
                   //adminController.set(usern);
                   stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                   stage.setScene(new Scene(root));
                   stage.setTitle("Dashboard");
                   stage.show();

               }catch (Exception e){

               }
               /* try {
                    //  FxmlLoader o = new FxmlLoader();
                    p = FXMLLoader.load(Profile.ProfileController.class.getResource("Profile1.fxml"));

                    pane1.setCenter(p);
                    stage.setTitle("Profile");
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                   stage.setScene(scene);
                    stage.setTitle("Profile");
                    stage.show();
                    System.out.println("helloApplication");
                } catch (Exception e) {

                }*/
            }

    }
    @FXML
    void addpost(ActionEvent event) {
        System.out.println("hello");
        try{
            Post.FXMLScene scene =  Post.FXMLScene.load("AddPost.fxml");
            Parent root = scene.root;
            AddPostController admin= (AddPostController) scene.controller;
            admin.set(username);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Post Diaster");
            stage.show();

          /*  root = FXMLLoader.load(AddPostController.class.getResource("AddPost.fxml"));

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("SIGN IN");
            stage.show();*/

        }catch (Exception e ){

        }

    }

    @FXML
    void Homego(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String []choiceb={"Profile","Logout"};
        choice.getItems().addAll(choiceb);
        File file = new File("src/main/Font/user1.png");
        Image image = new Image(file.toURI().toString());
        imageview.setImage(image);
        File file1 = new File("src/main/Font/1297136.png");
        Image image1 = new Image(file1.toURI().toString());
        bimage.setImage(image1);
         file1 = new File("src/main/Font/logotext.png");
        Image image4 = new Image(file1.toURI().toString());
        logoimage.setImage(image4);
        file1 = new File("src/main/Font/icon1.png");
        Image image5 = new Image(file1.toURI().toString());
        imageview1.setImage(image5);
        username= Application.oname;

     //   choice.setOnAction(this::ChoiceClick);

    }
}
