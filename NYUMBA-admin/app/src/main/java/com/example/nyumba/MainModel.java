package com.example.nyumba;

public class MainModel {
    String contact, image,rent,name,location;

    MainModel(){

    }
    public MainModel(String contact, String image, String rent, String name, String location) {
        this.contact = contact;
        this.image = image;
        this.rent = rent;
        this.name = name;
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
