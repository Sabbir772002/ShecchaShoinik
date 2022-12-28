package AdminProfile;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

public class ControlPanelController {

    @FXML
    private TableColumn<?, ?> District;

    @FXML
    private TableColumn<?, ?> Name;

    @FXML
    private TableColumn<?, ?> PostDistrict;

    @FXML
    private TableColumn<?, ?> PostType;

    @FXML
    private TableColumn<?, ?> TeamDistrict;

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
    private TableView<?> post;

    @FXML
    private TableView<?> team;

    @FXML
    void viewpost(ActionEvent event) {

    }

    @FXML
    void viewteam(ActionEvent event) {

    }

    @FXML
    void viewuser(ActionEvent event) {

    }

    public void set(String username, String role, BorderPane pane) {




    }
}
