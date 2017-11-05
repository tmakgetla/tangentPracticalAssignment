package com.tangent.practicalassignment.presentation.userProfile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tangent.practicalassignment.R;
import com.tangent.practicalassignment.domain.employees.Employees;
import com.tangent.practicalassignment.presentation.MainActivity;
import com.tangent.practicalassignment.presentation.home.HomeFragment;
import com.tangent.practicalassignment.utils.AppCache;

/**
 * Created by Ans Tech on 5/11/2017.
 */

public class UserProfileFragment extends Fragment {
    private MainActivity mainActivity;
    private View rootView;
    private Employees employee;

    private TextView tvName;
    private TextView tvPosition;
    private TextView tvUserName;
    private TextView tvEmail;
    private TextView tvPhone;
    private TextView tvBirthDate;
    private TextView tvGitHub;

    public UserProfileFragment(){}

    public static UserProfileFragment newInstance(MainActivity mainActivity, Employees employee){
        UserProfileFragment userProfileFragment = new UserProfileFragment();
        userProfileFragment.mainActivity = mainActivity;
        userProfileFragment.employee = employee;
        return userProfileFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.user_profile_fragment, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        wireUpViews();
        setUpListeners();
        loadDetails();
    }

    private void wireUpViews(){
        tvName = rootView.findViewById(R.id.tv_user_profile_name);
        tvPosition = rootView.findViewById(R.id.tv_user_profile_short_bio);
        tvUserName = rootView.findViewById(R.id.tv_user_name);
        tvPhone = rootView.findViewById(R.id.tv_user_phone);
        tvBirthDate = rootView.findViewById(R.id.tv_user_birth_date);
        tvEmail = rootView.findViewById(R.id.tv_user_email);
        tvGitHub = rootView.findViewById(R.id.tv_user_github);
    }

    private void setUpListeners(){
    }

    private void loadDetails(){
        tvName.setText(employee.getUser().getFirstName() + " " + employee.getUser().getLastName());
        tvPosition.setText(employee.getPosition().getName());
        tvUserName.setText(employee.getUser().getUsername());
        tvPhone.setText(employee.getPhoneNumber());
        tvBirthDate.setText(employee.getBirthDate());
        tvEmail.setText(employee.getEmail());
        tvGitHub.setText(employee.getGithubUser());
    }
}