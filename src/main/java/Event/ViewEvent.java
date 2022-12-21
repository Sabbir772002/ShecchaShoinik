package Event;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ViewEvent {

    public void set(String username, String role) {
        System.out.println("i am in set");
        // user.setText(username);
        // rolee.setText("@"+role);

    }

    @FXML
    private TableView<?> time;

    @FXML
    private TableColumn<?, ?> title;

}
