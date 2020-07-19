package com.example.hinduvishwakosh.Model;

import android.widget.ImageView;
import android.widget.TextView;

public class MusicModel {

    String MusicName;
    String ArtistName;
    String god_goddessPhoto;

    public MusicModel(String musicName, String artistName, String god_goddessPhoto) {
        MusicName = musicName;
        ArtistName = artistName;
        this.god_goddessPhoto = god_goddessPhoto;
    }

    public String getMusicName() {
        return MusicName;
    }

    public String getArtistName() {
        return ArtistName;
    }

    public String getGod_goddessPhoto() {
        return god_goddessPhoto;
    }
}
