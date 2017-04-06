package com.liutorovich.anatoliy.gmail.menu.Models;

/**
 * Created by ToLik on 28.11.2016.
 */

public class Dishes {

    public int id;
    public String name;
    public String category;
    public String description;
    public String weight;
    public double price;
    public int number;
    public int like;
    public int dislike;
    public String urlImage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getLike() {return like;}

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    @Override
    public String toString() {
        return "Dishes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", weight='" + weight + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", like=" + like +
                ", dislike=" + dislike +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}
