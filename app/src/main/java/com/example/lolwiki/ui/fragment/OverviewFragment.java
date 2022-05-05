package com.example.lolwiki.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lolwiki.R;
import com.example.lolwiki.bases.BaseFragment;
import com.example.lolwiki.data.models.Champion;
import com.example.lolwiki.databinding.FragmentOverviewBinding;

import java.util.function.LongFunction;

public class OverviewFragment extends BaseFragment {

    private ImageView image;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_overview;
    }

    @Override
    public void onView(View view) {
        init(view);
        Bundle bundle = getArguments();
        if(bundle!=null){
            Champion champion = (Champion) bundle.getSerializable("aaa");
            Glide.with(view).load(champion.getImage()).into(image);
        }else {
            Log.d("aaa","123");
        }
    }

    private void init(View view){
        image = view.findViewById(R.id.image);
    }
}