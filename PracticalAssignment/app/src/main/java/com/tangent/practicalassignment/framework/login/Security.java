package com.tangent.practicalassignment.framework.login;

import com.tangent.practicalassignment.domain.login.Login;
import com.tangent.practicalassignment.framework.comms.ObjectConverter;
import com.tangent.practicalassignment.utils.AppCache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;

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
                .url("http://staging.tangent.tngnt.co/api-token-auth/")
                .post(formBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()){
                throw new IOException("Unexpected code " + response);
            }else {
                String responseContent = response.body().string();
                //objectConverter.getLoginDetails(response);
                setApplictionSession(responseContent);
            }
        }
    }

    private void setApplictionSession(String responseContent){
        Login login = objectConverter.getLoginDetails(responseContent);
        if(login != null){
            AppCache.session_token = login.getToken();
        }
    }

/*    private final OkHttpClient.Builder client;

    {
        client = new OkHttpClient.Builder();
        client.authenticator(new Authenticator() {
            @Override
            public Request authenticate(Route route, Response response) throws IOException {
                if (responseCount(response) >= 3) {
                    return null; // If we've failed 3 times, give up. - in real life, never give up!!
                }
                String credential = Credentials.basic("pravin.gordhan", "pravin.gordhan");
                return response.request().newBuilder().header("Authorization", credential).build();
            }
        });
        client.connectTimeout(10, TimeUnit.SECONDS);
        client.writeTimeout(10, TimeUnit.SECONDS);
        client.readTimeout(30, TimeUnit.SECONDS);
    }

    private int responseCount(Response response) {
        int result = 1;
        while ((response = response.priorResponse()) != null) {
            result++;
        }
        return result;
    }*/
}
