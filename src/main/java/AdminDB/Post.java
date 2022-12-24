package AdminDB;

public class Post {
    String Title;
    String District;
    String type;
    String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }



    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Post(String title, String district, String type,String ID) {
        Title = title;
        District = district;
        this.type = type;
        this.ID = ID;
    }
}
