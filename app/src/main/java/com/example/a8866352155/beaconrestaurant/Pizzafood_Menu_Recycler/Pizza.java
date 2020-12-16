package com.example.a8866352155.beaconrestaurant.Pizzafood_Menu_Recycler;

/**
 * Created by 8866352155 on 3/22/2017.
 */

public class Pizza {
    private int image;
    private String name;
    private String price;

    public Pizza(int image, String name, String price) {
        this.image = image;
        this.name = name;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
