package News;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import DB.ConnectionDb;
import Map.FXMLScene;
import com.example.sheccashoinik.disaster;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import java.lang.annotation.Inherited;
import java.net.URL;
import java.util.ResourceBundle;

public class News implements Initializable {
    @FXML
     WebView view;
    WebEngine engine;

    @FXML
    void aja(ActionEvent event) {

        WebEngine engine=view.getEngine();
        engine.load("https://en.prothomalo.com/topic/Natural-disaster");
    }

    @FXML
    void dstar(ActionEvent event) {

    }

    @FXML
    void ient(ActionEvent event) {

    }

    @FXML
    void palo(ActionEvent event) {
        WebEngine engine=view.getEngine();
        engine.load("https://en.prothomalo.com/topic/Natural-disaster");
        String s="<html>\n" +
                "\n" +
                "<body>\n" +
                "\n" +
                "\n" +
                "    <iframe src=\"https://en.prothomalo.com/topic/Natural-disaster\" name=\"iframe_b\" height=\"700px\" width=\"100%\" title=\"Iframe Example\"></iframe>\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "</html>";
      // engine.load("https://en.prothomalo.com/topic/Natural-disaster");
    }

    @FXML
    void theg(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
   WebEngine engine=view.getEngine();
        String s="<html>\n" +
                "\n" +
                "<body>\n" +
                "\n" +
                "\n" +
                "    <iframe src=\"https://en.prothomalo.com/topic/Natural-disaster\" name=\"iframe_b\" height=\"700px\" width=\"100%\" title=\"Iframe Example\"></iframe>\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "</html>";
       engine.loadContent(s);
        System.out.println("hello");
    }
}
