package com.example.hinduvishwakosh.Fragments;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.FileObserver;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.hinduvishwakosh.R;
import com.example.hinduvishwakosh.ScanResultActivity;

import static android.app.Activity.RESULT_OK;


public class PhotoFragment extends Fragment {

    private static final int PICK_IMAGE = 1;
    Button ScanSearch, TakePhoto, UploadPhoto;
    ImageView Folder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_photo, container, false);

        ScanSearch = view.findViewById(R.id.ScanSearch);
        TakePhoto = view.findViewById(R.id.takePhoto);
        UploadPhoto = view.findViewById(R.id.uploadPhoto);
        Folder = view.findViewById(R.id.folder);

        ScanSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhotoFragment.this.getActivity(), ScanResultActivity.class);
                startActivity(intent);

            }
        });

        UploadPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selectPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(selectPhoto, PICK_IMAGE);

            }

        });

        return view;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            Uri imageUri = data.getData();
            Folder.setImageURI(imageUri);
        }
    }
}
