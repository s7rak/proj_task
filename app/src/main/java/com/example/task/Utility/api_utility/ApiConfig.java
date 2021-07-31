package com.example.task.Utility.api_utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {


    final   String baseUrl = "http://api.aladhan.com";

    static ApiConfig apiConfig ;


    private ApiConfig(){};


    public  static ApiConfig getInstance(){


        if(apiConfig == null)
            apiConfig = new ApiConfig();

        else
            return  apiConfig;

        return   apiConfig;
    }


    Retrofit getRetrofit(boolean useGson) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        return new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(useGson ? GsonConverterFactory.create(gson) : GsonConverterFactory.create())
                .build();

    }


}