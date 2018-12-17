package com.example.mingi.sewoon.Fix;

public class Fix {


    String title;
    String content;
    String category;
    int no;
    String day;
    int reply;
    String image;
    String userID;



    public Fix(String title, String content, String category, int no, String day, int reply, String image) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.no = no;
        this.day = day;
        this.reply = reply;
        this.image = image;
    }

    public Fix(String title, String category, int no, String day, int reply) {
        this.title = title;
        this.category = category;
        this.no = no;
        this.day = day;
        this.reply = reply;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getReply() {
        return reply;
    }

    public void setReply(int reply) {
        this.reply = reply;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}

