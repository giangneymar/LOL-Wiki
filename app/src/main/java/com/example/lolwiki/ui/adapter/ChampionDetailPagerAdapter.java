package com.example.lolwiki.ui.adapter;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ChampionDetailPagerAdapter extends FragmentPagerAdapter {
    /*
     * Area : variable
     */
    private final ArrayList<Fragment> listFragment = new ArrayList<>();
    private final ArrayList<String> listTitle = new ArrayList<>();

    /*
     * Area : override
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTitle.get(position);
    }

    /*
     * function
     */
    public ChampionDetailPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public void addFragment(Fragment fragment, String title) {
        listFragment.add(fragment);
        listTitle.add(title);
    }

    public Fragment getFragmentByPosition(int position) {
        if (position <= (listFragment.size() - 1)) {
            return listFragment.get(position);
        }
        return null;
    }
}
