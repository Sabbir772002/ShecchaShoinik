package Sign_UP;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class FXMLScene {
    public Parent root = null;
    public Object controller = null;

    public static FXMLScene load(String fxmlpath) throws IOException {

        FXMLScene fxmlScene = new FXMLScene();

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(fxmlScene.getClass().getResource(fxmlpath));

        fxmlScene.root = fxmlLoader.load();
        fxmlScene.controller = fxmlLoader.getController();

        return fxmlScene;

    }
    public static FXMLLoader loadpane(String fxmlpath) throws IOException {

        FXMLScene fxmlScene = new FXMLScene();

        FXMLLoader fxmlLoader = new FXMLLoader(Profile.ProfileController.class.getResource(fxmlpath));
        //fxmlLoader.setLocation(fxmlScene.getClass().getResource(fxmlpath));

        //Pane p = fxmlLoader.load();
        fxmlScene.root= fxmlLoader.load();
        fxmlScene.controller = fxmlLoader.getController();

        return fxmlLoader;

    }
}