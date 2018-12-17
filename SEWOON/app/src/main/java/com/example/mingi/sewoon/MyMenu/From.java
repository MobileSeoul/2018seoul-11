package com.example.mingi.sewoon.MyMenu;

/**
 * Created by MINGI on 2018-05-10.
 */

public class From {

    String title;
    String content;
    String toUser;
    String fromUserName;
    String day;


    public From(String title, String content, String fromUserName, String day) {
        this.title = title;
        this.content = content;
        this.fromUserName = fromUserName;
        this.day = day;
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

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
