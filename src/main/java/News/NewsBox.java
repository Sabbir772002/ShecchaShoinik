package News;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class NewsBox implements Initializable {
    String s;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public String username="";
    public String role="";
    BorderPane pane;
    int id;
    Connection con;
    @FXML
    private WebView view;
    @FXML
    void aja(ActionEvent event) {
        this.pane = pane;
     /*   String s="<html>\n" +
                "\n" +
                "<body>\n" +
                "\n" +
                "\n" +
                "    <iframe src=\"https://www.aljazeera.com/news/2022/6/5/16-killed-170-injured-in-bangladesh-container-depot-fire\" name=\"iframe_b\" height=\"700px\" width=\"100%\" title=\"Iframe Example\"></iframe>\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "</html>";*/
        WebEngine engine = view.getEngine();
        //engine.load(String.valueOf(getClass().getResource("mapsbd.html")));
        engine.load("https://www.aljazeera.com/news/2022/6/5/16-killed-170-injured-in-bangladesh-container-depot-fire");

    }
    @FXML
    void dt(ActionEvent event) {

        this.pane = pane;
       /* String s="<html>\n" +
                "\n" +
                "<body>\n" +
                "\n" +
                "\n" +
                "    <iframe src=\"https://www.dhakatribune.com/tags/natural-disasters\" name=\"iframe_b\" height=\"700px\" width=\"100%\" title=\"Iframe Example\"></iframe>\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "</html>";*/
        WebEngine engine = view.getEngine();
        //engine.load(String.valueOf(getClass().getResource("mapsbd.html")));
        engine.load("https://www.dhakatribune.com/tags/natural-disasters");
    }

    @FXML
    void dstar(ActionEvent event) {
        this.pane = pane;
        WebEngine engine = view.getEngine();
        //engine.load(String.valueOf(getClass().getResource("mapsbd.html")));
        engine.load("https://www.thedailystar.net/environment/climate-crisis/natural-disaster");

    }

    @FXML
    void ient(ActionEvent event) {

        this.pane = pane;
     /*   String s="<html>\n" +
                "\n" +
                "<body>\n" +
                "\n" +
                "\n" +
                "    <iframe src=\"https://www.independent.co.uk/topic/natural-disaster\" name=\"iframe_b\" height=\"700px\" width=\"100%\" title=\"Iframe Example\"></iframe>\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "</html>";*/
        WebEngine engine = view.getEngine();
        //engine.load(String.valueOf(getClass().getResource("mapsbd.html")));
        engine.load("https://www.independent.co.uk/topic/natural-disaster");
    }

    @FXML
    void palo(ActionEvent event) {
        this.pane = pane;
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
        WebEngine engine = view.getEngine();
        //engine.load(String.valueOf(getClass().getResource("mapsbd.html")));
        engine.load("https://en.prothomalo.com/topic/Natural-disaster");
       /* try {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(NewsView.class.getResource("NewsView.fxml"));
            AnchorPane ap = fxmlLoader.load();
            NewsView sadmin = fxmlLoader.getController();
            sadmin.setp(pane);
            pane.setCenter(ap);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/

    }
    void setp(BorderPane pane){
        this.pane = pane;
//        String s="<html>\n" +
//                "\n" +
//                "<body>\n" +
//                "\n" +
//                "\n" +
//                "    <iframe src=\"https://en.prothomalo.com\" name=\"iframe_b\" height=\"700px\" width=\"100%\" title=\"Iframe Example\"></iframe>\n" +
//                "\n" +
//                "</body>\n" +
//                "\n" +
//                "</html>";
        WebEngine engine = view.getEngine();
        engine.loadContent(s);

    }
    void setg(BorderPane pane){

        this.pane = pane;
        /*String s="<html>\n" +
                "\n" +
                "<body>\n" +
                "\n" +
                "\n" +
                "    <iframe src=\"https://www.theguardian.com/world/2022/jun/18/at-least-18-dead-and-millions-stranded-as-floods-devastate-india-and-bangladesh\" name=\"iframe_b\" height=\"700px\" width=\"100%\" title=\"Iframe Example\"></iframe>\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "</html>";*/
        WebEngine engine = view.getEngine();
        engine.load("https://www.theguardian.com/world/2022/jun/18/at-least-18-dead-and-millions-stranded-as-floods-devastate-india-and-bangladesh");

    }

    @FXML
    void theg(ActionEvent event) {
        WebEngine engine = view.getEngine();

        engine.load("https://www.theguardian.com/world/2022/jun/18/at-least-18-dead-and-millions-stranded-as-floods-devastate-india-and-bangladesh");

     /*   try {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(NewsView.class.getResource("NewsView.fxml"));
            AnchorPane ap = fxmlLoader.load();
            NewsView sadmin = fxmlLoader.getController();
            sadmin.setg(pane);
            pane.setCenter(ap);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
/*
        String s="<html>\n" +
                "\n" +
                "<body>\n" +
                "\n" +
                "\n" +
                "    <iframe src=\"https://www.theguardian.com/world/2022/jun/18/at-least-18-dead-and-millions-stranded-as-floods-devastate-india-and-bangladesh\" name=\"iframe_b\" height=\"700px\" width=\"100%\" title=\"Iframe Example\"></iframe>\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "</html>";
        WebEngine engine = view.getEngine();
        engine.loadContent(s);*/
    }


    public void set(String username,String role,BorderPane pane) {
        this.pane = pane;
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
        WebEngine engine = view.getEngine();
        //engine.load(String.valueOf(getClass().getResource("mapsbd.html")));
        engine.loadContent(s);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        WebEngine engine = view.getEngine();
        engine.load("https://en.prothomalo.com/topic/Natural-disaster");
    }
}
