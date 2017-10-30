package com.tangent.practicalassignment.presentation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.tangent.practicalassignment.R;
import com.tangent.practicalassignment.framework.comms.WebUtils;
import com.tangent.practicalassignment.framework.login.Security;
import com.tangent.practicalassignment.presentation.interfaces.MainActivityInterface;
import com.tangent.practicalassignment.presentation.login.LoginFragment;
import com.tangent.practicalassignment.utils.AppCache;
import com.tangent.practicalassignment.utils.AppConstants;

import java.util.List;
import java.util.Map;

import okhttp3.Headers;

import static com.tangent.practicalassignment.utils.AppCache.okHttpClient;

public class MainActivity extends AppCompatActivity implements MainActivityInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigateToLoginScreen();
        //init();
    }

    @Override
    public void startFragment(Fragment fragment, int container, boolean replaceFrag){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(replaceFrag){
            fragmentTransaction.replace(container, fragment);
        } else {
            fragmentTransaction.add(container, fragment);
        }
        fragmentTransaction.commit();
    }

    @Override
    public void navigateToLoginScreen(){
        startFragment(LoginFragment.newInstance(this), R.id.fragment_container, false);
    }

    private void init(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Security security = new Security();
                    security.createSecureConnection(AppConstants.LOGIN_URL,"pravin.gordhan", "pravin.gordhan");

                    okHttpClient = security.client;

                    WebUtils webUtils = new WebUtils();
                    webUtils.getEmployeesDetails(okHttpClient, "http://staging.tangent.tngnt.co/api/employee/", AppCache.session_token);

                }catch (Exception e){
                    e.printStackTrace();
                    Log.i("main", e.getMessage());
                }
            }
        }).start();
    }
}
