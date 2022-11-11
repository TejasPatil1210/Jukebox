package org.example.Model;

public class Playlist {
    private int playlist_id;
    private String playlist_name;
    private User user;

    public Playlist(int playlist_id,String playlist_name, User user) {
       this.playlist_id = playlist_id;
        this.playlist_name = playlist_name;
        this.user = user;
    }

    public int getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(int playlist_id) {
        this.playlist_id = playlist_id;
    }

    public String getPlaylist_name() {
        return playlist_name;
    }

    public void setPlaylist_name(String playlist_name) {
        this.playlist_name = playlist_name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                ", playlist_Id='" + playlist_id + '\'' +
                ", playlist_name='" + playlist_name + '\'' +
                ", user=" + user +
                '}';
    }
}
