package com.example.lolwiki.data;

import android.app.Application;
import android.util.Log;

import com.example.lolwiki.data.models.Champion;
import com.example.lolwiki.data.models.Wallpaper;

import java.util.List;

public class Repositories {
    /*
     * Area : variable
     */
    private DAO dao;

    /*
     * Area : function
     */
    public Repositories(Application application) {
        Database wallpaperDatabase = Database.getInstance(application);
        dao = wallpaperDatabase.wallpaperDAO();
    }

    public List<Wallpaper> getAllWallpaper() {
        return dao.getAllWallpaper();
    }

    public List<Champion> getChampionsTierS() {
        return dao.getChampionsTierS();
    }

    public List<Champion> getChampionsNoneTier() {
        return dao.getChampionsNoneTier();
    }

    public List<Champion> filterChampionsByPosition(String position) {
        return dao.filterChampionByPosition(position);
    }

    public List<Champion> filterChampionsByLegacy(String legacy) {
        return dao.filterChampionByLegacy(legacy);
    }
}
