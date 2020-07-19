package com.example.hinduvishwakosh;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hinduvishwakosh.Model.UserModel;
import com.example.hinduvishwakosh.Retrofit.ApiClient;
import com.example.hinduvishwakosh.Retrofit.ApiInterface;

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
    }

    public void loginUser(View view){

        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Please Wait!!!!");
        dialog.show();

        Call<UserModel> userModelCall = apiInterface.loginUser(email.getText().toString(),
                                                                password.getText().toString());

        userModelCall.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                Toast.makeText(LoginActivity.this, "Logged in Successfully!!!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Error, Couldn't find User...!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

    }
}
