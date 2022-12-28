package Chat;

import AdminDB.User;
import DB.ConnectionDb;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

public class ChatHandle extends Thread implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
connectSocket();
    }
    Connection con;
    String username = "";
    String role = "";
    BorderPane pane1;

    ;

    public void set(String username, String role) {
        con = ConnectionDb.DBC();
        role = role;
        this.role = role;
        this.username = username;
        connectSocket();
        //loadtable();
        // connect();
        // alertcount();
        //alertnum.setText(String.valueOf(newcount));
        // Thread t=new HelpRequest.AlertThread();
        //t.start();


    }

    BorderPane pane;

    public void set(String username, String role, BorderPane pane) {
        con = ConnectionDb.DBC();
        role = role;
        this.role = role;
        this.username = username;
      //  loadtable();
        this.pane1 = pane;
        // alertcount();
        //alertnum.setText(String.valueOf(newcount));
        // Thread t=new HelpRequest.AlertThread();
        //t.start();
        //connect();
connectSocket();
    }

        @FXML
        private TableColumn<?, ?> colname;

        @FXML
        private TableColumn<?, ?> coluser;

        @FXML
        private HBox hboxmessage;

        @FXML
        private TextField inputField;

        @FXML
        private TextField search;

        @FXML
        private Label user2;

        @FXML
        private Label user21;

        @FXML
        private TableView<?> usertable;

        @FXML
        private VBox vboxmessage;

        @FXML
        void search(KeyEvent event) {

        }


        @FXML
        void tableclick(MouseEvent event) {

        }
    private ArrayList<ChatHandle> clients;

    private Socket socket;

    public BufferedReader in;

    public PrintWriter writer;

    public Label lblUsername;
    public ImageView btnBackToLogin;
    public TextField txtClientMessage;
    public ImageView btnSend;

    BufferedReader bufferedReader;
    PrintWriter printWriter;


/*
    public void initialize() {
        connectSocket();
       // lblUsername.setText(username);
        inputField.setStyle("-fx-prompt-text-fill: white; -fx-background-color: transparent");
    }
*/

    private void connectSocket() {
        try {
            socket = new Socket("localhost", 5000);
            System.out.println("Connect With Server");

            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream(), true);

            this.start();

        } catch (IOException e) {

        }
    }

    public void run() {
        try {
            while (true) {
                String msg = bufferedReader.readLine();
                System.out.println("Message : " + msg);
                String[] tokens = msg.split(" ");
                String cmd = tokens[0];
                System.out.println("cmd : " + cmd);
                StringBuilder fulmsg = new StringBuilder();
                for (int i = 1; i < tokens.length; i++) {
                    fulmsg.append(tokens[i]);
                }
                System.out.println("fulmsg : " + fulmsg);
                System.out.println();
                if (cmd.equalsIgnoreCase(username + ":")) {
                    continue;
                } else if (fulmsg.toString().equalsIgnoreCase("bye")) {
                    break;
                }
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        HBox hBox = new HBox();
                        hBox.setAlignment(Pos.CENTER_LEFT);
                        hBox.setPadding(new Insets(5, 10, 5, 5));
                        Text text = new Text(msg);
                        TextFlow textFlow = new TextFlow(text);
                        textFlow.setStyle("-fx-color:rgb(239,242,255);"
                                + "-fx-background-color: rgb(182,182,182);" +
                                "-fx-background-radius: 10px;-fx-font-size: 15px");
                        textFlow.setPadding(new Insets(5, 0, 5, 5));
                        text.setFill(Color.color(0, 0, 0));
                        hBox.getChildren().add(textFlow);
                        vboxmessage.getChildren().add(hBox);

                    }
                });
                /*txtClientPane.appendText(msg + "\n");*/
            }
            bufferedReader.close();
            printWriter.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        } /*finally {
            try {
                bufferedReader.close();
                printWriter.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    }


    private void enableMove(Scene scene, Stage stage) {
        AtomicReference<Double> xOffset = new AtomicReference<>((double) 0);
        AtomicReference<Double> yOffset = new AtomicReference<>((double) 0);
        scene.setOnMousePressed(event -> {
            xOffset.set(stage.getX() - event.getScreenX());
            yOffset.set(stage.getY() - event.getScreenY());
        });
        //Lambda mouse event handler
        scene.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() + xOffset.get());
            stage.setY(event.getScreenY() + yOffset.get());
        });
    }

    public void sendMessageOnAction(MouseEvent mouseEvent) {
    }
     @FXML
    public void send(ActionEvent e) {
        String msg = inputField.getText();
        printWriter.println(username + ":  " + msg + "  ");
//        txtClientPane.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER_RIGHT);
        hBox.setPadding(new Insets(5, 5, 5, 10));
        Text text = new Text(msg);
        TextFlow textFlow = new TextFlow(text);
        textFlow.setStyle("-fx-color:rgb(239,242,255);"
                + "-fx-background-color: rgb(246,137,32);" +
                "-fx-background-radius: 20px; -fx-font-size: 15px");
        textFlow.setPadding(new Insets(5, 10, 5, 10));
        text.setFill(Color.color(0.934, 0.945, 0.996));
        hBox.getChildren().add(textFlow);
        vboxmessage.getChildren().add(hBox);
        printWriter.flush();

//        txtClientPane.appendText("Me: " + msg + "\n");
        inputField.setText("");
        if (msg.equalsIgnoreCase("BYE") || (msg.equalsIgnoreCase("logout"))) {
            System.exit(0);
        }
    }

    public void sendMessageByKeyOnAction(KeyEvent keyEvent) {
        if (keyEvent.getCode().toString().equals("ENTER")) {

        }
    }
    }


