package com.example.lolwiki.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lolwiki.models.Wallpaper;
import com.example.lolwiki.repositories.WallpaperRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WallpaperViewModel extends ViewModel {
    /*
     * Area : variable
     */
    private WallpaperRepository wallpaperRepository;

    /*
     * Area : function
     */
    public WallpaperViewModel() {
        wallpaperRepository = new WallpaperRepository();
    }

    public LiveData<List<Wallpaper>> getImage() {
        MutableLiveData<List<Wallpaper>> data = new MutableLiveData<>();
        wallpaperRepository.getImage().enqueue(new Callback<List<Wallpaper>>() {
            @Override
            public void onResponse(Call<List<Wallpaper>> call, Response<List<Wallpaper>> response) {
                data.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Wallpaper>> call, Throwable t) {
                data.postValue(null);
            }
        });
        return data;
    }
}
