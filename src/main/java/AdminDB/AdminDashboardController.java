package AdminDB;

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
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashboardController implements Initializable {
    @FXML
    private Button Bbank;

    @FXML
    private Label Logo;

    @FXML
    private ChoiceBox<String> choice;

    @FXML
    private ImageView imageview;
    @FXML
    private ImageView bimage;
    @FXML
    void BbankClick(ActionEvent event) {

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
        }

    }

    @FXML
    void Homego(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String []choiceb={"Profile","Logout"};
        choice.getItems().addAll(choiceb);
        File file = new File("src/main/Font/user.png");
        Image image = new Image(file.toURI().toString());
        imageview.setImage(image);
        File file1 = new File("src/main/Font/1297136.png");
        Image image1 = new Image(file1.toURI().toString());
        bimage.setImage(image1);
     //   choice.setOnAction(this::ChoiceClick);

    }
}
