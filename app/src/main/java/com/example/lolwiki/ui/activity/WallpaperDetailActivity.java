package com.example.lolwiki.ui.activity;

import static com.example.lolwiki.utils.KeyConstant.WALLPAPER;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.lolwiki.R;
import com.example.lolwiki.databinding.ActivityWallpaperDetailBinding;
import com.example.lolwiki.data.models.Wallpaper;
import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;

public class WallpaperDetailActivity extends AppCompatActivity {
    /*
     * Area : variable
     */
    private ActivityWallpaperDetailBinding binding;
    private Wallpaper wallpaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWallpaperDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getImageFromWallpaperActivity();
        onClick();
    }

    /*
     * Area : function
     */
    private void getImageFromWallpaperActivity() {
        wallpaper = (Wallpaper) getIntent().getSerializableExtra(WALLPAPER);
        Glide.with(this)
                .load(wallpaper.getImage())
                .into(binding.image);
    }

    private void onClick() {
        binding.back.setOnClickListener(view -> onBackPressed());
        binding.done.setOnClickListener(this::setWallpaper);
    }

    private void setWallpaper(View view) {
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
        Glide.with(getApplicationContext()).asBitmap().load(wallpaper.getImage()).listener(new RequestListener<Bitmap>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                try {
                    runOnUiThread(() -> {
                        Snackbar snackbar = Snackbar.make(view, getString(R.string.success), Snackbar.LENGTH_SHORT);
                        View snackBarView = snackbar.getView();
                        snackBarView.setBackgroundColor(Color.YELLOW);
                        TextView textSnackBar = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text);
                        textSnackBar.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        textSnackBar.setTextColor(Color.BLUE);
                        snackbar.show();
                    });
                    wallpaperManager.setBitmap(resource);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return false;
            }
        }).submit();
    }

    /*
     * Area : override
     */
    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}