package com.example.sheccashoinik;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MapController {

    @FXML
    private WebView view;

    @FXML
    void Click(ActionEvent event) {
        WebEngine engine = view.getEngine();
        engine.load("https://www.google.com/maps/@23.7806365,90.4192817,12z?hl=en");
    }

}
