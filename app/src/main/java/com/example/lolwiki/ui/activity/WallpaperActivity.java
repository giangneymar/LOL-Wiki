package com.example.lolwiki.ui.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lolwiki.R;
import com.example.lolwiki.bases.BaseActivity;
import com.example.lolwiki.databinding.ActivityWallpaperBinding;
import com.example.lolwiki.data.models.Champion;
import com.example.lolwiki.data.models.Wallpaper;
import com.example.lolwiki.ui.adapter.WallpaperAdapter;
import com.example.lolwiki.viewmodels.ViewModel;

import java.util.List;

public class WallpaperActivity extends BaseActivity {
    /*
     * Area : variable
     */
    private ActivityWallpaperBinding binding;
    private ViewModel wallpaperViewModel;
    private List<Wallpaper> wallpapers;
    private WallpaperAdapter wallpaperAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWallpaperBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setActivityTitle(R.string.wallpaper);
        checkItemNavigation(R.id.wallpaper);
        init();
    }

    /*
     * Area : function
     */
    private void init() {
        wallpaperViewModel = new ViewModelProvider(this).get(ViewModel.class);
        getImage();
    }

    private void updateRecyclerview(List<Wallpaper> wallpapers) {
        wallpaperAdapter = new WallpaperAdapter(wallpapers);
        binding.wallpaperContainer.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        binding.wallpaperContainer.setLayoutManager(layoutManager);
        binding.wallpaperContainer.setAdapter(wallpaperAdapter);
    }

    private void getImage() {
        wallpaperViewModel.getAllWallpaper().observe(this, this::updateRecyclerview);
    }

    /*
     * Area : override
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return super.onNavigationItemSelected(item);
    }
}