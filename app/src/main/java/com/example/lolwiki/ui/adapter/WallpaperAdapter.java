package com.example.lolwiki.ui.adapter;

import static com.example.lolwiki.utils.KeyConstant.WALLPAPER;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lolwiki.R;
import com.example.lolwiki.data.models.Wallpaper;
import com.example.lolwiki.databinding.ItemWallpaperBinding;
import com.example.lolwiki.ui.activity.WallpaperDetailActivity;

import java.util.List;

public class WallpaperAdapter extends RecyclerView.Adapter<WallpaperAdapter.ItemWallpaperHolder> {
    /*
     * Area : variable
     */
    private final List<Wallpaper> wallpapers;
    private LayoutInflater layoutInflater;

    /*
     * Area : override
     */
    @NonNull
    @Override
    public ItemWallpaperHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemWallpaperBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_wallpaper, parent, false);
        return new ItemWallpaperHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemWallpaperHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(wallpapers.get(position).getImage())
                .into(holder.binding.image);
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), WallpaperDetailActivity.class);
            intent.putExtra(WALLPAPER, wallpapers.get(position));
            layoutInflater.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        if (wallpapers == null) {
            return 0;
        }
        return wallpapers.size();
    }

    /*
     * Area : function
     */
    public WallpaperAdapter(List<Wallpaper> wallpapers) {
        this.wallpapers = wallpapers;
    }

    /*
     * Area : inner class
     */
    public static class ItemWallpaperHolder extends RecyclerView.ViewHolder {
        /*
         * Area : variable
         */
        private final ItemWallpaperBinding binding;

        /*
         * Area : function
         */
        public ItemWallpaperHolder(ItemWallpaperBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
