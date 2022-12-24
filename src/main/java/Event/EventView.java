package Event;

public class EventView {
    String Title;
    String Date;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    String Id;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public EventView(String title, String date,String  ID){
        Title = title;
        Date = date;
        this.Id= String.valueOf(ID);
    }
}