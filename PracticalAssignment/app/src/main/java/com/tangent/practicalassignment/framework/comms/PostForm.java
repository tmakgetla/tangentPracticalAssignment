package com.tangent.practicalassignment.framework.comms;

/**
 * Created by Ans Tech on 30/10/2017.
 */

import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class PostForm {
    public final OkHttpClient client = new OkHttpClient();

    public void run() throws Exception {
        RequestBody formBody = new FormBody.Builder()
                .add("username", "pravin.gordhan")
                .add("password", "pravin.gordhan")
                .build();
        Request request = new Request.Builder()
                .url("http://staging.tangent.tngnt.co/api-token-auth/")
                .post(formBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            //String s = response.body().string();
            //System.out.println(response.body().string());
        }
    }

/*    public static void main(String... args) throws Exception {
        new PostForm().run();
    }*/
}
