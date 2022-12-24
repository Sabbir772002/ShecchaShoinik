package Others;

public class TeamMember {
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    String Name;
    String username;
    String mail;

    public TeamMember(String name, String username, String mail, String phone) {
        Name = name;
        this.username = username;
        this.mail = mail;
        Phone = phone;
    }

    String Phone;

}

