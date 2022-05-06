package com.example.lolwiki.ui.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lolwiki.R;
import com.example.lolwiki.bases.BaseFragment;
import com.example.lolwiki.data.models.Item;
import com.example.lolwiki.databinding.FragmentBuildBinding;
import com.example.lolwiki.ui.adapter.ItemAdapter;
import com.example.lolwiki.viewmodels.ViewModel;

import java.util.List;

public class BuildFragment extends BaseFragment<FragmentBuildBinding> {
    /*
     * Area : override
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_build;
    }
    /*
     * Area : function
     */
    private void updateRecyclerViewItem(List<Item> items) {
        binding.containerItem.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        ItemAdapter itemAdapter = new ItemAdapter(items);
        binding.containerItem.setAdapter(itemAdapter);
    }

    public void getChampionID(int championID) {
        ViewModel viewModel = new ViewModelProvider(this).get(ViewModel.class);
        viewModel.getItemsForChampion(championID).observe(this, items -> {
            updateRecyclerViewItem(items);
            Glide.with(this).load(items.get(0).getImage()).into(binding.item1);
            Glide.with(this).load(items.get(1).getImage()).into(binding.item2);
            Glide.with(this).load(items.get(2).getImage()).into(binding.item3);
            Glide.with(this).load(items.get(3).getImage()).into(binding.item4);
            Glide.with(this).load(items.get(4).getImage()).into(binding.item5);
            Glide.with(this).load(items.get(5).getImage()).into(binding.item6);
        });
    }
}