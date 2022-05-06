package com.example.lolwiki.ui.activity;

import static com.example.lolwiki.utils.KeyConstant.CHAMPION;
import static com.example.lolwiki.utils.KeyConstant.CHAMPION_OVERVIEW;
import static com.example.lolwiki.utils.KeyConstant.REQUEST_KEY_OVERVIEW;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.lolwiki.R;
import com.example.lolwiki.bases.BaseActivity;
import com.example.lolwiki.data.models.Champion;
import com.example.lolwiki.databinding.ActivityChampionDetailBinding;
import com.example.lolwiki.ui.adapter.ChampionDetailPagerAdapter;
import com.example.lolwiki.ui.fragment.OverviewFragment;
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
        setViewPagerTabLayout();
        checkItemNavigation(R.id.champion);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            Champion champion = (Champion) bundle.getSerializable(CHAMPION);
            setActivityTitle(champion.getName());
            Bundle result = new Bundle();
            result.putSerializable(CHAMPION_OVERVIEW, champion);
            getSupportFragmentManager().setFragmentResult(REQUEST_KEY_OVERVIEW,result);
        }
        ;
    }

    /*
     * Area : function
     */
    private void setViewPagerTabLayout() {
        binding.viewPager.setAdapter(new ChampionDetailPagerAdapter(this));
        TabLayoutMediator mediator = new TabLayoutMediator(binding.tabLayout, binding.viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Overview");
                    break;
                case 1:
                    tab.setText("Abilities");
                    break;
                case 2:
                    tab.setText("Build");
                    break;
            }
        });
        mediator.attach();
    }

}