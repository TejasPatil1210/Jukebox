package org.example.Model;

import java.sql.Time;

public class Episode {
    private String episode_id;
    private String episode_name;
    private Time episode_Duration;
    private int episode;
    private String episode_filepath;

    public Episode(String episode_id, String episode_name, Time episode_Duration, int episode, String episode_filepath) {
        this.episode_id = episode_id;
        this.episode_name = episode_name;
        this.episode_Duration = episode_Duration;
        this.episode = episode;
        this.episode_filepath = episode_filepath;
    }

    public String getEpisode_id() {
        return episode_id;
    }

    public void setEpisode_id(String episode_id) {
        this.episode_id = episode_id;
    }

    public String getEpisode_name() {
        return episode_name;
    }

    public void setEpisode_name(String episode_name) {
        this.episode_name = episode_name;
    }

    public Time getEpisode_Duration() {
        return episode_Duration;
    }

    public void setEpisode_Duration(Time episode_Duration) {
        this.episode_Duration = episode_Duration;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public String getEpisode_filepath() {
        return episode_filepath;
    }

    public void setEpisode_filepath(String episode_filepath) {
        this.episode_filepath = episode_filepath;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "episode_id='" + episode_id + '\'' +
                ", episode_name='" + episode_name + '\'' +
                ", episode_Duration=" + episode_Duration +
                ", episode=" + episode +
                ", episode_filepath='" + episode_filepath + '\'' +
                '}';
    }
}
