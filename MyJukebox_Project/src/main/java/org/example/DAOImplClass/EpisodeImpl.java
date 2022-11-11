package org.example.DAOImplClass;

import org.example.DAOInterfaces.EpisodeInterface;
import org.example.DBConnection;
import org.example.Main;
import org.example.Model.Episode;
import org.example.Model.Song;
import org.example.Model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class EpisodeImpl implements EpisodeInterface {
    public List<Episode> displayAllEpisodes(String podcast_Id){
        List<Episode> epilist=new ArrayList<>();
        Episode epiObj=null;
        try{
            Connection con= DBConnection.getConnection();
            String selectQue="Select Episode_id,Episode_Name,Episode_Duration,Episode,Episode_filePath from Episode where Podcast_id='"+podcast_Id+"'";
            Statement st=con.createStatement();
            ResultSet res=st.executeQuery(selectQue);
            while (res.next())
            {
                String episodeId = res.getString(1);
                String episodeName = res.getString(2);
                Time episode_Duration = res.getTime(3);
                int episode = res.getInt(4);
                String episode_filePath=res.getString(5);
                epiObj=new Episode(episodeId,episodeName,episode_Duration,episode,episode_filePath);
                epilist.add(epiObj);
            }

        }catch (Exception e)
        {
            System.out.println(e);
        }
        return epilist;
    }
    public Episode searchEpisode(User userObj, String episode_ID,String podcastID){
        Episode episode=null;

        try
        {
            Connection con=DBConnection.getConnection();
            String query1 = "select Episode_id,Episode_Name,Episode_Duration,Episode,Episode_filePath from Episode where Episode_id='" + episode_ID + "' and Podcast_id='"+podcastID+"'";
            Statement st1 = con.createStatement();
            ResultSet res1 = st1.executeQuery(query1);
            while (res1.next()) {
                String episodeId = res1.getString(1);
                String episodeName = res1.getString(2);
                Time episode_Duration = res1.getTime(3);
                int episode1 = res1.getInt(4);
                String episode_filePath=res1.getString(5);
                episode=new Episode(episodeId,episodeName,episode_Duration,episode1,episode_filePath);

            }
        }catch (Exception e)
        {
            System.out.println(e);
        }
        if (episode==null){System.out.println("Episode Not Found!!!Try Again");
            Main.displaymainmenu(userObj);}
        return episode;

    }
}
