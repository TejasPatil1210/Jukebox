package org.example.DAOInterfaces;


import org.example.Model.Playlist;
import org.example.Model.PlaylistDetails;
import org.example.Model.User;

import java.util.List;

public interface PlaylistInterface {
    List<PlaylistDetails> createPlaylist(User userObj);
    void deletePlaylist(User userObj);
     List<Playlist> myPlaylists(User userObj);
    String getPlaylistName(User userobj,int plId);
    int getPlaylistId(User userobj,String plName);
}
