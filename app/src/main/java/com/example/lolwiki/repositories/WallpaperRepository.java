package com.example.lolwiki.repositories;

import com.example.lolwiki.models.Wallpaper;
import com.example.lolwiki.network.ApiClient;
import com.example.lolwiki.network.ApiService;

import java.util.List;

import retrofit2.Call;

public class WallpaperRepository {
    /*
     * Area : variable
     */
    private ApiService apiService;

    /*
     * Area : function
     */
    public WallpaperRepository() {
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }

    public Call<List<Wallpaper>> getImage() {
        return apiService.getImageFromWallpapers();
    }
}
