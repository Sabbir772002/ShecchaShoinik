package AdminDB;

public class Teams {
    String Name;
    String username;
    String District;
    String Type;


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDistrict() {
        return District;
    }

    public void setDivision(String District) {
        this.District = District;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Teams(String name, String username, String District, String type) {
        Name = name;
        this.username = username;
        this.District = District;
        Type = type;
    }
}
