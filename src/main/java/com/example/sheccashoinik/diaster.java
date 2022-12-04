package com.example.sheccashoinik;


public class diaster {
    public String Title,Type, Address, Division, District,AddInfo;
    int Id;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getType() {
        return Type;
    }

    public String getAddInfo() {
        return AddInfo;
    }

    public void setAddInfo(String addInfo) {
        AddInfo = addInfo;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public void setDivision(String division) {
        Division = division;
    }

    public String getDivision() {
        return Division;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setType(String type) {
        Type = type;
    }

    public diaster(String Title, String Type, String Address, String Division, String District, int Id, String AddInfo) {
        this.Title = Title;
        this.Type = Type;
        this.Address = Address;
        this.Division = Division;
            this.District = District;
            this.Id = Id;
            this.AddInfo = AddInfo;



    }
}
