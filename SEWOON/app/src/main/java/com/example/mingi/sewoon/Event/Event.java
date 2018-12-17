package com.example.mingi.sewoon.Event;

public class Event {


    String image;
    String title;
    String content;
    String day;
    String time;
    String place;
    String phone;
    String host;


    public Event(String image, String title, String content, String day, String time, String place, String phone, String host) {
        this.image = image;
        this.title = title;
        this.content = content;
        this.day = day;
        this.time = time;
        this.place = place;
        this.phone = phone;
        this.host = host;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}

