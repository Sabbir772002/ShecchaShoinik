package AdminDB;

public class User {
    String Username;
    String Name;
    String District;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public User(String Name, String Username, String district) {
        this.Username = Username;
       this.Name = Name;
        District = district;
    }

    public User(String Name, String Username) {
        this.Username = Username;
       this.Name = Name;

    }
}
