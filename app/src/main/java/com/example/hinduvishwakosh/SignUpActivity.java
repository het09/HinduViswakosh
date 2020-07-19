package com.example.hinduvishwakosh;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hinduvishwakosh.Model.UserModel;
import com.example.hinduvishwakosh.Retrofit.ApiClient;
import com.example.hinduvishwakosh.Retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.hinduvishwakosh.Retrofit.ApiClient.BASE_URL;
import static com.example.hinduvishwakosh.Retrofit.ApiClient.retrofit;

public class SignUpActivity extends AppCompatActivity {

    private EditText username, email, password, dob;
    private TextView loginUser;
    private Button signUp;
    private RadioGroup gender;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        dob = findViewById(R.id.dob);
        loginUser = findViewById(R.id.login_user);
        signUp = findViewById(R.id.signUp);
        gender = findViewById(R.id.gender);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        loginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
            }
        });

    }


    public void registerUser(View view){

        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Please Wait!!!!");
        dialog.show();

        Call<UserModel> userModelCall = apiInterface.registerUser(dob.getText().toString(),
                email.getText().toString(),
                ((RadioButton)findViewById(gender.getCheckedRadioButtonId())).getText().toString(),
                password.getText().toString(),
                username.getText().toString());

        userModelCall.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {

                if(!response.isSuccessful()){
                    Toast.makeText(SignUpActivity.this, "Error: "+ response.body(), Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    return;
                }

                UserModel userModelResponse = response.body();
                Toast.makeText(SignUpActivity.this, "User Registered Successfully!! ", Toast.LENGTH_SHORT).show();
                dialog.dismiss();


                Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                startActivity(intent);
            }


            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Toast.makeText(SignUpActivity.this, "Error, Couldn't register User (:" + t.getMessage(), Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }
}
