package Others;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

public class TaskCompletedController {

    @FXML
    private TableColumn<?, ?> address;

    @FXML
    private TableColumn<?, ?> district;

    @FXML
    private TableView<?> taskteam;

    @FXML
    private TableColumn<?, ?> time;

    @FXML
    private TableColumn<?, ?> title;

    public String username="";
    public String role="";
    BorderPane pane;

    public void set(String username, String role, BorderPane pane) {
        this.pane=pane;
        // user.setText(username);
        // rolee.setText("@"+role);
        this.role = role;
        this.username = username;
    }  public void set(String username,String role) {
        // user.setText(username);
        // rolee.setText("@"+role);
        this.role = role;
        this.username = username;
    }
}
