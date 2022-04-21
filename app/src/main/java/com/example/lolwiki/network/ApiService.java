package com.example.lolwiki.network;

import com.example.lolwiki.models.Wallpaper;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("wallpaper")
    Call<List<Wallpaper>> getImageFromWallpapers();
}
