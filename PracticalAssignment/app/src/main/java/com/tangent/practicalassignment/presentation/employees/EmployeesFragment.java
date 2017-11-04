package com.tangent.practicalassignment.presentation.employees;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tangent.practicalassignment.R;
import com.tangent.practicalassignment.presentation.MainActivity;
import com.tangent.practicalassignment.presentation.employees.adapters.Adapter;
import com.tangent.practicalassignment.presentation.login.LoginFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ans Tech on 31/10/2017.
 */

public class EmployeesFragment extends Fragment {
    private MainActivity mainActivity;
    private View rootView;

    public EmployeesFragment() {
    }

    private RecyclerView mRecyclerView;
    private List<String> list = new ArrayList<String>();
    Adapter mAdapter;

    public static EmployeesFragment newInstance(MainActivity mainActivity) {
        EmployeesFragment employeesFragment = new EmployeesFragment();
        employeesFragment.mainActivity = mainActivity;
        return employeesFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.employees_fragment, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        wireUpViews();
        setUpListeners();
    }

    private void wireUpViews() {
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mainActivity));
        arrayList();
        mAdapter = new Adapter(list, mainActivity);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void setUpListeners() {
        mRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void arrayList() {
        for (int i = 0; i < 20; i++) {
            list.add("This is row of number " + i);
        }
    }
}
