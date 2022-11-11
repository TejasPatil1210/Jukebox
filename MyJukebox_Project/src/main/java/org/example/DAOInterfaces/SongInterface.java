package org.example.DAOInterfaces;

import org.example.Model.Song;
import org.example.Model.User;

import java.util.*;

public interface SongInterface {
    List<Song> displayallSongs();
    List<Song> sort_all_Songs();

    List<Song> search_Song_categorywise(User userObj,String song_id,int choice);
    Song search_for_Song(User userObj,String song_id);

    String playSong(User userObj);
}
