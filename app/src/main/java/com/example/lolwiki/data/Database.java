package com.example.lolwiki.data;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.lolwiki.data.models.Champion;
import com.example.lolwiki.data.models.Wallpaper;
import com.example.lolwiki.utils.KeyConstant;

@androidx.room.Database(entities = {Wallpaper.class, Champion.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {
    /*
     * Area : variable
     */
    private static Database database;

    /*
     * Area : function
     */
    public abstract DAO wallpaperDAO();

    public static synchronized Database getInstance(Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context, Database.class, KeyConstant.DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return database;
    }
}