package com.example.lolwiki.ui.activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.lolwiki.R;
import com.example.lolwiki.bases.BaseActivity;
import com.example.lolwiki.data.models.Champion;
import com.example.lolwiki.databinding.ActivityChampionBinding;
import com.example.lolwiki.ui.adapter.ChampionAdapter;
import com.example.lolwiki.viewmodels.ViewModel;

import java.util.Collections;
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
        init();
        clickListener();
    }

    /*
     * Area : override
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu_champion, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return super.onNavigationItemSelected(item);
    }

    /*
     * Area : function
     */
    private void updateRecyclerViewChampion(List<Champion> champions) {
        binding.containerChampion.setLayoutManager(new GridLayoutManager(this, 4));
        ChampionAdapter championAdapter = new ChampionAdapter(champions);
        binding.containerChampion.setAdapter(championAdapter);
    }

    private void init() {
        setActivityTitle((R.string.champion));
        checkItemNavigation(R.id.champion);
        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        viewModel.getAllChampion().observe(this, champions -> {
            Collections.sort(champions, Collections.reverseOrder());
            updateRecyclerViewChampion(champions);
        });
    }

    private void clickListener() {
        binding.positionJungle.setOnClickListener(view -> viewModel.filterChampionsByPosition(getString(R.string.position_jungle)).observe(this, new Observer<List<Champion>>() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onChanged(List<Champion> champions) {
                binding.positionJungle.setBorderColor(Color.YELLOW);
                binding.positionSp.setBorderColor(R.color.as_black);
                binding.positionTop.setBorderColor(R.color.as_black);
                binding.positionBot.setBorderColor(R.color.as_black);
                binding.positionMid.setBorderColor(R.color.as_black);
                Collections.sort(champions, Collections.reverseOrder());
                updateRecyclerViewChampion(champions);
            }
        }));

        binding.positionTop.setOnClickListener(view -> viewModel.filterChampionsByPosition(getString(R.string.position_top)).observe(this, new Observer<List<Champion>>() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onChanged(List<Champion> champions) {
                binding.positionTop.setBorderColor(Color.YELLOW);
                binding.positionSp.setBorderColor(R.color.as_black);
                binding.positionJungle.setBorderColor(R.color.as_black);
                binding.positionBot.setBorderColor(R.color.as_black);
                binding.positionMid.setBorderColor(R.color.as_black);
                Collections.sort(champions, Collections.reverseOrder());
                updateRecyclerViewChampion(champions);
            }
        }));

        binding.positionBot.setOnClickListener(view -> viewModel.filterChampionsByPosition(getString(R.string.position_bottom)).observe(this, new Observer<List<Champion>>() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onChanged(List<Champion> champions) {
                binding.positionBot.setBorderColor(Color.YELLOW);
                binding.positionSp.setBorderColor(R.color.as_black);
                binding.positionTop.setBorderColor(R.color.as_black);
                binding.positionJungle.setBorderColor(R.color.as_black);
                binding.positionMid.setBorderColor(R.color.as_black);
                Collections.sort(champions, Collections.reverseOrder());
                updateRecyclerViewChampion(champions);
            }
        }));

        binding.positionMid.setOnClickListener(view -> viewModel.filterChampionsByPosition(getString(R.string.position_middle)).observe(this, new Observer<List<Champion>>() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onChanged(List<Champion> champions) {
                binding.positionMid.setBorderColor(Color.YELLOW);
                binding.positionSp.setBorderColor(R.color.as_black);
                binding.positionTop.setBorderColor(R.color.as_black);
                binding.positionBot.setBorderColor(R.color.as_black);
                binding.positionJungle.setBorderColor(R.color.as_black);
                Collections.sort(champions, Collections.reverseOrder());
                updateRecyclerViewChampion(champions);
            }
        }));

        binding.positionSp.setOnClickListener(view -> viewModel.filterChampionsByPosition(getString(R.string.position_support)).observe(this, new Observer<List<Champion>>() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onChanged(List<Champion> champions) {
                binding.positionSp.setBorderColor(Color.YELLOW);
                binding.positionJungle.setBorderColor(R.color.as_black);
                binding.positionTop.setBorderColor(R.color.as_black);
                binding.positionBot.setBorderColor(R.color.as_black);
                binding.positionMid.setBorderColor(R.color.as_black);
                Collections.sort(champions, Collections.reverseOrder());
                updateRecyclerViewChampion(champions);
            }
        }));
    }

}