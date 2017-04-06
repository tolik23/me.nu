package com.liutorovich.anatoliy.gmail.menu.Models;

/**
 * Created by ToLik on 28.11.2016.
 */

public class Feedbacks {

    public int id;
    public String userName;
    public String date;
    public int rating;
    public String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Feedbacks{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", date='" + date + '\'' +
                ", rating=" + rating +
                ", message='" + message + '\'' +
                '}';
    }
}
