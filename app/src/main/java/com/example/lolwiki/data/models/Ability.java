package com.example.lolwiki.data.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "abilities")
public class Ability implements Serializable {
    /*
     * Area : variable
     */
    @PrimaryKey
    private int id;
    private int championId;
    private String name, rangeAbilities, cost, coolDown, image, description, keyAbilities;

    /*
     * Area : function
     */
    public Ability(int id, int championId, String name, String rangeAbilities, String cost, String coolDown, String image, String description, String keyAbilities) {
        this.id = id;
        this.championId = championId;
        this.name = name;
        this.rangeAbilities = rangeAbilities;
        this.cost = cost;
        this.coolDown = coolDown;
        this.image = image;
        this.description = description;
        this.keyAbilities = keyAbilities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChampionId() {
        return championId;
    }

    public void setChampionId(int championId) {
        this.championId = championId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRangeAbilities() {
        return rangeAbilities;
    }

    public void setRangeAbilities(String rangeAbilities) {
        this.rangeAbilities = rangeAbilities;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCoolDown() {
        return coolDown;
    }

    public void setCoolDown(String coolDown) {
        this.coolDown = coolDown;
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

    public String getKeyAbilities() {
        return keyAbilities;
    }

    public void setKeyAbilities(String keyAbilities) {
        this.keyAbilities = keyAbilities;
    }
}
