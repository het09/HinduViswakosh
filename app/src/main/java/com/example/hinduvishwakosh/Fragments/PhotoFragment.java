package com.example.hinduvishwakosh.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hinduvishwakosh.R;
import com.example.hinduvishwakosh.ScanResultActivity;


public class PhotoFragment extends Fragment {

    Button ScanSearch , TakePhoto, UploadPhoto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_photo, container, false);

        ScanSearch = view.findViewById(R.id.ScanSearch);
        TakePhoto = view.findViewById(R.id.takePhoto);
        UploadPhoto = view.findViewById(R.id.uploadPhoto);

        ScanSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PhotoFragment.this.getActivity(), ScanResultActivity.class));
            }
        });



        return view;
    }
}
