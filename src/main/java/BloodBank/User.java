package BloodBank;

public class User {
    String Name,Username;

    public User(String name, String username) {
        Name = name;
        Username = username;

    }
    public User(String name){

        this.Name=name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}
