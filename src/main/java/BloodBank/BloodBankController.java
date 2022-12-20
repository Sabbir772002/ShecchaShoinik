package BloodBank;

import DB.ConnectionDb;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.sql.Connection;

public class BloodBankController {
    Connection con;
    String username="";
    String role="";

    public void set(String username, String role) {
        con= ConnectionDb.DBC();
        role=role;
        this.role = role;
        this.username = username;

        // alertcount();
        //alertnum.setText(String.valueOf(newcount));
        // Thread t=new HelpRequest.AlertThread();
        //t.start();


    }

    @FXML
    private AnchorPane Requestpane;

    @FXML
    private AnchorPane Requestpane1;

    @FXML
    private AnchorPane donatepane;

    @FXML
    private AnchorPane donatepane1;

}
