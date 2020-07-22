package com.example.hinduvishwakosh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class ScanResultActivity extends AppCompatActivity {

    ImageView ResultPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_result);
        ResultPhoto = findViewById(R.id.result_photo);

    }

}
