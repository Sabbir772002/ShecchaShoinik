package Others;

import Chat.userlist;
import DB.ConnectionDb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class VolunteerNearController implements Initializable {
    Connection con;
    String username="";
    String role="";

    public void set(String username, String role) {
        con= ConnectionDb.DBC();
        role=role;
        this.role = role;
        this.username = username;
        loadduserinfo();
        loadtable();

        // alertcount();
        //alertnum.setText(String.valueOf(newcount));
        // Thread t=new HelpRequest.AlertThread();
        //t.start();


    }
    BorderPane pane;

    public void set(String username, String role, BorderPane pane) {
        con=ConnectionDb.DBC();
        this.pane=pane;
        // user.setText(username);
        // rolee.setText("@"+role);
        this.role = role;
        this.username = username;
        loadduserinfo();
        loadtable();
    }
    String division, district;
    void loadduserinfo(){
        try {
            System.out.println(username);
            PreparedStatement ps = con.prepareStatement("SELECT District,Division FROM userlist where Username='" + username + "'");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                district=rs.getString(1);
                division=rs.getString(2);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());

            }


    }


    @FXML
    private Label District;

    @FXML
    private Label Division;

    @FXML
    private Label Name;

    @FXML
    private Label Phone;

    @FXML
    private Label Phone1;

    @FXML
    private Label Phone11;

    @FXML
    private Button btsearch;

    @FXML
    private Label field;

    @FXML
    private Label field1;

    @FXML
    private Label showuser;
    @FXML
    private TableView<Team> vtable;
    @FXML
    private TableColumn<Team, String> col_district;

    @FXML
    private TableColumn<Team, String> col_name;

    @FXML
    private TableColumn<Team, String> col_user;
    @FXML
    ObservableList<Team> listF;

    ObservableList<Team> getdiasterList() {
        ObservableList<Team> userlist1 = FXCollections.observableArrayList();


        return userlist1;
    }

    int indexM = -1;

    void loadtable() {
        col_name.setCellValueFactory(new PropertyValueFactory<Team, String>("Name"));
        col_district.setCellValueFactory(new PropertyValueFactory<Team, String>("District"));
        col_user.setCellValueFactory(new PropertyValueFactory<Team, String>("Username"));
        listF = ConnectionDb.getTeamlist(division,district);
         vtable.setItems(listF);

    }




    @FXML
    void helpclcik(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {

    }

    @FXML
    void searchkey(KeyEvent event) {

    }

    @FXML
    void tableclick(MouseEvent e) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        con=ConnectionDb.DBC();
      /*  loadduserinfo();
        loadtable();*/
    }
}


