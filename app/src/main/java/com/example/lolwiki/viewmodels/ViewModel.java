package com.example.lolwiki.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.lolwiki.data.Repositories;
import com.example.lolwiki.data.models.Ability;
import com.example.lolwiki.data.models.Champion;
import com.example.lolwiki.data.models.Item;
import com.example.lolwiki.data.models.Wallpaper;

import java.util.List;

public class ViewModel extends AndroidViewModel {
    /*
     * Area : variable
     */
    private final Repositories repositories;

    /*
     * Area : function
     */
    public ViewModel(Application application) {
        super(application);
        repositories = new Repositories(application);
    }

    public MutableLiveData<List<Wallpaper>> getAllWallpaper() {
        MutableLiveData<List<Wallpaper>> data = new MutableLiveData<>();
        if (repositories.getAllWallpaper().size() > 0) {
            data.postValue(repositories.getAllWallpaper());
        } else {
            data.postValue(null);
        }
        return data;
    }

    public MutableLiveData<List<Champion>> getAllChampion() {
        MutableLiveData<List<Champion>> listChampionsTierS = new MutableLiveData<>();
        if (repositories.getAllChampion().size() > 0) {
            listChampionsTierS.postValue(repositories.getAllChampion());
        } else {
            listChampionsTierS.postValue(null);
        }
        return listChampionsTierS;
    }

    public MutableLiveData<List<Champion>> filterChampionsByPosition(String position) {
        MutableLiveData<List<Champion>> championsByPosition = new MutableLiveData<>();
        if (repositories.filterChampionsByPosition(position).size() > 0) {
            championsByPosition.postValue(repositories.filterChampionsByPosition(position));
        } else {
            championsByPosition.postValue(null);
        }
        return championsByPosition;
    }

    public MutableLiveData<List<Champion>> searchChampionByName(String name) {
        MutableLiveData<List<Champion>> championsByname = new MutableLiveData<>();
        if (repositories.searchChampionByName(name).size() > 0) {
            championsByname.postValue(repositories.searchChampionByName(name));
        } else {
            championsByname.postValue(null);
        }
        return championsByname;
    }

    public MutableLiveData<List<Ability>> getAbilitiesForChampion(int championId) {
        MutableLiveData<List<Ability>> data = new MutableLiveData<>();
        if (repositories.getAbilitiesForChampion(championId).size() > 0) {
            data.postValue(repositories.getAbilitiesForChampion(championId));
        } else {
            data.postValue(null);
        }
        return data;
    }

    public MutableLiveData<List<Item>> getItemsForChampion(int championId) {
        MutableLiveData<List<Item>> data = new MutableLiveData<>();
        if (repositories.getItemForChampion(championId).size() > 0) {
            data.postValue(repositories.getItemForChampion(championId));
        } else {
            data.postValue(null);
        }
        return data;
    }
}
