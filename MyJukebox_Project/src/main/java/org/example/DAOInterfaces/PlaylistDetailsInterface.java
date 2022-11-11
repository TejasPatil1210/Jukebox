package org.example.DAOInterfaces;


import org.example.Model.Playlist;
import org.example.Model.PlaylistDetails;
import org.example.Model.User;

import java.util.List;

public interface PlaylistDetailsInterface {
    List<PlaylistDetails> add_content_in_playlist(Playlist plobj, User userObj, String content_id);
    List<PlaylistDetails> remove_content_from_playlist(Playlist plobj, User userObj,String content_id);

    List<PlaylistDetails> viewPlaylist(int playlistId, User userObj);
    String playContentFromPlaylist(User userObj);
}
