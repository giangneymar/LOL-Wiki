package com.example.lolwiki.ui.fragment;

import static com.example.lolwiki.utils.KeyConstant.CHAMPION_OVERVIEW;
import static com.example.lolwiki.utils.KeyConstant.REQUEST_KEY_OVERVIEW;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.lolwiki.R;
import com.example.lolwiki.bases.BaseFragment;
import com.example.lolwiki.data.models.Champion;
import com.example.lolwiki.databinding.FragmentOverviewBinding;

public class OverviewFragment extends BaseFragment<FragmentOverviewBinding> {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_overview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getParentFragmentManager().setFragmentResultListener(REQUEST_KEY_OVERVIEW, this, (requestKey, result) -> {
            Champion champion = (Champion) result.getSerializable(CHAMPION_OVERVIEW);
            Log.d("bbbba", champion + "");
            Glide.with(view).load(champion.getImage()).into(binding.image);
            binding.blueEssence.setText(champion.getBlueEssence());
           binding.riotPoints.setText(champion.getRiotPoints());
            binding.releaseDate.setText(champion.getReleaseDate());
            binding.tier.setText(champion.getTier());
            binding.adaptiveType.setText(champion.getAdaptiveType());
            binding.resource.setText(champion.getResource());
            binding.legacyName.setText(champion.getLegacyName());
            binding.positionName.setText(champion.getPositionName());
            binding.classes.setText(champion.getClasses());
            binding.health.setText(champion.getHealth());
            binding.healthRegen.setText(champion.getHealthRegen());
            binding.armor.setText(champion.getArmor());
            binding.magicResist.setText(champion.getMagicResist());
            binding.moveSpeed.setText(champion.getMoveSpeed());
            binding.attackDamage.setText(champion.getAttackDamage());
            binding.attackRange.setText(champion.getAttackRange());
            binding.bonusAs.setText(champion.getBonusAS());
            binding.description.setText(champion.getDescription());
        });
    }
}