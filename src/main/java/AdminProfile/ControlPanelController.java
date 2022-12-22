package AdminProfile;
import DB.ConnectionDb;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import java.sql.Connection;

public class ControlPanelController {
    Connection con;
    String username="";
    String role="";
    private String user2;
    private String name2;
    BorderPane pane;

    public void set(String username, String role, String name2, String user2,BorderPane pane) {
        //if(role.equals("Admin"))delete.setVisible(true);

        this.pane = pane;
        con= ConnectionDb.DBC();
        this.role = role;
        this.username = username;

        this.user2 = user2;
        this.name2 = name2;

    }
    public void set(String username, String role,BorderPane pane) {
        this.pane=pane;
        con= ConnectionDb.DBC();
        role=role;
        this.role = role;
        this.username = username;
    }
    public void set(String username, String role) {
        pane=pane;
        con= ConnectionDb.DBC();
        role=role;
        this.role = role;
        this.username = username;
    }


    @FXML
    private TableColumn<?, ?> District;

    @FXML
    private TableColumn<?, ?> Name;

    @FXML
    private TableColumn<?, ?> PostDistrict;
    @FXML
    private TableColumn<?, ?> TeamDistrict;

    @FXML
    private TableColumn<?, ?> PostType;

    @FXML
    private TableColumn<?, ?> TeamType;

    @FXML
    private TableColumn<?, ?> Teamname;

    @FXML
    private TableColumn<?, ?> Teamname1;

    @FXML
    private TableColumn<?, ?> Teamuser;

    @FXML
    private TableColumn<?, ?> Username;

    @FXML
    private TableView<?> alluser;

    @FXML
    private TableView<?> alluser1;

    @FXML
    private TableView<?> alluser11;

}
