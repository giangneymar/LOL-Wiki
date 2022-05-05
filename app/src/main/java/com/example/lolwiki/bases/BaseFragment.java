package com.example.lolwiki.bases;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lolwiki.R;

public abstract class BaseFragment extends Fragment {

    abstract public int getLayoutId();
    abstract public void onView(View view);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        onView(view);
        return view;
    }
}