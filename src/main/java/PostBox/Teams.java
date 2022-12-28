package PostBox;

public class Teams {
    String Name;
    String username;



 String Phone;

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

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


    public Teams(String name, String username, String Phone) {
        Name = name;
        this.username = username;
        this.Phone = Phone;
    }
}
