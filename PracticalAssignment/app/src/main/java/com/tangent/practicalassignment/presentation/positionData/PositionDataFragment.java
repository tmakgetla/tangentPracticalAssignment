package com.tangent.practicalassignment.presentation.positionData;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tangent.practicalassignment.R;
import com.tangent.practicalassignment.domain.employees.Employees;
import com.tangent.practicalassignment.domain.employees.dto.User;
import com.tangent.practicalassignment.presentation.MainActivity;
import com.tangent.practicalassignment.presentation.employees.adapters.Adapter;
import com.tangent.practicalassignment.presentation.positionData.adapters.PositionDataAdapter;
import com.tangent.practicalassignment.presentation.profile.ProfileFragment;
import com.tangent.practicalassignment.utils.AppCache;

/**
 * Created by Ans Tech on 7/11/2017.
 */

public class PositionDataFragment extends Fragment {
    private MainActivity mainActivity;
    private View rootView;

    private RecyclerView mRecyclerView;
    PositionDataAdapter mAdapter;

    public PositionDataFragment() {
    }

    public static PositionDataFragment newInstance(MainActivity mainActivity) {
        PositionDataFragment positionDataFragment = new PositionDataFragment();
        positionDataFragment.mainActivity = mainActivity;
        return positionDataFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.position_data_fragment, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        wireUpViews();
        loadUsers();
    }

    private void wireUpViews() {
        mRecyclerView = rootView.findViewById(R.id.rv_position_data);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mainActivity));
    }

    private void setUpListeners() {
    }

    public void loadUsers() {
        mAdapter = new PositionDataAdapter(AppCache.employees, mainActivity);
        mRecyclerView.setAdapter(mAdapter);
    }
}