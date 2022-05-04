package com.example.lolwiki.database.wallpaper;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.lolwiki.models.Wallpaper;

@Database(entities = Wallpaper.class, version = 1)
public abstract class WallpaperDatabase extends RoomDatabase {
    /*
     * Area : variable
     */
    private static WallpaperDatabase wallpaperDatabase;
    private static String DATABASE_NAME = "lolwiki.sqlite";

    /*
     * Area : function
     */
    public abstract WallpaperDAO wallpaperDAO();

    public static synchronized WallpaperDatabase getAllWallpaper(Context context) {
        if (wallpaperDatabase == null) {
            wallpaperDatabase = Room.databaseBuilder(context, WallpaperDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return wallpaperDatabase;
    }
}
