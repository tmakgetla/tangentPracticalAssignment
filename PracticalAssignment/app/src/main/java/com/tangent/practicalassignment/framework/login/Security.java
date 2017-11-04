package com.tangent.practicalassignment.framework.login;

import com.tangent.practicalassignment.domain.login.Login;
import com.tangent.practicalassignment.framework.comms.ObjectConverter;
import com.tangent.practicalassignment.utils.AppCache;
import com.tangent.practicalassignment.utils.AppConstants;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Ans Tech on 30/10/2017.
 */

public class Security {
    public final OkHttpClient client = new OkHttpClient();
    private ObjectConverter objectConverter =  new ObjectConverter();

    public void createSecureConnection(String url, String username, String password) throws Exception {
        RequestBody formBody = new FormBody.Builder()
                .add("username", username)
                .add("password", password)
                .build();
        Request request = new Request.Builder()
                .url(AppConstants.LOGIN_URL)
                .post(formBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()){
                throw new IOException("Unexpected code " + response);
            }else {
                String responseContent = response.body().string();
                setApplicationSession(responseContent);
            }
        }
    }

    private void setApplicationSession(String responseContent){
        Login login = objectConverter.getLoginDetails(responseContent);
        if(login != null){
            AppCache.session_token = login.getToken();
        }
    }
}
