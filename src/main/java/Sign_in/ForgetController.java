package Sign_in;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.zip.InflaterInputStream;

public class ForgetController implements Initializable {

        @FXML
        private PasswordField mail;

        @FXML
        private ImageView pass;

        @FXML
        private Label passl;

        @FXML
        private Label selectl;

        @FXML
        private ComboBox<String> sign_in_box;

        @FXML
        private ImageView user;

        @FXML
        private Label userl;

        @FXML
        private TextField username;

        @FXML
        void forget(ActionEvent event) {

        }

        @FXML
        public void signin(ActionEvent event) {
                try {
                       Parent root = FXMLLoader.load(SigninController.class.getResource("Sign_in.fxml"));
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                         Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.setTitle("SIGN IN");
                        stage.show();
                }catch (Exception e) {
                        System.out.println(e.getMessage());
                }
        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            String role[]={"User","Team Leader"};
        sign_in_box.getItems().addAll(role);
    }
}
