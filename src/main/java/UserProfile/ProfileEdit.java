package UserProfile;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProfileEdit extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("UserProfile.fxml"));
        primaryStage.setTitle("Profile Settings");
        primaryStage.setScene(new Scene(root,900,740));
        primaryStage.show();

    }
}

