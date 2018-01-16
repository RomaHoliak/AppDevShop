package com.example.user.appdevshoptest.presenter;

import com.example.user.appdevshoptest.App;
import com.example.user.appdevshoptest.api.GetList;
import com.example.user.appdevshoptest.model.ApiResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PGetList {;
    private IGetList iGetList;

    public PGetList(IGetList iGetList){
        this.iGetList = iGetList;
    }

    public void getList(){
        iGetList.showProgress();
        App.getApi().create(GetList.class).getList().enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {

                iGetList.onSucces( response.body().getArrayList());
                iGetList.hideProgress();
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                iGetList.hideProgress();
                iGetList.onError("error");
            }
        });
    }
}
