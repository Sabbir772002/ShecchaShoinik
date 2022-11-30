package AdminDB;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class FxmlLoader {
    Pane p;

   public Pane getpane() {
        try {
            p = new FXMLLoader().load(Profile.ProfileController.class.getResource("Profile1.fxml"));
        } catch (Exception e) {

        }
        return p;

    }
}