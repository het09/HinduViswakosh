package com.example.hinduvishwakosh.Retrofit;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.hinduvishwakosh.Model.UserModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface{

    @FormUrlEncoded
    @POST("login")
    Call<UserModel> loginUser(@Field("email") String email,
                              @Field("password") String password);

    @FormUrlEncoded
    @POST("create/")
    Call<UserModel> registerUser(@Field("dob") String dob,
                                 @Field("email") String email,
                                 @Field("gender") String gender,
                                 @Field("password") String password,
                                 @Field("user_name") String username);

}
