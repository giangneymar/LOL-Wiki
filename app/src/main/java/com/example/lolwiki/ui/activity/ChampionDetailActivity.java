package com.example.lolwiki.ui.activity;

import androidx.annotation.NonNull;

import android.os.Bundle;

import com.example.lolwiki.R;
import com.example.lolwiki.bases.BaseActivity;
import com.example.lolwiki.databinding.ActivityChampionDetailBinding;
import com.example.lolwiki.ui.adapter.ChampionDetailPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ChampionDetailActivity extends BaseActivity {
    /*
     * Area : variable
     */
    private ActivityChampionDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChampionDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setActivityTitle(R.string.champion);
        setViewPagerTabLayout();
    }

    /*
     * Area : function
     */
    private void setViewPagerTabLayout() {
        binding.viewPager.setAdapter(new ChampionDetailPagerAdapter(this));
        TabLayoutMediator mediator = new TabLayoutMediator(binding.tabLayout, binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("Tổng Quan");

                        break;
                    case 1:
                        tab.setText("Kỹ Năng");
                        break;
                    case 2:
                        tab.setText("Build");
                        break;
                }
            }
        });
        mediator.attach();
    }

}