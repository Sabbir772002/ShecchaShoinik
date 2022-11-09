package Sign_in;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Sign_inController implements Initializable {
    @FXML
    private ComboBox<String> sign_in_box;
    @FXML
    private ImageView user;
    @FXML
    private ImageView pass;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String items[]={"User", "Volunteer", "Volunteer Admin"};
        sign_in_box.getItems().addAll(items);
        File file = new File("src/main/image/user.png");
        Image image = new Image(file.toURI().toString());
        user.setImage(image);
        file = new File("src/main/image/pass.png");
        image = new Image(file.toURI().toString());
        pass.setImage(image);
    }
}
