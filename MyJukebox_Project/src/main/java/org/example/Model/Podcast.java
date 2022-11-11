package org.example.Model;

import java.util.Date;

public class Podcast {
    private String podcast_id;
    private String podcast_name;
    private String podcast_artist;
    private Date released_date;
    Episode episode;

    public Podcast(String podcast_id, String podcast_name, String podcast_artist, Date released_date, Episode episode) {
        this.podcast_id = podcast_id;
        this.podcast_name = podcast_name;
        this.podcast_artist = podcast_artist;
        this.released_date = released_date;
        this.episode = episode;
    }

    public String getPodcast_id() {
        return podcast_id;
    }

    public void setPodcast_id(String podcast_id) {
        this.podcast_id = podcast_id;
    }

    public String getPodcast_name() {
        return podcast_name;
    }

    public void setPodcast_name(String podcast_name) {
        this.podcast_name = podcast_name;
    }

    public String getPodcast_artist() {
        return podcast_artist;
    }

    public void setPodcast_artist(String podcast_artist) {
        this.podcast_artist = podcast_artist;
    }

    public Date getReleased_date() {
        return released_date;
    }

    public void setReleased_date(Date released_date) {
        this.released_date = released_date;
    }

    public Episode getEpisode() {
        return episode;
    }

    public void setEpisode(Episode episode) {
        this.episode = episode;
    }

    @Override
    public String toString() {
        return "Podcast{" +
                "podcast_id='" + podcast_id + '\'' +
                ", podcast_name='" + podcast_name + '\'' +
                ", podcast_artist='" + podcast_artist + '\'' +
                ", released_date=" + released_date +
                ", episode=" + episode +
                '}';
    }
}
