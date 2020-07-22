package com.example.hinduvishwakosh.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hinduvishwakosh.Adapter.MusicAdapter;
import com.example.hinduvishwakosh.MediaPlayerActivity;
import com.example.hinduvishwakosh.Model.MusicModel;
import com.example.hinduvishwakosh.R;
import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.Objects;


public class MusicFragment extends Fragment {

    ListView SongList;
    ArrayList<MusicModel> arrayList;
    ArrayAdapter<String> arrayAdapter;
    TextView ArtistName , MusicName;
    ImageView God_GoddessPhoto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_music, container, false);

        ArtistName = view.findViewById(R.id.artist);
        MusicName = view.findViewById(R.id.music_name);


        arrayList = new ArrayList<MusicModel>();

        arrayList.add(new MusicModel("Hanuman Chalisa","Artist","ic_launcher"));
        arrayList.add(new MusicModel("Hanuman Chalisa","Artist","ic_launcher"));
        arrayList.add(new MusicModel("Hanuman Chalisa","Artist","ic_launcher"));
        arrayList.add(new MusicModel("Hanuman Chalisa","Artist","ic_launcher"));
        arrayList.add(new MusicModel("Hanuman Chalisa","Artist","ic_launcher"));
        arrayList.add(new MusicModel("Hanuman Chalisa","Artist","ic_launcher"));
        arrayList.add(new MusicModel("Hanuman Chalisa","Artist","ic_launcher"));

        ArrayAdapter<MusicModel> arrayAdapter = new MusicAdapter(Objects.requireNonNull(getActivity()), 0, arrayList);

        SongList = (ListView) view.findViewById(R.id.song_list);
        SongList.setAdapter(arrayAdapter);

        AdapterView.OnItemClickListener adapterViewListener =new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MusicModel musicModel = arrayList.get(position);
                Intent intent = new Intent(MusicFragment.this.getActivity(), MediaPlayerActivity.class);
                startActivity(intent);

            }
        };

        SongList.setOnItemClickListener(adapterViewListener);

        return view;
    }

    public void getPrayers(){

        JsonArray jsonArray = new JsonArray();

    }

}
