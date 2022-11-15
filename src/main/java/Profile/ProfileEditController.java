package Profile;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileEditController implements Initializable {
    @FXML
    private ImageView back;
    @FXML
    private ImageView image10;
    @FXML
    private ImageView cirimage;

    @FXML
    private ImageView heart;

    @FXML
    private ImageView image;

    @FXML
    private ImageView image100;

    @FXML
    private Circle image2;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("src/main/Font/guy.png");
        Image image = new Image(file.toURI().toString());
        cirimage.setImage(image);
        file = new File("src/main/Font/-heart-icon-.png");
        image = new Image(file.toURI().toString());
        heart.setImage(image);
        file = new File("src/main/Font/menu-vector-icon-.png");
        image = new Image(file.toURI().toString());
        image100.setImage(image);
        file = new File("src/main/Font/icon1.png");
        image = new Image(file.toURI().toString());
        image10.setImage(image);
        file = new File("src/main/Font/Angle_left_font_.png");
        image = new Image(file.toURI().toString());
        back.setImage(image);
    }
}
