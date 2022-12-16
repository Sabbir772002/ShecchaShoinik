
package com.example.sheccashoinik;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class MapController implements Initializable {

    @FXML
    private WebView view;

    @FXML
    void Click(ActionEvent event) {
        WebEngine engine = view.getEngine();
        engine.load("https://www.google.com/maps/@23.7806365,90.4192817,12z?hl=en");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        WebEngine engine = view.getEngine();
        //engine.load("https://www.google.com/maps/@23.7806365,90.4192817,12z?hl=en");
        engine.load(String.valueOf(getClass().getResource("map.html")));
    }
}

