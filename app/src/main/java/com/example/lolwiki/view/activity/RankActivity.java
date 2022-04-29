package com.example.lolwiki.view.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.example.lolwiki.R;
import com.example.lolwiki.bases.BaseActivity;
import com.example.lolwiki.databinding.ActivityRankBinding;

public class RankActivity extends BaseActivity {
    /*
     * Area : variable
     */
    private ActivityRankBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRankBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setActivityTitle(R.string.rank);
        checkItemNavigation(R.id.rank);
    }

    /*
     * Area : override
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return super.onNavigationItemSelected(item);
    }
}