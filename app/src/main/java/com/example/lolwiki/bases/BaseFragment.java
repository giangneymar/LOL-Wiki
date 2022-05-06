package com.example.lolwiki.bases;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment<VB extends ViewDataBinding> extends Fragment {
    /*
     * Area : variable
     */
    protected VB binding;

    /*
     * Area : override
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        return binding.getRoot();
    }

    /*
     * Area : function
     */
    public abstract int getLayoutId();
}