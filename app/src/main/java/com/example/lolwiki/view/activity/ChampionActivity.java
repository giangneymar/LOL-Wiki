package com.example.lolwiki.view.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lolwiki.R;
import com.example.lolwiki.bases.BaseActivity;
import com.example.lolwiki.databinding.ActivityChampionBinding;
import com.example.lolwiki.models.Champion;
import com.example.lolwiki.view.adapter.ChampionAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChampionActivity extends BaseActivity {
    /*
     * Area : variable
     */
    private ActivityChampionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChampionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setActivityTitle((R.string.hero));
        checkItemNavigation(R.id.champion);
        ChampionAdapter adapter = new ChampionAdapter(getListChampion());
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 4);
        binding.containerChampion.setLayoutManager(layoutManager);
        binding.containerChampion.setAdapter(adapter);
    }

    private List<Champion> getListChampion() {
        List<Champion> champions = new ArrayList<>();
        champions.add(new Champion("Giang", true));
        champions.add(new Champion("Uyen", true));
        champions.add(new Champion("Cham", false));
        champions.add(new Champion("Duyen", false));
        champions.add(new Champion("Quynh", false));
        return champions;
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