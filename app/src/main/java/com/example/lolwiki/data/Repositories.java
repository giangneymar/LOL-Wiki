package com.example.lolwiki.data;

import android.app.Application;

import com.example.lolwiki.data.models.Champion;
import com.example.lolwiki.data.models.Wallpaper;

import java.util.List;

public class Repositories {
    /*
     * Area : variable
     */
    private final DAO dao;

    /*
     * Area : function
     */
    public Repositories(Application application) {
        Database wallpaperDatabase = Database.getInstance(application);
        dao = wallpaperDatabase.dao();
    }

    public List<Wallpaper> getAllWallpaper() {
        return dao.getAllWallpaper();
    }

    public List<Champion> getAllChampion() {
        return dao.getAllChampion();
    }

    public List<Champion> filterChampionsByPosition(String position) {
        return dao.filterChampionByPosition(position);
    }
}
