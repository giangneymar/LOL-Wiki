package com.example.lolwiki.view.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lolwiki.R;
import com.example.lolwiki.databinding.ItemChampionBinding;
import com.example.lolwiki.databinding.ItemChampionSuperBinding;
import com.example.lolwiki.models.Champion;

import java.util.List;

public class ChampionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static int TYPE_CHAMPION_SUPER = 1;
    private static int TYPE_CHAMPION = 2;
    private List<Champion> championList;
    private LayoutInflater layoutInflater;

    public ChampionAdapter(List<Champion> championList) {
        this.championList = championList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (TYPE_CHAMPION_SUPER == viewType) {
            if (layoutInflater == null) {
                layoutInflater = LayoutInflater.from(parent.getContext());
            }
            ItemChampionSuperBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_champion_super, parent, false);
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
        if(champion==null){
            return;
        }
//        if(TYPE_CHAMPION_SUPER == holder.getItemViewType()){
//            ItemChampionSuperHolder itemChampionSuperHolder = (ItemChampionSuperHolder) holder;
//            itemChampionSuperHolder.binding.image.setBackgroundColor(Color.RED);
//            itemChampionSuperHolder.binding.name.setText(champion.getName());
//        }else if(TYPE_CHAMPION == holder.getItemViewType()){
//            ItemChampionHolder itemChampionHolder = (ItemChampionHolder) holder;
//            itemChampionHolder.binding.image.setBackgroundColor(Color.BLACK);
//            itemChampionHolder.binding.name.setText(champion.getName());
//        }
    }

    @Override
    public int getItemCount() {
        if (championList != null) {
            return championList.size();
        }
        return 0;
    }

//    @Override
//    public int getItemViewType(int position) {
//        Champion champion = championList.get(position);
//        if (champion.isSuper()) {
//            return TYPE_CHAMPION_SUPER;
//        } else {
//            return TYPE_CHAMPION;
//        }
//    }

    public class ItemChampionSuperHolder extends RecyclerView.ViewHolder {
        private ItemChampionSuperBinding binding;

        public ItemChampionSuperHolder(ItemChampionSuperBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public class ItemChampionHolder extends RecyclerView.ViewHolder {
        private ItemChampionBinding binding;

        public ItemChampionHolder(ItemChampionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
