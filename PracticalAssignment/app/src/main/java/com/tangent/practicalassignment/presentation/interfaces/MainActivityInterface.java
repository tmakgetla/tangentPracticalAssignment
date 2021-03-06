package com.tangent.practicalassignment.presentation.interfaces;

import android.support.v4.app.Fragment;

import com.tangent.practicalassignment.domain.employees.Employees;

/**
 * Created by Ans Tech on 30/10/2017.
 */

public interface MainActivityInterface {
    void navigateToLoginScreen();
    void startFragment(Fragment fragment, int container, boolean replaceFrag);
    void initConnection(String userName, String password);
    void navigateToEmployeesScreen();
    void navigateToHomeScreen();
    void getEmployeesDetails();
    void navigateToUserProfileScreen(Employees employee);
    void navigateToStatisticsScreen();
    void getUserDetails();
    void navigateToProfileScreen();
    void navigateToPositionDataScreen();
}
