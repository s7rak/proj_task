package com.example.task.Utility.api_utility;


import com.example.task.Utility.api_utility.ServicesApi.IgToH;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Query;

public class ApiProvider {

    private static ApiProvider allApi;

    private ApiProvider() {

    }

    public static ApiProvider getInstance() {


        if (allApi == null)
            allApi = new ApiProvider();


        return allApi;

    }



  public Call<ResponseBody> convertGtoH(String date  , int number){

       return ApiConfig.getInstance().getRetrofit(false).create(IgToH.class).convertGtoH(date , number);
    }



}