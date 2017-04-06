package com.liutorovich.anatoliy.gmail.menu.Models;

/**
 * Created by ToLik on 12.02.2017.
 */

public class Order {

    private int idRestaurant;
    private String nameRestaurant;
    private String adress;
    private String nameDish;
    private double price;
    private int numbOfDish;

    public int getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(int idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public String getNameRestaurant() {
        return nameRestaurant;
    }

    public void setNameRestaurant(String nameRestaurant) {
        this.nameRestaurant = nameRestaurant;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNameDish() {
        return nameDish;
    }

    public void setNameDish(String nameDish) {
        this.nameDish = nameDish;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumbOfDish() {
        return numbOfDish;
    }

    public void setNumbOfDish(int numbOfDish) {
        this.numbOfDish = numbOfDish;
    }


    @Override
    public String toString() {
        return "Order{" +
                "idRestaurant=" + idRestaurant +
                ", nameRestaurant='" + nameRestaurant + '\'' +
                ", nameDish='" + nameDish + '\'' +
                ", price=" + price +
                ", numbOfDish=" + numbOfDish +
                '}';
    }
}
