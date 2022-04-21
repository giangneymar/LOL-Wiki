package com.example.lolwiki.view.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.example.lolwiki.R;
import com.example.lolwiki.databinding.ActivityHeroesBinding;

public class HeroesActivity extends BaseActivity {
    /*
     * Area : variable
     */
    private ActivityHeroesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHeroesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setActivityTitle((R.string.hero));
        checkItemNavigation(R.id.hero);
    }

    /*
     * Area : override
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu_heroes, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return super.onNavigationItemSelected(item);
    }
}