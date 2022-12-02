package AdminDB;

import DB.ConnectionDb;
import Post.AddPostController;
import Sign_in.SigninController;
import UserProfile.ProfileController;
import com.example.sheccashoinik.Application;
import com.example.sheccashoinik.diaster;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class TeamDashboardController implements Initializable {

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

    private Stage stage;
    private Scene scene;
    private Parent root;
    public String username="";
    public String role="";


    public void set(String username,String role) {
        user.setText(username);
        rolee.setText("@"+role);
        this.role = role;
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
    private TableView<diaster> table;
    @FXML
    private TableColumn<diaster, String> col_address;

    @FXML
    private TableColumn<diaster, String> col_district;

    @FXML
    private TableColumn<diaster, String> col_title;

    @FXML
    private TableColumn<diaster, String> col_type;

    @FXML
    private TableColumn<diaster, Integer> col_id;

    ObservableList<diaster> listF;
    ObservableList<diaster> getdiasterList(){
        ObservableList<diaster> diasterlist1 = FXCollections.observableArrayList();


        return diasterlist1;
    }
    int indexM = -1;

    void loadtable(){
        col_title.setCellValueFactory(new PropertyValueFactory<diaster,String>("Title"));
        col_type.setCellValueFactory(new PropertyValueFactory<diaster,String>("Type"));
        col_district.setCellValueFactory(new PropertyValueFactory<diaster,String>("District"));
        col_address.setCellValueFactory(new PropertyValueFactory<diaster,String>("Address"));
        col_id.setCellValueFactory(new PropertyValueFactory<diaster,Integer>("Id"));

        //table.setItems(list);
        listF = ConnectionDb.getdiasterlist();
        table.setItems(listF);

    }

    @FXML
    void Dashboard(ActionEvent event) {
        loadtable();
        //System.out.println("vaiya ki khobor "+username);
        try{
            FXMLScene scene =  FXMLScene.load("TeamDashboard.fxml");
            Parent root = scene.root;
            TeamDashboardController admin= (TeamDashboardController) scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Post Diaster");
            stage.show();
        }catch (Exception e){
            System.out.println("vul hoilo team dashborad controller dashboard");
        }

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
            System.out.println("vul hoilo profile button profile controller");
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
               /* try {
                    //  FxmlLoader o = new FxmlLoader();
                    p = FXMLLoader.load(Profile.ProfileController.class.getResource("Profile.fxml"));

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
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Post Diaster");
            stage.show();


        }catch (Exception e ){

        }

    }

    @FXML
    void Homego(MouseEvent event) {

    }
    @FXML
    private Label rolee;

    @FXML
    private ImageView search;

    @FXML
    private Label user;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*user.setText(username);
        rolee.setText(role);*/
        String []choiceb={"Profile","Logout"};
        choice.getItems().addAll(choiceb);
        File file = new File("src/main/Font/user1.png");
        Image image = new Image(file.toURI().toString());
        imageview.setImage(image);
        File file1 = new File("src/main/Font/1.png");
        Image image1 = new Image(file1.toURI().toString());
        bimage.setImage(image1);
         file1 = new File("src/main/Font/logotext.png");
        Image image4 = new Image(file1.toURI().toString());
        logoimage.setImage(image4);
        file1 = new File("src/main/Font/icon1.png");
        Image image5 = new Image(file1.toURI().toString());
        imageview1.setImage(image5);
        file1 = new File("src/main/Font/search.png");
        Image image6 = new Image(file1.toURI().toString());
        search.setImage(image6);
        username= Application.oname;
        loadtable();

     //   choice.setOnAction(this::ChoiceClick);

    }
}
