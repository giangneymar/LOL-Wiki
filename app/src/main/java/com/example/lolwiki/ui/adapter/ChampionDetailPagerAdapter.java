package com.example.lolwiki.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.lolwiki.ui.fragment.AbilitiesFragment;
import com.example.lolwiki.ui.fragment.BuildFragment;
import com.example.lolwiki.ui.fragment.OverviewFragment;

public class ChampionDetailPagerAdapter extends FragmentStateAdapter {
    public ChampionDetailPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new OverviewFragment();
            case 1:
                return new AbilitiesFragment();
            default:
                return new BuildFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
