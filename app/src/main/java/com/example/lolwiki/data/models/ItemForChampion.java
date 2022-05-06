package com.example.lolwiki.data.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "item_for_champion")
public class ItemForChampion implements Serializable {
    /*
     * Area : variable
     */
    @PrimaryKey
    private int id;
    private int championId, itemId;

    /*
     * Area : function
     */
    public ItemForChampion(int id, int championId, int itemId) {
        this.id = id;
        this.championId = championId;
        this.itemId = itemId;
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

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}
