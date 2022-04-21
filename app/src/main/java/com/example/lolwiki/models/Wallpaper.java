package com.example.lolwiki.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Wallpaper implements Serializable {
    /*
     * Area : variable
     */
    private int id;
    private String image;

    /*
     * Area : function
     */
    public Wallpaper(int id, String image) {
        this.id = id;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
