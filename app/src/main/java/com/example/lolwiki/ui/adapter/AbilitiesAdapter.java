package com.example.lolwiki.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lolwiki.R;
import com.example.lolwiki.data.models.Ability;
import com.example.lolwiki.databinding.ItemAbilitiesBinding;

import java.util.List;

public class AbilitiesAdapter extends RecyclerView.Adapter<AbilitiesAdapter.AbilitiesHolder> {
    /*
     * Area : variable
     */
    private LayoutInflater layoutInflater;
    private List<Ability> abilities;

    /*
     * Area : function
     */
    public AbilitiesAdapter(List<Ability> abilities) {
        this.abilities = abilities;
    }

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

    @Override
    public void onBindViewHolder(@NonNull AbilitiesHolder holder, int position) {
        holder.binding.nameAbilities.setText(abilities.get(position).getName());
        holder.binding.coolDown.setText(abilities.get(position).getCoolDown());
    }

    @Override
    public int getItemCount() {
        return abilities.size();
    }

    /*
     * Area : inner class
     */
    public class AbilitiesHolder extends RecyclerView.ViewHolder {
        /*
         * Area : variable
         */
        private ItemAbilitiesBinding binding;

        /*
         * Area : function
         */
        public AbilitiesHolder(ItemAbilitiesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
