package com.example.lolwiki.data.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "item")
public class Item implements Serializable {
    /*
     * Area : variable
     */
    @PrimaryKey
    private int id;
    private String name;
    private int totalPrice, recipePrice, sellPrice;
    private String image, description;

    /*
     * Area : function
     */
    public Item(int id, String name, int totalPrice, int recipePrice, int sellPrice, String image, String description) {
        this.id = id;
        this.name = name;
        this.totalPrice = totalPrice;
        this.recipePrice = recipePrice;
        this.sellPrice = sellPrice;
        this.image = image;
        this.description = description;
    }

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

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getRecipePrice() {
        return recipePrice;
    }

    public void setRecipePrice(int recipePrice) {
        this.recipePrice = recipePrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
