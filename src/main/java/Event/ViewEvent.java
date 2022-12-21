package Event;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.AccessibleAction;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class ViewEvent {
    @FXML
    void addevent(ActionEvent e){
        try{
            //System.out.println("hey ki khobor");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Event.ViewEvent.class.getResource("ViewEvent.fxml"));
            AnchorPane ap = fxmlLoader.load();
            ViewEvent sadmin = fxmlLoader.getController();
            //sadmin.set(username,role);
           // pane1.setCenter(ap);
            //System.out.println("kno holo na");

        }catch (Exception ei){
            System.out.println(ei.getMessage());
        }

    }

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
