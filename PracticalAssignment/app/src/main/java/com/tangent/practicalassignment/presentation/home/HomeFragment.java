package com.tangent.practicalassignment.presentation.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tangent.practicalassignment.R;
import com.tangent.practicalassignment.presentation.MainActivity;

/**
 * Created by Ans Tech on 31/10/2017.
 */

public class HomeFragment extends Fragment {
    private MainActivity mainActivity;
    private View rootView;
    public HomeFragment(){}

    public static HomeFragment newInstance(MainActivity mainActivity){
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.mainActivity = mainActivity;
        return homeFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.home_page_fragment, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        wireUpViews();
        setUpListeners();
    }

    private void wireUpViews(){
    }

    private void setUpListeners(){
    }
}
