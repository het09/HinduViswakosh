package com.example.hinduvishwakosh.Model;

import com.google.gson.annotations.SerializedName;

public class Prayers {

    @SerializedName("artist")
    private String artist;

    @SerializedName("location")
    private String location;

    @SerializedName("music_id")
    private String music_id;

    @SerializedName("music_name")
    private String musicName;

    public Prayers(String artist, String location, String music_id, String musicName) {
        this.artist = artist;
        this.location = location;
        this.music_id = music_id;
        this.musicName = musicName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMusic_id() {
        return music_id;
    }

    public void setMusic_id(String music_id) {
        this.music_id = music_id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }
}
