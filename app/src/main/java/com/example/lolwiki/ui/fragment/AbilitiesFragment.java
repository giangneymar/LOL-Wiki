package com.example.lolwiki.ui.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.lolwiki.R;
import com.example.lolwiki.bases.BaseFragment;
import com.example.lolwiki.data.models.Ability;
import com.example.lolwiki.databinding.FragmentAbilitiesBinding;
import com.example.lolwiki.ui.adapter.AbilitiesAdapter;
import com.example.lolwiki.viewmodels.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class AbilitiesFragment extends BaseFragment<FragmentAbilitiesBinding> {

    private AbilitiesAdapter abilitiesAdapter;
    private List<Ability> abilities;
    private ViewModel viewModel;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_abilities;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        abilities = new ArrayList<>();
        abilities.add(new Ability(1, 1, "1", "1", "1", "1", "1", "1", "1"));
        abilities.add(new Ability(1, 1, "1", "1", "1", "1", "1", "1", "1"));
        abilitiesAdapter = new AbilitiesAdapter(abilities);
        binding.containerAbilities.setAdapter(abilitiesAdapter);
        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        viewModel.getAbilitiesForChampion(0).observe(getViewLifecycleOwner(), new Observer<List<Ability>>() {
            @Override
            public void onChanged(List<Ability> abilities) {
                Log.d("aaa", abilities.size() + "");
            }
        });
    }
}