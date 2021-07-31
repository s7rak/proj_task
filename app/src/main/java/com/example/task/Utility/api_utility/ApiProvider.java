package com.example.task.Utility.api_utility;


import com.example.task.Utility.api_utility.ServicesApi.IgToH;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class ApiProvider {

    private static ApiProvider allApi;

    private ApiProvider() {

    }

    public static ApiProvider getInstance() {


        if (allApi == null)
            allApi = new ApiProvider();


        return allApi;

    }



  public Call<ResponseBody> convertGtoH(){

       return ApiConfig.getInstance().getRetrofit(false).create(IgToH.class).convertGtoH();
    }



}