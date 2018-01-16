package com.example.user.appdevshoptest;

import android.app.Application;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    private static Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://e97b7234-fde2-4f99-8414-b368658a363b.mock.pstmn.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static Retrofit getApi() {
        return retrofit;
    }
}
