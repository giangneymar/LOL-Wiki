package com.example.lolwiki.ui.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.lolwiki.R;
import com.example.lolwiki.bases.BaseFragment;
import com.example.lolwiki.databinding.FragmentAbilitiesBinding;
import com.example.lolwiki.ui.adapter.AbilitiesAdapter;
import com.example.lolwiki.viewmodels.ViewModel;

public class AbilitiesFragment extends BaseFragment<FragmentAbilitiesBinding> {
    /*
     * Area : override
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_abilities;
    }

    /*
     * Area : function
     */
    public void getChampionID(int id) {
        ViewModel viewModel = new ViewModelProvider(this).get(ViewModel.class);
        viewModel.getAbilitiesForChampion(id).observe(getViewLifecycleOwner(), abilities -> {
            AbilitiesAdapter abilitiesAdapter = new AbilitiesAdapter(abilities);
            binding.containerAbilities.setAdapter(abilitiesAdapter);
        });
    }
}