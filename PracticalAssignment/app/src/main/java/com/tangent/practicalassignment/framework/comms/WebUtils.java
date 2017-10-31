package com.tangent.practicalassignment.framework.comms;

import com.tangent.practicalassignment.domain.employees.Employees;
import com.tangent.practicalassignment.utils.AppCache;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WebUtils {

    private static final OkHttpClient client = new OkHttpClient();
    private ObjectConverter objectConverter =  new ObjectConverter();

    public void getEmployeesDetails(OkHttpClient httpClient, String url, String sessionToken) throws Exception {
        Request request = new Request.Builder().url(url).header("Authorization", "Token " + sessionToken).build();
        Response response = httpClient.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }
        String responseContent = response.body().string();
        setEmployeesDetails(responseContent);
    }

    private void setEmployeesDetails(String responseContent){
        Employees[] employees = objectConverter.getEmployeeDetails(responseContent);
        if(employees != null){
            AppCache.employees = employees;
        }
    }

}