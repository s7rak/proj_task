package com.example.task.view_model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.task.Utility.api_utility.ApiProvider;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.jetbrains.annotations.NotNull;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> hajjiLiveData = new MutableLiveData<>();

    public MutableLiveData<String> getHajjiLiveData() {
        return hajjiLiveData;
    }

    public void getHajjiDate(String date , int number){

        ApiProvider.getInstance().convertGtoH(date , number).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NotNull Call<ResponseBody> call, @NotNull Response<ResponseBody> response) {

                // check is stressful
                if (response.code() == 200 && response.body() != null) {

                    try {

                        final JsonObject object = new Gson().fromJson(response.body().string(), JsonObject.class); // get all json

                        final JsonObject filedData = object.get("data").getAsJsonObject();  // get data field from json

                        final JsonObject filedHijri = filedData.get("hijri").getAsJsonObject(); // get hijri from data

                        hajjiLiveData.setValue(filedHijri.get("date").getAsString());  // get date from hijri and set to hajjiLiveData

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }


            }

            @Override
            public void onFailure(@NotNull Call<ResponseBody> call, @NotNull Throwable t) {

            }
        });
    }


}
