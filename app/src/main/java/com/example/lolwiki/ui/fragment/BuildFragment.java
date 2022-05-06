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
import com.example.lolwiki.data.models.Item;
import com.example.lolwiki.databinding.FragmentBuildBinding;
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
        items = new ArrayList<>();
        items.add(new Item(1, "Giang", 1, 1, 1, "1", "1"));
        itemAdapter = new ItemAdapter(items);
        binding.containerItem.setAdapter(itemAdapter);
        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        viewModel.getItemsForChampion(0).observe(getViewLifecycleOwner(), new Observer<List<Item>>() {
            @Override
            public void onChanged(List<Item> items) {
                Log.d("aaa", items.size() + "");
            }
        });
    }
}