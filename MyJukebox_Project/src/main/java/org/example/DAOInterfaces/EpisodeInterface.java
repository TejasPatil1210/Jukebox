package org.example.DAOInterfaces;

import org.example.Model.Episode;
import org.example.Model.Podcast;
import org.example.Model.User;

import java.util.List;

public interface EpisodeInterface {

List<Episode> displayAllEpisodes(String podcast_Id);
Episode searchEpisode(User userObj, String episode_ID,String podcast_Id);


}
