package com.liutorovich.anatoliy.gmail.menu.Models;

/**
 * Created by ToLik on 09.02.2017.
 */

public class Images {

    private int id;
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Images{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }
}
