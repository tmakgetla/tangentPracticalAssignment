package com.tangent.practicalassignment.presentation.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tangent.practicalassignment.R;
import com.tangent.practicalassignment.presentation.MainActivity;
import com.tangent.practicalassignment.presentation.interfaces.MainActivityInterface;
import com.tangent.practicalassignment.presentation.login.interfaces.LoginInterface;

/**
 * Created by Ans Tech on 30/10/2017.
 */

public class LoginFragment extends Fragment implements LoginInterface{
    private MainActivity mainActivity;
    private View rootView;

    private EditText etUserName;
    private EditText etPassword;
    private Button btnSignIn;
    private TextView tvForgotPassword;

    private String enteredUserName;
    private String enteredPassword;

    public LoginFragment(){}

    public static LoginFragment newInstance(MainActivity mainActivity){
        LoginFragment loginFragment = new LoginFragment();
        loginFragment.mainActivity = mainActivity;
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
        wireUpViews();
        setUpListeners();
    }

    private void wireUpViews(){
        etUserName = rootView.findViewById(R.id.et_user_name);
        etPassword = rootView.findViewById(R.id.et_password);
        btnSignIn = rootView.findViewById(R.id.btn_sign_in);
        tvForgotPassword = rootView.findViewById(R.id.tv_forgot_password);
    }

    private void setUpListeners(){
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateCredentials();
            }
        });

        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mainActivity, "Feature coming soon ...", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void validateCredentials(){
        enteredUserName = etUserName.getText().toString();
        enteredPassword = etPassword.getText().toString();
        if(enteredUserName.equals("") || enteredPassword.equals("")){
            Toast.makeText(mainActivity, "Please fill all fields!", Toast.LENGTH_LONG).show();
        } else {
            mainActivity.initConnection(enteredUserName,enteredPassword);
        }
    }
}
