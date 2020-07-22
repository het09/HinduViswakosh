package com.example.hinduvishwakosh;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hinduvishwakosh.Model.UserModel;
import com.example.hinduvishwakosh.Retrofit.ApiClient;
import com.example.hinduvishwakosh.Retrofit.ApiInterface;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button login;
    private TextView forgetpass;
    private TextView signUpUser;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        forgetpass = findViewById(R.id.forget_pass);
        signUpUser = findViewById(R.id.signup_user);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        signUpUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginUser();
            }
        });
    }

    public void loginUser(){

        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Please Wait!!!!");
        dialog.show();

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("email", email.getText().toString());
        jsonObject.addProperty("password", password.getText().toString());


        Call<UserModel> userModelCall = apiInterface.loginUser(jsonObject);

        userModelCall.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {

                    if (!response.isSuccessful()) {
                        Toast.makeText(LoginActivity.this, "Error: " + response.body(), Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                        return;
                    }

                        UserModel userModelLogin = response.body();
                        //if(userModelLogin.isSuccess()) {

                            Toast.makeText(LoginActivity.this, "Logged in Successfully!!!" + response.body().getToken(), Toast.LENGTH_SHORT).show();
                            dialog.dismiss();

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        //}
                        /*else
                        {
                            Toast.makeText(LoginActivity.this, "Username or password Incorrect(:" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }*/



            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Error, Couldn't find User...!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

    }
}
