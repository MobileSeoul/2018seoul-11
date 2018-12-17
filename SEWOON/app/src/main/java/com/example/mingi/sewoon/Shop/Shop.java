package com.example.mingi.sewoon.Shop;

public class Shop {


    String name;
    String location;
    String item;
    String category;
    String phone;
    String location2;
    String photo;

    public Shop(String name, String location, String item, String category, String phone, String location2, String photo) {
        this.name = name;
        this.location = location;
        this.item = item;
        this.category = category;
        this.phone = phone;
        this.location2 = location2;
        this.photo = photo;
    }

    public String getLocation2() {
        return location2;
    }

    public void setLocation2(String location2) {
        this.location2 = location2;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
