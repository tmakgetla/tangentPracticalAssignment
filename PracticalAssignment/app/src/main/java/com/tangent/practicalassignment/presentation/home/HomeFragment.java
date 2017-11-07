package com.tangent.practicalassignment.presentation.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.tangent.practicalassignment.R;
import com.tangent.practicalassignment.presentation.MainActivity;
import com.tangent.practicalassignment.utils.AppCache;

/**
 * Created by Ans Tech on 31/10/2017.
 */

public class HomeFragment extends Fragment {
    private MainActivity mainActivity;
    private View rootView;
    private LinearLayout llEmployees;
    private LinearLayout llStatistics;
    private LinearLayout llPostionData;
    private LinearLayout llProfile;

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
        llEmployees = rootView.findViewById(R.id.ll_employees);
        llStatistics = rootView.findViewById(R.id.ll_statistics);
        llPostionData = rootView.findViewById(R.id.ll_position_data);
        llProfile = rootView.findViewById(R.id.ll_profile);
    }

    private void setUpListeners(){
        llEmployees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.getEmployeesDetails();
                while (AppCache.employees == null);
                mainActivity.navigateToEmployeesScreen();
            }
        });
        llPostionData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.getEmployeesDetails();
                while (AppCache.employees == null);
                mainActivity.navigateToPositionDataScreen();
            }
        });
        llProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.getUserDetails();
                while (AppCache.user == null);
                mainActivity.navigateToProfileScreen();
            }
        });
        llStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.getEmployeesDetails();
                while (AppCache.employees == null);
                mainActivity.navigateToStatisticsScreen();
            }
        });
    }
}
