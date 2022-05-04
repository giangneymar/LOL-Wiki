package com.example.lolwiki.repositories;

import android.app.Application;
import android.util.Log;

import com.example.lolwiki.database.wallpaper.WallpaperDAO;
import com.example.lolwiki.database.wallpaper.WallpaperDatabase;
import com.example.lolwiki.models.Wallpaper;

import java.util.List;

public class Repositories {
    /*
     * Area : variable
     */
    private WallpaperDAO wallpaperDAO;

    /*
     * Area : function
     */
    public Repositories(Application application) {
        WallpaperDatabase wallpaperDatabase = WallpaperDatabase.getAllWallpaper(application);
        wallpaperDAO = wallpaperDatabase.wallpaperDAO();
    }

    public List<Wallpaper> getAllWallpaper() {
        Log.d("aaa",wallpaperDAO.getAllWallpaper().size()+"");
        return wallpaperDAO.getAllWallpaper();
    }
}
