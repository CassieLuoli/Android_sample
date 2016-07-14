package com.huawei.sirius.thinktank.data.rest;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private static RestClient instance = new RestClient();
    private final UserApi userApi;

    private RestClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.HOST)
                .client(new OkHttpClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        userApi = retrofit.create(UserApi.class);
    }

    public static RestClient getInstance() {
        return instance;
    }

    public UserApi getUserApi() {
        return userApi;
    }

}

