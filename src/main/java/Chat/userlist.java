package Chat;

public class userlist {
    String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    String Username;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
    public userlist(String Name, String Username) {
        this.Name=Name;
        this.Username=Username;
    }
    public userlist() {

    }
}
