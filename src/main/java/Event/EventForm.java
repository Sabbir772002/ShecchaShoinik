package Event;

import DB.ConnectionDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;
import java.util.ResourceBundle;

public class EventForm implements Initializable {
    Connection con;

    @FXML
    private TextField Extra;

    @FXML
    private TextField Title;

    @FXML
    private TextField address;

    @FXML
    private TextField address32;

    @FXML
    private TextField author;

    @FXML
    private DatePicker date;

    @FXML
    private ComboBox<String> district;

    @FXML
    private ComboBox<String> division;

    @FXML
    private ComboBox<String> division1;

    @FXML
    private TextField time;

    @FXML
    private TextField timem;


    @FXML
    private Button imageup;
    String imagef = "src/main/Font/1.png";
    private String username;
    private String role;
    private BorderPane pane;

    @FXML
    void Submit(ActionEvent event) {


        System.out.println("i am at add event");
        File file1 = new File(imagef);

        try {
            FileInputStream fis = new FileInputStream(file1);
            con = ConnectionDb.DBC();
            String st = "INSERT INTO Event (Title,Author, Address, Division, District,AddInfo,Date,Image) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(st);
            preparedStatement.setString(1, Title.getText());
            preparedStatement.setString(2, author.getText());
            preparedStatement.setString(3, address.getText());
            preparedStatement.setString(4, division.getValue().toString());
            preparedStatement.setString(5, district.getValue().toString());
            preparedStatement.setString(6, Extra.getText().toString());
            preparedStatement.setString(7, date.getEditor().getText());
            preparedStatement.setBinaryStream(8, fis, (int) file1.length());
            preparedStatement.execute();
            preparedStatement.close();
            con.close();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Add Event Successfully!");
            alert.setHeaderText("Your Event Added!\nNow wait until Admin Approve.");
            // alert.setContentText("");
            File file = new File("src/main/Font/icon1.png");
            Image image = new Image(file.toURI().toString());
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(image);
            Optional<ButtonType> result = alert.showAndWait();
            System.out.println("THIK ASE Everything");
        } catch (Exception e) {
            System.out.println("some error at add Event/n" + e.getMessage());

        }
    }

    @FXML
    void select(ActionEvent event) {
        String divisionname;
        try {
            divisionname = division.getSelectionModel().getSelectedItem().toString();
        } catch (Exception e) {
            divisionname = "";
        }
        if (divisionname.equals("Dhaka")) {
            district.getItems().removeAll(district.getItems());
            String[] ditrict = {"Dhaka", "Gazipur", "Faridpur", "Gopalganj", "Jamalpur", "Kishoreganj", "Madaripur", "Manikganj", "Munshiganj", "Narayanganj", "Narshingdi", "Rajbari", "Shariatpur", "Tangail"};
            district.getItems().addAll(ditrict);
            district.getSelectionModel().select(0);
        } else if (divisionname.equals("Rajshahi")) {
            district.getItems().removeAll(district.getItems());

            String[] ditrict = {"Rajshahi", "Sirajgonj", "Bogra", "Chapinawabganj", "Joypurhat", "Naogaon", "Natore", "Pabna"};
            district.getItems().addAll(ditrict);
            district.getSelectionModel().select(0);
        } else if (divisionname.equals("Chattogram")) {
            district.getItems().removeAll(district.getItems());

            String[] ditrict = {"Chattogram", "Cox's Bazar", "Rangamati", "Bandarban", "Khagrachhari", "Feni", "Lakshmipur", "Comilla", " Noakhali", "Brahmanbaria", "Chandpur"};
            district.getItems().addAll(ditrict);
            district.getSelectionModel().select(0);
        } else if (divisionname.equals("Barishal")) {
            district.getItems().removeAll(district.getItems());

            String[] ditrict = {"Barishal", "Barguna", "Bhola", "Jhalokati", "Pirojpur", "Patuakhali"};
            district.getItems().addAll(ditrict);
            district.getSelectionModel().select(0);
        } else if (divisionname.equals("Sylhet")) {
            district.getItems().removeAll(district.getItems());

            String[] ditrict = {"Sylhet", "Habiganj", "Moulvibazar", "Sunamganj"};
            district.getItems().addAll(ditrict);
            district.getSelectionModel().select(0);
        } else if (divisionname.equals("Mymensingh")) {
            district.getItems().removeAll(district.getItems());

            String[] ditrict = {"Mymensingh", "Jamalpur", "Netrokona", "Sherpur"};
            district.getItems().addAll(ditrict);
            district.getSelectionModel().select(0);
        } else if (divisionname.equals("Khulna")) {
            district.getItems().removeAll(district.getItems());

            String[] ditrict = {"Khulna", "Bagherhat", "Chuadanga", "Jessore", "Jinaidaha", "Magura", "Meherpur", "Narail", "Satkhira"};
            district.getItems().addAll(ditrict);
            district.getSelectionModel().select(0);
        } else if (divisionname.equals("Rangpur")) {
            district.getItems().removeAll(district.getItems());

            String[] ditrict = {"Rangpur", "Kurigram", "Gaibandha", "Thakurgaon", "Dinajpur", "Nilphamari", "Panchagarh", "Lalmonirhat"};
            district.getItems().addAll(ditrict);
            district.getSelectionModel().select(0);
        }

    }

    @FXML
    void upimage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        //final Button openButton = new Button("Choose Background Image");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Select Image", "*.jpg", "*.png"));
        // fileChooser.setInitialDirectory(new File("C:\\Users\\USER\\Pictures"));
        Node node= (Node) event.getSource();
          Stage stage = (Stage) node.getScene().getWindow();
        ;
        File file = fileChooser.showOpenDialog(stage);
        System.out.println(imagef);
        if (file != null) {
            System.out.println(file);
            imagef = file.getAbsolutePath();
            System.out.println(imagef);
            String s[] = imagef.split("\\\\");
            //System.out.println(imagef);
            //  System.out.println(s[s.length - 1]);
            imageup.setText(s[s.length - 1]);
            // File f= new File("src/main/file.image");

            // openFile(file);
            // where my problem is
            //image1 = new Image(file.toURI().toString());

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        con=ConnectionDb.DBC();
        String []division1={"Dhaka","Rajshahi","Chattogram","Barishal","Rangpur","Sylhet","Khulna", "Mymensingh"};
        division.getItems().addAll(division1);
        division.getSelectionModel().select(0);
        district.getItems().removeAll(district.getItems());
        String[] ditrict = {"Dhaka", "Gazipur", "Faridpur", "Gopalganj", "Jamalpur", "Kishoreganj", "Madaripur", "Manikganj", "Munshiganj", "Narayanganj", "Narshingdi", "Rajbari", "Shariatpur", "Tangail"};
        district.getItems().addAll(ditrict);
        district.getSelectionModel().select(0);
    }

    public void set(String username, String role, BorderPane pane) {
        this.username = username;
        this.role = role;
        this.pane = pane;
    }
}
