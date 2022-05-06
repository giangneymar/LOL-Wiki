package com.example.lolwiki.data;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.lolwiki.data.models.Ability;
import com.example.lolwiki.data.models.Champion;
import com.example.lolwiki.data.models.Item;
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

    @Query("SELECT * FROM abilities WHERE championId =:id")
    List<Ability> getAbilitiesForChampion(int id);

    @Query("SELECT item.* FROM item,item_for_champion,champion WHERE item.id=item_for_champion.itemId and champion.id = item_for_champion.championId and champion.id=:id")
    List<Item> getItemForChampion(int id);

    @Query("SELECT * FROM champion WHERE name LIKE :name")
    List<Champion> searchChampionByName(String name);
}
