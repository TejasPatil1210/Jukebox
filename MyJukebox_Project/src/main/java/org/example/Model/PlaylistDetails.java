package org.example.Model;

public class PlaylistDetails {
    private int playlistDetails_id;
    private Playlist playlist;
    private String content_id;
    private String contentName;
  private String contentPath;

    public PlaylistDetails(int playlistDetails_id, Playlist playlist, String content_id,String contentName,String contentPath) {
        this.playlistDetails_id = playlistDetails_id;
        this.playlist = playlist;
        this.content_id=content_id;
        this.contentName=contentName;
        this.contentPath=contentPath;
    }

    public int getPlaylistDetails_id() {
        return playlistDetails_id;
    }

    public void setPlaylistDetails_id(int playlistDetails_id) {
        this.playlistDetails_id = playlistDetails_id;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public String getContent_id() {
        return content_id;
    }

    public void setContent_id(String song) {
        this.content_id = content_id;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public String getContentPath() {
        return contentPath;
    }

    public void setContentPath(String contentPath) {
        this.contentPath = contentPath;
    }

    @Override
    public String toString() {
        return "PlaylistDetails{" +
                "playlistDetails_id='" + playlistDetails_id + '\'' +
                ", playlist=" + playlist.getPlaylist_name() +
                ", content_id=" + content_id +
                ", content_Name=" + contentName +
                ", content_Path=" + contentPath +
                '}';
    }
}
