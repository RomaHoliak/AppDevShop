package com.example.user.appdevshoptest.api;

import com.example.user.appdevshoptest.model.ApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetList {

    @GET("list")
    Call<ApiResponse> getList();
}
