package com.example.hinduvishwakosh.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.hinduvishwakosh.Fragments.MusicFragment;
import com.example.hinduvishwakosh.Model.MusicModel;
import com.example.hinduvishwakosh.R;

import java.util.ArrayList;
import java.util.List;

public class MusicAdapter extends ArrayAdapter<MusicModel> {

    private Context context;
    private List<MusicModel> SongList;
    private MusicFragment musicFragment;


    public MusicAdapter(@NonNull Context context, int resource, @NonNull ArrayList<MusicModel> objects) {
        super(context, resource, objects);

        this.context = context;
        this.SongList = objects;
    }


    public View getView(int position, View convertView, ViewGroup parent){

        MusicModel musicModel = SongList.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row_song, null);

        TextView MusicName = (TextView) view.findViewById(R.id.music_name);
        TextView ArtistName = (TextView) view.findViewById(R.id.artist_name);
        ImageView god_goddessPhoto = (ImageView) view.findViewById(R.id.g_photo);

        return view;
    }
}
