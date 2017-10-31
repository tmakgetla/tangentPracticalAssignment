package com.tangent.practicalassignment.presentation.interfaces;

import android.support.v4.app.Fragment;

/**
 * Created by Ans Tech on 30/10/2017.
 */

public interface MainActivityInterface {
    void navigateToLoginScreen();
    void startFragment(Fragment fragment, int container, boolean replaceFrag);
    void initConnection();
}
