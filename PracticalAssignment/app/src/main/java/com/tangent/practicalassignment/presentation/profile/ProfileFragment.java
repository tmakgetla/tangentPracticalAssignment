package com.tangent.practicalassignment.presentation.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.tangent.practicalassignment.R;
import com.tangent.practicalassignment.domain.employees.dto.User;
import com.tangent.practicalassignment.presentation.MainActivity;
import com.tangent.practicalassignment.presentation.statistics.StatisticsFragment;
import com.tangent.practicalassignment.utils.AppCache;

/**
 * Created by Ans Tech on 6/11/2017.
 */

public class ProfileFragment extends Fragment{
    private MainActivity mainActivity;
    private View rootView;
    private TextView tvName;
    private TextView tvPosition;
    private TextView tvUserName;
    private TextView tvEmail;
    private TextView tvPhone;
    private TextView tvBirthDate;
    private TextView tvGitHub;
    private User user[];

    public ProfileFragment(){}

    public static ProfileFragment newInstance(MainActivity mainActivity){
        ProfileFragment profileFragment = new ProfileFragment();
        profileFragment.mainActivity = mainActivity;
        profileFragment.user = AppCache.user;
        return profileFragment;
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
        tvName.setText(user[0].getFirstName() + " " + user[0].getLastName());
        tvPosition.setVisibility(View.GONE);
        tvUserName.setText(user[0].getUsername());
        tvPhone.setVisibility(View.GONE);
        tvBirthDate.setVisibility(View.GONE);
        tvEmail.setText(user[0].getEmail());
        tvGitHub.setVisibility(View.GONE);
    }
}
