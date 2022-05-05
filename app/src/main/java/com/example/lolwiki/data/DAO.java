package com.example.lolwiki.data;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.lolwiki.data.models.Champion;
import com.example.lolwiki.data.models.Wallpaper;

import java.util.List;

@Dao
public interface DAO {

    @Query("SELECT * FROM wallpaper")
    List<Wallpaper> getAllWallpaper();

    @Query("SELECT * FROM champion")
    List<Champion> getAllChampion();

    @Query("SELECT * FROM champion WHERE positionName LIKE :position")
    List<Champion> filterChampionByPosition(String position);
}
