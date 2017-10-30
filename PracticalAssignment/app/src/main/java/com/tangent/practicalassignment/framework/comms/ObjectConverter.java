package com.tangent.practicalassignment.framework.comms;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tangent.practicalassignment.domain.employees.Employees;
import com.tangent.practicalassignment.domain.login.Login;

/**
 * Created by Ans Tech on 30/10/2017.
 */

public class ObjectConverter {
    Gson gson = new Gson();

    public Login getLoginDetails(String responseContent){
        Login login = null;
        try {
            login = gson.fromJson(responseContent, Login.class);
        }catch (JsonSyntaxException e){
            Log.i("ObjectConverter", e.toString());
        }
        return login;
    }

    public Employees[] getEmployeeDetails(String responseContent){
        Employees[] employees = null;
        try {
            employees = gson.fromJson(responseContent, Employees[].class);
        }catch (JsonSyntaxException e){
            Log.i("ObjectConverter", e.toString());
        }
        return employees;
    }
}
