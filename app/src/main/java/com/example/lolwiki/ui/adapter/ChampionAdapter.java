package com.example.lolwiki.ui.adapter;

import static com.example.lolwiki.utils.KeyConstant.CHAMPION;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lolwiki.R;
import com.example.lolwiki.data.models.Champion;
import com.example.lolwiki.databinding.ItemChampionBinding;
import com.example.lolwiki.databinding.ItemChampionSBinding;
import com.example.lolwiki.ui.activity.ChampionDetailActivity;

import java.util.List;

public class ChampionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    /*
     * Area : variable
     */
    private static final int TYPE_CHAMPION_SUPER = 1;
    private static final int TYPE_CHAMPION = 2;
    private List<Champion> championList;
    private LayoutInflater layoutInflater;

    /*
     * Area : override
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (TYPE_CHAMPION_SUPER == viewType) {
            if (layoutInflater == null) {
                layoutInflater = LayoutInflater.from(parent.getContext());
            }
            ItemChampionSBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_champion_s, parent, false);
            return new ItemChampionSuperHolder(binding);
        } else if (TYPE_CHAMPION == viewType) {
            if (layoutInflater == null) {
                layoutInflater = LayoutInflater.from(parent.getContext());
            }
            ItemChampionBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_champion, parent, false);
            return new ItemChampionHolder(binding);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Champion champion = championList.get(position);
        if (champion != null) {
            if (TYPE_CHAMPION_SUPER == holder.getItemViewType()) {
                ItemChampionSuperHolder itemChampionSuperHolder = (ItemChampionSuperHolder) holder;
                Glide.with(holder.itemView)
                        .load(champion.getImage())
                        .into(itemChampionSuperHolder.binding.imageChampionS);
                itemChampionSuperHolder.binding.nameChampionS.setText(champion.getName());
                itemChampionSuperHolder.binding.getRoot().setOnClickListener(view -> {
                    switchScreen(position);
                });
            } else if (TYPE_CHAMPION == holder.getItemViewType()) {
                ItemChampionHolder itemChampionHolder = (ItemChampionHolder) holder;
                Glide.with(holder.itemView)
                        .load(champion.getImage())
                        .into(itemChampionHolder.binding.imageChampion);
                itemChampionHolder.binding.nameChampion.setText(champion.getName());
                itemChampionHolder.binding.getRoot().setOnClickListener(view -> {
                    switchScreen(position);
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        if (championList != null) {
            return championList.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        Champion champion = championList.get(position);
        if (champion.getTier().equals("s")) {
            return TYPE_CHAMPION_SUPER;
        } else {
            return TYPE_CHAMPION;
        }
    }

    /*
     * Area : function
     */
    private void switchScreen(int position) {
        Intent intent = new Intent(layoutInflater.getContext(), ChampionDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(CHAMPION, championList.get(position));
        intent.putExtras(bundle);
        layoutInflater.getContext().startActivity(intent);
    }

    public ChampionAdapter(List<Champion> championList) {
        this.championList = championList;
    }

    public static class ItemChampionSuperHolder extends RecyclerView.ViewHolder {
        private final ItemChampionSBinding binding;

        public ItemChampionSuperHolder(ItemChampionSBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public static class ItemChampionHolder extends RecyclerView.ViewHolder {
        private final ItemChampionBinding binding;

        public ItemChampionHolder(ItemChampionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public void addAll(List<Champion> data) {
        if (championList != null) {
            championList.clear();
        }
        this.championList = data;
    }
}
