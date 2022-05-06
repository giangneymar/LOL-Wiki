package com.example.lolwiki.data;

import static com.example.lolwiki.utils.KeyConstant.DATABASE_NAME;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.lolwiki.data.models.Ability;
import com.example.lolwiki.data.models.Champion;
import com.example.lolwiki.data.models.Item;
import com.example.lolwiki.data.models.ItemForChampion;
import com.example.lolwiki.data.models.Wallpaper;

@androidx.room.Database(entities = {Wallpaper.class, Champion.class, Ability.class, Item.class, ItemForChampion.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {
    /*
     * Area : variable
     */
    private static Database database;

    /*
     * Area : function
     */
    public static synchronized Database getInstance(Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context, Database.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return database;
    }

    public abstract DAO dao();
}
