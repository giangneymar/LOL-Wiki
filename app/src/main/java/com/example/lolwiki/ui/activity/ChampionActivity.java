package com.example.lolwiki.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.lolwiki.R;
import com.example.lolwiki.bases.BaseActivity;
import com.example.lolwiki.data.models.Champion;
import com.example.lolwiki.databinding.ActivityChampionBinding;
import com.example.lolwiki.viewmodels.ViewModel;

import java.util.List;

public class ChampionActivity extends BaseActivity {
    /*
     * Area : variable
     */
    private ActivityChampionBinding binding;
    private ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChampionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setActivityTitle((R.string.hero));
        checkItemNavigation(R.id.champion);
        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        viewModel.getChampionsTierS().observe(this, new Observer<List<Champion>>() {
            @Override
            public void onChanged(List<Champion> champions) {
                Log.d("aaaaa", String.valueOf(champions.size()));
            }
        });
        viewModel.getChampionsNoneTier().observe(this, new Observer<List<Champion>>() {
            @Override
            public void onChanged(List<Champion> champions) {
                Log.d("aaaaa", String.valueOf(champions.size()));
            }
        });
        viewModel.filterChampionsByPosition("%Top").observe(this, new Observer<List<Champion>>() {
            @Override
            public void onChanged(List<Champion> champions) {
                Log.d("aaaaa", String.valueOf(champions.size()));
            }
        });
        viewModel.filterChampionsByLegacy("%Tank").observe(this, new Observer<List<Champion>>() {
            @Override
            public void onChanged(List<Champion> champions) {
                Log.d("aaaaa", String.valueOf(champions.size()));
            }
        });
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