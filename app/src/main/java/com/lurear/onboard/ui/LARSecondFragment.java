package com.lurear.onboard.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lurear.R;

public class LARSecondFragment extends Fragment {
    // Store instance variables

    // newInstance constructor for creating fragment with arguments
    public static LARSecondFragment newInstance() {
        LARSecondFragment fragmentSecond = new LARSecondFragment();
        return fragmentSecond;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        return view;
    }
}