package com.example.lolwiki.ui.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lolwiki.R;
import com.example.lolwiki.data.models.Ability;
import com.example.lolwiki.databinding.ItemAbilitiesBinding;

import java.util.List;

public class AbilitiesAdapter extends RecyclerView.Adapter<AbilitiesAdapter.AbilitiesHolder> {
    /*
     * Area : variable
     */
    private LayoutInflater layoutInflater;
    private final List<Ability> abilities;

    /*
     * Area : override
     */
    @NonNull
    @Override
    public AbilitiesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemAbilitiesBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_abilities, parent, false);
        return new AbilitiesHolder(binding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AbilitiesHolder holder, int position) {
        Glide.with(holder.itemView).load(abilities.get(position).getImage()).into(holder.binding.imageAbilities);
        holder.binding.nameAbilities.setText(abilities.get(position).getName());
        holder.binding.keyAbilities.setText("Key : " + abilities.get(position).getKeyAbilities());
        holder.binding.cost.setText("Cost : " + abilities.get(position).getCost());
        holder.binding.coolDown.setText("Cool Down : " + abilities.get(position).getCoolDown());
        holder.binding.range.setText("Range : " + abilities.get(position).getRangeAbilities());
        holder.binding.description.setText(abilities.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        if (abilities != null) {
            return abilities.size();
        }
        return 0;
    }

    /*
     * Area : function
     */
    public AbilitiesAdapter(List<Ability> abilities) {
        this.abilities = abilities;
    }

    /*
     * Area : inner class
     */
    public static class AbilitiesHolder extends RecyclerView.ViewHolder {
        /*
         * Area : variable
         */
        private final ItemAbilitiesBinding binding;

        /*
         * Area : function
         */
        public AbilitiesHolder(ItemAbilitiesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
