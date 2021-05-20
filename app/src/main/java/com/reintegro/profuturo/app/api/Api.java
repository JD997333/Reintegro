package com.reintegro.profuturo.app.api;

import com.reintegro.profuturo.app.util.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private static ApiClient client;
    private static Retrofit retrofit;

    public static ApiClient getClient() {
        if (client == null) {
            HttpLoggingInterceptor httpLoggingInterceptor;
            httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor)
                    .connectTimeout(120, TimeUnit.SECONDS)
                    .build();

            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .baseUrl(Constants.URL_BASE)
                    .build();

            client = retrofit.create(ApiClient.class);
        }

        return client;
    }
}
