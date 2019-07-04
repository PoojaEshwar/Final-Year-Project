package com.example.finalyearproject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Retrofit_API {

    String base_url =  "http://10.0.2.2:5000/appname/";

    @POST("activity")
    Call<ResponseBody> predict_activity();

}
