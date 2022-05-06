package com.example.lolwiki.bases;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lolwiki.R;

public abstract class BaseFragment<VB extends ViewDataBinding> extends Fragment {

    protected VB binding;

    abstract public int getLayoutId();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,getLayoutId(),container,false);
        return binding.getRoot();
    }
}