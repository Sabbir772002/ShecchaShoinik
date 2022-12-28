package Others;


import DB.ConnectionDb;

import java.sql.Connection;

public class TeamApproveController {
    Connection con;
    String username="",role="";
    public void set(String username, String role) {
        con= ConnectionDb.DBC();
        this.role = role;
        this.username = username;
        // loadtable0();
    }
}
