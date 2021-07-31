package com.example.task.Utility.api_utility.ServicesApi;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IgToH {


    @GET("/v1/gToH")
    Call<ResponseBody> convertGtoH();

}
