package com.example.lolwiki.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lolwiki.R;
import com.example.lolwiki.data.models.Item;
import com.example.lolwiki.databinding.ItemItemBinding;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {
    /*
     * Area : variable
     */
    private LayoutInflater layoutInflater;
    private List<Item> items;
    private Context context;

    /*
     * Area : function
     */
    public ItemAdapter(List<Item> items) {
        this.items = items;
    }

    /*
     * Area : override
     */
    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_item, parent, false);
        return new ItemHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Item item = items.get(position);
        if (item != null) {
            holder.binding.nameItem.setText(item.getName());
            Glide.with(context)
                    .load(item.getImage())
                    .into(holder.binding.imageItem);
            holder.binding.description.setText(String.valueOf(item.getDescription()));
            holder.binding.recipePrice.setText("Recipe Price: " + item.getRecipePrice());
            holder.binding.sellPrice.setText("Sell Price: " + item.getSellPrice());
            holder.binding.totalPrice.setText("Total Price: " + item.getTotalPrice());
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    /*
     * Area : inner class
     */
    public class ItemHolder extends RecyclerView.ViewHolder {
        /*
         * Area : variable
         */
        private ItemItemBinding binding;

        public ItemHolder(ItemItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
