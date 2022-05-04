package com.example.lolwiki.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lolwiki.models.Wallpaper;
import com.example.lolwiki.repositories.Repositories;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WallpaperViewModel extends AndroidViewModel {
    /*
     * Area : variable
     */
    private Repositories repositories;

    /*
     * Area : function
     */
    public WallpaperViewModel(Application application) {
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
}
