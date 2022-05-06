package com.example.lolwiki.ui.fragment;

import static com.example.lolwiki.utils.KeyConstant.CHAMPION_OVERVIEW;
import static com.example.lolwiki.utils.KeyConstant.REQUEST_KEY_OVERVIEW;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.lolwiki.R;
import com.example.lolwiki.bases.BaseFragment;
import com.example.lolwiki.data.models.Champion;
import com.example.lolwiki.data.models.Item;
import com.example.lolwiki.databinding.FragmentBuildBinding;
import com.example.lolwiki.ui.adapter.ChampionAdapter;
import com.example.lolwiki.ui.adapter.ItemAdapter;
import com.example.lolwiki.viewmodels.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class BuildFragment extends BaseFragment<FragmentBuildBinding> {

    private ItemAdapter itemAdapter;
    private List<Item> items;
    private ViewModel viewModel;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_build;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void getChampionID(int championID) {
        viewModel = new ViewModelProvider(this).get(ViewModel.class);
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

    private void updateRecyclerViewItem(List<Item> items) {
        binding.containerItem.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        ItemAdapter itemAdapter = new ItemAdapter(items);
        binding.containerItem.setAdapter(itemAdapter);
    }
}