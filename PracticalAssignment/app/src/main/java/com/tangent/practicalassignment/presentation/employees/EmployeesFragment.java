package com.tangent.practicalassignment.presentation.employees;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tangent.practicalassignment.R;
import com.tangent.practicalassignment.presentation.MainActivity;
import com.tangent.practicalassignment.presentation.login.LoginFragment;

/**
 * Created by Ans Tech on 31/10/2017.
 */

public class EmployeesFragment extends Fragment{
    private MainActivity mainActivity;
    private View rootView;
    public EmployeesFragment(){}

    public static EmployeesFragment newInstance(MainActivity mainActivity){
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

    private void wireUpViews(){

    }

    private void setUpListeners(){

    }
}
