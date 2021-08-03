package com.example.task.Utility.api_utility.ServicesApi;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IgToH {


    @GET("/v1/gToH")
    Call<ResponseBody> convertGtoH(@Query("date") String date  , @Query("adjustment") int number);

}
