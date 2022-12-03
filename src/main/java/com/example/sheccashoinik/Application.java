package com.example.sheccashoinik;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Application extends javafx.application.Application {
    public static String oname="";
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomeController.class.getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("ShecchaShoinik");
        stage.setScene(scene);
        File file = new File("src/main/Font/icon1.png");
        Image image = new Image(file.toURI().toString());
        stage.getIcons().add(image);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}