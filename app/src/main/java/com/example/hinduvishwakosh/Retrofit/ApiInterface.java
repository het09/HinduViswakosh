package com.example.hinduvishwakosh.Retrofit;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.hinduvishwakosh.Model.Prayers;
import com.example.hinduvishwakosh.Model.UserModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface{

    @POST("/login")
    Call<UserModel> loginUser(@Body JsonObject body);

    /*@Headers({
            "Accept: application/json",
            "Content-type : application/json"
    })*/

    @POST("/create")
    Call<UserModel> registerUser(@Body JsonObject body);

    @GET("/music")
    Call<List<Prayers>> getPrayers(@Body JsonArray array);

}
