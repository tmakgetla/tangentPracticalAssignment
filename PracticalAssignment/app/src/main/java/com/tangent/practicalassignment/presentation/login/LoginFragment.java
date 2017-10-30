package com.tangent.practicalassignment.presentation.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tangent.practicalassignment.R;
import com.tangent.practicalassignment.presentation.MainActivity;
import com.tangent.practicalassignment.presentation.interfaces.MainActivityInterface;

/**
 * Created by Ans Tech on 30/10/2017.
 */

public class LoginFragment extends Fragment {
    private MainActivity mainActivityInterface;
    private View rootView;
    public LoginFragment(){}

    public static LoginFragment newInstance(MainActivity mainActivityInterface){
        LoginFragment loginFragment = new LoginFragment();
        loginFragment.mainActivityInterface = mainActivityInterface;
        return loginFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.login_fragment, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
