package com.example.lolwiki.ui.activity;

import static com.example.lolwiki.utils.KeyConstant.CHAMPION;
import static com.example.lolwiki.utils.KeyConstant.CHAMPION_OVERVIEW;
import static com.example.lolwiki.utils.KeyConstant.REQUEST_KEY_OVERVIEW;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.example.lolwiki.R;
import com.example.lolwiki.bases.BaseActivity;
import com.example.lolwiki.data.models.Champion;
import com.example.lolwiki.databinding.ActivityChampionDetailBinding;
import com.example.lolwiki.ui.adapter.ChampionDetailPagerAdapter;
import com.example.lolwiki.ui.fragment.AbilitiesFragment;
import com.example.lolwiki.ui.fragment.BuildFragment;
import com.example.lolwiki.ui.fragment.OverviewFragment;

public class ChampionDetailActivity extends BaseActivity {
    /*
     * Area : variable
     */
    private ActivityChampionDetailBinding binding;
    private ChampionDetailPagerAdapter adapter;
    private Champion champion;

    /*
     * Area : override
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChampionDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setViewPagerTabLayout();
        checkItemNavigation(R.id.champion);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_white);
        getDataChampionFromChampionActivity();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    /*
     * Area : function
     */
    private void setViewPagerTabLayout() {
        adapter = new ChampionDetailPagerAdapter(
                getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        );
        adapter.addFragment(new OverviewFragment(), getString(R.string.overview));
        adapter.addFragment(new AbilitiesFragment(), getString(R.string.abilities));
        adapter.addFragment(new BuildFragment(), getString(R.string.build));
        binding.viewPager.setAdapter(adapter);
        binding.viewPager.setOffscreenPageLimit(2);
        binding.tabLayout.setupWithViewPager(binding.viewPager);
        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 1) {
                    Fragment fragment = adapter.getFragmentByPosition(position);
                    if (fragment instanceof AbilitiesFragment) {
                        AbilitiesFragment abilitiesFragment = (AbilitiesFragment) fragment;
                        abilitiesFragment.getChampionID(champion.getId());
                    }
                }
                if (position == 2) {
                    Fragment fragment = adapter.getFragmentByPosition(position);
                    if (fragment instanceof BuildFragment) {
                        BuildFragment buildFragment = (BuildFragment) fragment;
                        buildFragment.getChampionID(champion.getId());
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void getDataChampionFromChampionActivity() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        champion = null;
        if (bundle != null) {
            champion = (Champion) bundle.getSerializable(CHAMPION);
            setActivityTitle(champion.getName());
            Bundle result = new Bundle();
            result.putSerializable(CHAMPION_FRAGMENT, champion);
            getSupportFragmentManager().setFragmentResult(REQUEST_KEY_FRAGMENT, result);
        }
    }
}