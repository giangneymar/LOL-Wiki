package com.example.lolwiki.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.lolwiki.data.models.Champion;
import com.example.lolwiki.data.models.Wallpaper;
import com.example.lolwiki.data.Repositories;

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

    public LiveData<List<Wallpaper>> getAllWallpaper() {
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
}
