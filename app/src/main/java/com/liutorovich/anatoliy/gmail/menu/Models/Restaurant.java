package com.liutorovich.anatoliy.gmail.menu.Models;

import java.util.List;

/**
 * Created by ToLik on 07.11.2016.
 */

public class Restaurant {

    public int id;
    public String name;
    public String address;
    public String type;
    public List<String> categories;
    public List<Dishes> dishes;
    public List<String> kitchen;
    public String classOfRestaurant;
    public boolean lunchMenu;
    public boolean canReserve;
    public boolean canTakeAway;
    public Object workTime;
    public String phone;
    public int rating;
    public double distanceToUser;
    public int numberOfReviews;
    public String status;
    public List<Images> images;
    public String info;
    public String latitude;
    public String longitude;
    public List<Feedbacks> feedbacks;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getCategories() { return categories; }

    public void setCategories(List<String> categories) { this.categories = categories; }

    public List<Dishes> getDishes() { return dishes; }

    public void setDishes(List<Dishes> dishes) { this.dishes = dishes; }

    public List<String> getKitchen() {
        return kitchen;
    }

    public void setKitchen(List<String> kitchen) {
        this.kitchen = kitchen;
    }

    public String getClassOfRestaurant() {
        return classOfRestaurant;
    }

    public void setClassOfRestaurant(String classOfRestaurant) {
        this.classOfRestaurant = classOfRestaurant;
    }

    public boolean isLunchMenu() {
        return lunchMenu;
    }

    public void setLunchMenu(boolean lunchMenu) {
        this.lunchMenu = lunchMenu;
    }

    public boolean isCanReserve() {
        return canReserve;
    }

    public void setCanReserve(boolean canReserve) {
        this.canReserve = canReserve;
    }

    public boolean isCanTakeAway() {
        return canTakeAway;
    }

    public void setCanTakeAway(boolean canTakeAway) {
        this.canTakeAway = canTakeAway;
    }

    public Object getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Object workTime) {
        this.workTime = workTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getDistanceToUser() {
        return distanceToUser;
    }

    public void setDistanceToUser(double distanceToUser) {
        this.distanceToUser = distanceToUser;
    }

    public int getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(int numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public List<Feedbacks> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedbacks> feedbacks) {
        this.feedbacks = feedbacks;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", type='" + type + '\'' +
                ", categories=" + categories +
                ", dishes=" + dishes +
                ", kitchen=" + kitchen +
                ", classOfRestaurant='" + classOfRestaurant + '\'' +
                ", lunchMenu=" + lunchMenu +
                ", canReserve=" + canReserve +
                ", canTakeAway=" + canTakeAway +
                ", workTime=" + workTime +
                ", phone='" + phone + '\'' +
                ", rating=" + rating +
                ", distanceToUser=" + distanceToUser +
                ", numberOfReviews=" + numberOfReviews +
                ", status='" + status + '\'' +
                ", images=" + images +
                ", info='" + info + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", feedbacks=" + feedbacks +
                '}';
    }
}
