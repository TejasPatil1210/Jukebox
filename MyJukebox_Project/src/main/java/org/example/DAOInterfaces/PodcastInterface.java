package org.example.DAOInterfaces;

import java.util.*;
import org.example.Model.Podcast;
import org.example.Model.User;

public interface PodcastInterface {
    List<Podcast> displayAllPodcasts();
    List<Podcast> sort_all_Podcast();
    Podcast search_for_Podcast(User userObj, String podcast_id,int choice);
    String playPodcast(User userobj);
}
