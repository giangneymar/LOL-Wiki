package com.example.lolwiki.data;

import android.app.Application;

import com.example.lolwiki.data.models.Ability;
import com.example.lolwiki.data.models.Champion;
import com.example.lolwiki.data.models.Item;
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
        Database database = Database.getInstance(application);
        dao = database.dao();
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

    public List<Ability> getAbilitiesForChampion(int championId){
        return dao.getAbilitiesForChampion(championId);
    }

    public List<Item> getItemForChampion(int championId){
        return dao.getItemForChampion(championId);
    }
}
