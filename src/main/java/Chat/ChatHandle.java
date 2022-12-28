package Chat;

import AdminDB.User;
import DB.ConnectionDb;
import UserProfile.ProfileController;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

public class ChatHandle extends Thread {

    Connection con;
    String username = "";
    String role = "";
    BorderPane pane1;

    public void set(String username, String role) {
        con = ConnectionDb.DBC();
        role = role;
        this.role = role;
        this.username = username;
        connectSocket();
        loadtable();
        // connect();



    }

    BorderPane pane;

    public void set(String username, String role, BorderPane pane) {
        con = ConnectionDb.DBC();
        role = role;
        this.role = role;
        this.username = username;
      //  loadtable();
        this.pane1 = pane;
         connectSocket();
    }

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
        private TableView<userlist> usertable;

        @FXML
        private VBox vboxmessage;




    @FXML
    private TextArea showArea;
    @FXML
    private TableColumn<userlist, String> colname;
    @FXML
    private TableColumn<userlist, String> coluser;

    ObservableList<userlist> listF;
    int indexM = -1;
    boolean isConnected = false;
    BufferedReader reader;
    String inputName;
    BufferedWriter writer;
    Socket sc;
    @FXML
    ObservableList<userlist> list;



    @FXML
    void tableclick(MouseEvent event) {
        String Name2 = ((userlist)this.usertable.getSelectionModel().getSelectedItem()).getName().toString();
        String user2 = ((userlist)this.usertable.getSelectionModel().getSelectedItem()).getUsername().toString();

        try {
            System.out.println("hey ki khobor");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(ProfileController.class.getResource("Profile.fxml"));
            AnchorPane ap = (AnchorPane)fxmlLoader.load();
            ProfileController sadmin = (ProfileController)fxmlLoader.getController();
            sadmin.set(this.username, this.role, Name2, user2, this.pane1);
            this.pane1.setCenter(ap);
            System.out.println("kno holo na");
        } catch (Exception var7) {
            System.out.println(var7.getMessage());
        }

    }

    ObservableList<userlist> getdiasterList() {
        ObservableList<userlist> userlist1 = FXCollections.observableArrayList();
        return userlist1;
    }

    void loadtable() {
        this.colname.setCellValueFactory(new PropertyValueFactory("Name"));
        this.coluser.setCellValueFactory(new PropertyValueFactory("Username"));
        this.listF = ConnectionDb.getuserlist();
        this.usertable.setItems(this.listF);
    }
    private ArrayList<ChatHandle> clients;

    private Socket socket;

    public BufferedReader in;

    //public PrintWriter writer;

    public Label lblUsername;
    public ImageView btnBackToLogin;
    public TextField txtClientMessage;
    public ImageView btnSend;

    BufferedReader bufferedReader;
    PrintWriter printWriter;

    private void connectSocket() {
        try {
            socket = new Socket("localhost", 5000);
            System.out.println("Connect With Server");

            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            this.start();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
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
    }
    @FXML
    void search(KeyEvent e) {
        ObservableList<userlist> list1 = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = this.con.prepareStatement("SELECT Name,District,Username,Division,BG,Gender,Phone,Volunteer FROM userlist");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                String s1 = rs.getString(1);
                String s3 = rs.getString(2);
                String s5 = rs.getString(3);
                String s6 = rs.getString(4);
                String s7 = rs.getString(5);
                String s8 = rs.getString(6);
                String s9 = rs.getString(7);
                String s10 = rs.getString(8);
                String s0 = s1 + s3 + s5 + s6 + s7 + s8 + s9 + s10;
                String s2 = "" + this.search.getText().toString();
                boolean i = false;

                for(int j = 0; j < s0.length(); ++j) {
                    for(int p = j + 1; p < s0.length() - 2; ++p) {
                        if (s0.substring(j, p).equalsIgnoreCase(s2)) {
                            i = true;
                        }
                    }
                }

                s2 = s2 + " ";
                if (s2.equals("")) {
                    i = true;
                }

                if (s2.equals(" ")) {
                    i = true;
                }

                if (i) {
                    list1.add(new userlist(s1, s5));
                }
            }
        } catch (Exception var21) {
            System.out.println("error at cmchat serch user" + var21.getMessage());
        } finally {
            ;
        }

        this.colname.setCellValueFactory(new PropertyValueFactory("Name"));
        this.coluser.setCellValueFactory(new PropertyValueFactory("Username"));
        this.usertable.setItems(list1);
    }
}




