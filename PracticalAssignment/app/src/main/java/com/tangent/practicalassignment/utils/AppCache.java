package com.tangent.practicalassignment.utils;

import com.tangent.practicalassignment.domain.employees.Employees;
import com.tangent.practicalassignment.domain.employees.dto.User;
import com.tangent.practicalassignment.domain.login.Login;

import okhttp3.OkHttpClient;

/**
 * Created by Ans Tech on 30/10/2017.
 */

public class AppCache {

    public static String session_token;
    public static OkHttpClient okHttpClient;
    public static Employees[] employees;
    public static User[] user;
}