package Post;

import AdminDB.FXMLScene;
import com.example.sheccashoinik.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import AdminDB.*;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class AddPostController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextArea address;

    @FXML
    private TextArea address1;

    @FXML
    private Button b;

    @FXML
    private Button bbutton;

    @FXML
    private ImageView bimage;

    @FXML
    private ChoiceBox<String> choice;

    @FXML
    private TextArea diastertitle;

    @FXML
    private ComboBox<?> district;

    @FXML
    private ComboBox<?> district1;

    @FXML
    private ComboBox<?> district2;

    @FXML
    private ImageView imageview;

    @FXML
    private ImageView imageview1;

    @FXML
    private ImageView logoimage;

    @FXML
    private BorderPane pane1;

    @FXML
    void BbankClick(MouseEvent event) {

    }

    @FXML
    void ChoiceClick(MouseEvent event) {

    }

    @FXML
    void Choiceclick(ActionEvent event) {

    }

    @FXML
    void Dashboard(ActionEvent event) {
        try{
          AdminDB.FXMLScene scene =  AdminDB.FXMLScene.load("AdminDashboard.fxml");
            Parent root = scene.root;
            AdminDashboardController adminController = (AdminDashboardController) scene.controller;
            adminController.set(username);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Dashboard");
            stage.show();
        }catch(Exception e){

        }

    }

    @FXML
    void Diaster(ActionEvent event) {

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
    void addpost(ActionEvent event) {

    }

    @FXML
    void chat(ActionEvent event) {

    }

    @FXML
    void logout(ActionEvent event) {

    }

    @FXML
    void profile(ActionEvent event) {

    }
    public String username="";


    public void set(String username) {
        this.username = username;
        System.out.println(username);
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
