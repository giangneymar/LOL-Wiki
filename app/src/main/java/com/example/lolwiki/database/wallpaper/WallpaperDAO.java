package com.example.lolwiki.database.wallpaper;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.lolwiki.models.Wallpaper;

import java.util.List;

@Dao
public interface WallpaperDAO {
    @Query("SELECT * FROM wallpaper")
    List<Wallpaper> getAllWallpaper();
}
