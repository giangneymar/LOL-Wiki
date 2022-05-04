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
    private Repositories repositories;

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

    public MutableLiveData<List<Champion>> getChampionsTierS() {
        MutableLiveData<List<Champion>> listChampionsTierS = new MutableLiveData<>();
        if (repositories.getChampionsTierS().size() > 0) {
            listChampionsTierS.postValue(repositories.getChampionsTierS());
        } else {
            listChampionsTierS.postValue(null);
        }
        return listChampionsTierS;
    }

    public MutableLiveData<List<Champion>> getChampionsNoneTier() {
        MutableLiveData<List<Champion>> listChampionsNoneTier = new MutableLiveData<>();
        if (repositories.getChampionsNoneTier().size() > 0) {
            listChampionsNoneTier.postValue(repositories.getChampionsNoneTier());
        } else {
            listChampionsNoneTier.postValue(null);
        }
        return listChampionsNoneTier;
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

    public MutableLiveData<List<Champion>> filterChampionsByLegacy(String legacy) {
        MutableLiveData<List<Champion>> championsByLegacy = new MutableLiveData<>();
        if (repositories.filterChampionsByLegacy(legacy).size() > 0) {
            championsByLegacy.postValue(repositories.filterChampionsByLegacy(legacy));
        } else {
            championsByLegacy.postValue(null);
        }
        return championsByLegacy;
    }
}
