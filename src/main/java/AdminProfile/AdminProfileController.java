package AdminProfile;


import java.sql.Connection;

public class AdminProfileController {
    Connection con;
    String username;
    String role;

    public void set(String username, String role) {

        this.username = username;
        this.role = role;


    }
}

