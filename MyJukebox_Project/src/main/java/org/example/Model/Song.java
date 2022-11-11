package org.example.Model;

import java.sql.Time;

public class Song {
    private String song_id;
    private String song_name;
    private Time song_Duration;
    private String song_genre;
    private String song_artist_name;
    private String song_album_name;
    private String song_filepath;

    public Song(String song_id, String song_name, Time song_Duration, String song_genre, String song_artist_name, String song_album_name, String song_filepath)
    {
        this.song_id = song_id;
        this.song_name = song_name;
        this.song_Duration = song_Duration;
        this.song_genre = song_genre;
        this.song_artist_name = song_artist_name;
        this.song_album_name = song_album_name;
        this.song_filepath = song_filepath;
    }

    public String getSong_id() {
        return song_id;
    }

    public void setSong_id(String song_id) {
        this.song_id = song_id;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public Time getSong_Duration() {
        return song_Duration;
    }

    public void setSong_Duration(Time song_Duration) {
        this.song_Duration = song_Duration;
    }

    public String getSong_genre() {
        return song_genre;
    }

    public void setSong_genre(String song_genre) {
        this.song_genre = song_genre;
    }

    public String getSong_artist_name() {
        return song_artist_name;
    }

    public void setSong_artist_name(String song_artist_name) {
        this.song_artist_name = song_artist_name;
    }

    public String getSong_album_name() {
        return song_album_name;
    }

    public void setSong_album_name(String song_album_name) {
        this.song_album_name = song_album_name;
    }

    public String getSong_filepath() {
        return song_filepath;
    }

    public void setSong_filepath(String song_filepath) {
        this.song_filepath = song_filepath;
    }

    @Override
    public String toString() {
        return "Song{" +
                "song_id='" + song_id + '\'' +
                ", song_name='" + song_name + '\'' +
                ", song_Duration=" + song_Duration +
                ", song_genre='" + song_genre + '\'' +
                ", song_artist_name='" + song_artist_name + '\'' +
                ", song_album_name='" + song_album_name + '\'' +
                ", song_filepath='" + song_filepath + '\'' +
                '}';
    }
}
