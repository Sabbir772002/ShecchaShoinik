package AdminDB;

import Dashboard.ProfileController;
import Sign_in.Sign_inController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
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
    @FXML
    private ImageView imageview1;

    @FXML
    private ImageView logoimage;

    @FXML
    void BbankClick(MouseEvent event) {

    }


    @FXML
    void Dashboard(ActionEvent event) {

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
    Pane p;

    @FXML
    void profile(ActionEvent event) {
        try {
          //  FxmlLoader o = new FxmlLoader();
            p=FXMLLoader.load(Profile.ProfileController.class.getResource("Profile.fxml"));
           // Pane p =o.getpane();
            pane1.setCenter(p);
            stage.setTitle("Profile");
           stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           /* scene = new Scene(root);
            stage.setScene(scene);*/
            stage.setTitle("Profile");
            stage.show();
            System.out.println("helloApplication");
        }catch (Exception e) {

        }

    }
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void ChoiceClick(MouseEvent event) {
        if(choice.getValue().toString().equals("Logout")){
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
    }
    @FXML
    void Choiceclick(ActionEvent event) {
        if(choice.getValue().toString().equals("Logout")){
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
        }else{
            try {
                //  FxmlLoader o = new FxmlLoader();
                p=FXMLLoader.load(Profile.ProfileController.class.getResource("Profile.fxml"));
                // Pane p =o.getpane();
                pane1.setCenter(p);
                stage.setTitle("Profile");
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           /* scene = new Scene(root);
            stage.setScene(scene);*/
                stage.setTitle("Profile");
                stage.show();
                System.out.println("helloApplication");
            }catch (Exception e) {

            }
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


     //   choice.setOnAction(this::ChoiceClick);

    }
}
