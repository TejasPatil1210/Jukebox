package org.example.DAOImplClass;

import org.example.DAOInterfaces.PodcastInterface;
import org.example.DBConnection;
import org.example.Main;
import org.example.Model.Episode;
import org.example.Model.Podcast;
import org.example.Model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class PodcastImpl implements PodcastInterface {
Scanner scan=new Scanner(System.in);
EpisodeImpl epl=new EpisodeImpl();
      public List<Podcast> displayAllPodcasts(){
          List<Podcast> allPodcasts=new ArrayList<>();
          try {
              Episode epiObj=null;
              Connection con = DBConnection.getConnection();
              String query = "Select * from Podcast";
              Statement st = con.createStatement();
              ResultSet res = st.executeQuery(query);
              while (res.next()) {
                  String podcastId = res.getString(1);
                  String podcastName = res.getString(2);
                  Date podcast_released_date = res.getDate(3);
                  String podcast_Artist_Name = res.getString(4);
                  String query1 = "Select Episode_id,Episode_Name,Episode_Duration,Episode,Episode_filePath from Episode where Podcast_Id='"+podcastId+"'";
                  Statement st1= con.createStatement();
                  ResultSet res1 = st1.executeQuery(query1);
                  while (res1.next()) {
                      String episodeId = res1.getString(1);
                      String episodeName = res1.getString(2);
                      Time episode_Duration = res1.getTime(3);
                      int episode = res1.getInt(4);
                      String episode_filePath=res1.getString(5);
                      epiObj=new Episode(episodeId,episodeName,episode_Duration,episode,episode_filePath);
                  }
                  Podcast podcastObj = new Podcast(podcastId, podcastName, podcast_Artist_Name, podcast_released_date,epiObj);
                  allPodcasts.add(podcastObj);
              }
          } catch (Exception e) {
              System.out.println(e);
          }
          return allPodcasts;
      }
    public List<Podcast> sort_all_Podcast()
    {
        List<Podcast> allPodcasts=new ArrayList<>();
        List<Podcast> sortedPodcasts=new ArrayList<>();
        try {
            System.out.println("\n 1.Sort Podcast by Artist \n 2.Sort Podcast by Released_Date  \n Enter your choice");
            int choice = scan.nextInt();
                Episode epiObj = null;
                Connection con = DBConnection.getConnection();
                Statement st;
                ResultSet res;
                String query;
            query = "select * from Podcast";
            st = con.createStatement();
            res = st.executeQuery(query);
            while (res.next()) {
                String podcastId = res.getString(1);
                String podcastName = res.getString(2);
                Date podcast_released_date = res.getDate(3);
                String podcast_Artist_Name = res.getString(4);
                String query1 = "Select Episode_id,Episode_Name,Episode_Duration,Episode,Episode_filePath from Episode where Podcast_Id='" + podcastId + "'";
                Statement st1 = con.createStatement();
                ResultSet res1 = st1.executeQuery(query1);
                while (res1.next()) {
                    String episodeId = res1.getString(1);
                    String episodeName = res1.getString(2);
                    Time episode_Duration = res1.getTime(3);
                    int episode = res1.getInt(4);
                    String episode_filePath = res1.getString(5);
                    epiObj = new Episode(episodeId, episodeName, episode_Duration, episode, episode_filePath);
                }
                Podcast podcastObj = new Podcast(podcastId, podcastName, podcast_Artist_Name, podcast_released_date, epiObj);
                allPodcasts.add(podcastObj);
            }
                switch (choice) {
                    case 1:
                        sortedPodcasts=allPodcasts.stream().sorted((p1,p2)->p1.getPodcast_artist().compareTo(p2.getPodcast_artist())).collect(Collectors.toList());
                        return sortedPodcasts;

                    case 2:
                        sortedPodcasts=allPodcasts.stream().sorted((p1,p2)->p1.getReleased_date().compareTo(p2.getReleased_date())).collect(Collectors.toList());
                        return sortedPodcasts;
                    default:
                        System.out.println("Invalid Choice");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        return sortedPodcasts;
    }
    public Podcast search_for_Podcast(User userobj, String searchpodcast,int choice)
    {
        Podcast podcast=null;
        try
        {
            Connection con=DBConnection.getConnection();
            switch (choice)
            {
                case 1:
                    String query="select * from Podcast where Podcast_Artist_Name='"+searchpodcast +"'";
                    Statement st=con.createStatement();
                    ResultSet res=st.executeQuery(query);
                    while (res.next())
                    {
                        String podcastId = res.getString(1);
                        String podcastName = res.getString(2);
                        Date podcast_released_date = res.getDate(3);
                        String podcast_Artist_Name = res.getString(4);
                        String query1 = "Select Episode_id,Episode_Name,Episode_Duration,Episode,Episode_filePath from Episode where Podcast_Id='" + podcastId + "'";
                        Statement st1 = con.createStatement();
                        ResultSet res1 = st1.executeQuery(query1);
                        while (res1.next()) {
                            String episodeId = res1.getString(1);
                            String episodeName = res1.getString(2);
                            Time episode_Duration = res1.getTime(3);
                            int episode = res1.getInt(4);
                            String episode_filePath = res1.getString(5);
                            Episode epiObj = new Episode(episodeId, episodeName, episode_Duration, episode, episode_filePath);
                            podcast = new Podcast(podcastId, podcastName, podcast_Artist_Name, podcast_released_date,epiObj);
                        }
                    }
                    break;
                case 2:String query1="select * from Podcast where Podcast_Released_Date='"+searchpodcast +"'";
                    Statement st1=con.createStatement();
                    ResultSet res1=st1.executeQuery(query1);
                    while (res1.next())
                    {
                        String podcastId = res1.getString(1);
                        String podcastName = res1.getString(2);
                        Date podcast_released_date = res1.getDate(3);
                        String podcast_Artist_Name = res1.getString(4);
                        String query2 = "Select Episode_id,Episode_Name,Episode_Duration,Episode,Episode_filePath from Episode where Podcast_Id='" + podcastId + "'";
                        Statement st2 = con.createStatement();
                        ResultSet res2 = st2.executeQuery(query2);
                        while (res2.next()) {
                            String episodeId = res2.getString(1);
                            String episodeName = res2.getString(2);
                            Time episode_Duration = res2.getTime(3);
                            int episode = res2.getInt(4);
                            String episode_filePath = res2.getString(5);
                            Episode epiObj = new Episode(episodeId, episodeName, episode_Duration, episode, episode_filePath);
                            podcast = new Podcast(podcastId, podcastName, podcast_Artist_Name, podcast_released_date,epiObj);
                        }
                    }
                    break;
                case 3:String query3="select * from Podcast where Podcast_id='"+searchpodcast +"'";
                    Statement st3=con.createStatement();
                    ResultSet res3=st3.executeQuery(query3);
                    while (res3.next())
                    {
                        String podcastId = res3.getString(1);
                        String podcastName = res3.getString(2);
                        Date podcast_released_date = res3.getDate(3);
                        String podcast_Artist_Name = res3.getString(4);
                        String query4 = "Select Episode_id,Episode_Name,Episode_Duration,Episode,Episode_filePath from Episode where Podcast_Id='" + podcastId + "'";
                        Statement st4 = con.createStatement();
                        ResultSet res4 = st4.executeQuery(query4);
                        while (res4.next()) {
                            String episodeId = res4.getString(1);
                            String episodeName = res4.getString(2);
                            Time episode_Duration = res4.getTime(3);
                            int episode = res4.getInt(4);
                            String episode_filePath = res4.getString(5);
                            Episode epiObj = new Episode(episodeId, episodeName, episode_Duration, episode, episode_filePath);
                            podcast = new Podcast(podcastId, podcastName, podcast_Artist_Name, podcast_released_date,epiObj);
                        }
                    }
                    break;
            }
        }catch (Exception e)
        {
            System.out.println(e);
        }
        if (podcast==null) {System.out.println("Podcast Not Found!!!Try Again");Main.displaymainmenu(userobj);}
        return podcast;
    }

    public String playPodcast(User userobj)
    {
        List<Podcast> allPodcastsList=new ArrayList<>();
        allPodcastsList=displayAllPodcasts();
        System.out.printf("%3s %27s %28s %25s  \n","Podcast Id","Podcast Name","Podcast Artist Name","Podcast Released Date");
        allPodcastsList.forEach(x-> System.out.printf("%3s %40s %19s %20s \n",x.getPodcast_id(),x.getPodcast_name(),
                x.getPodcast_artist(),x.getReleased_date()));
        System.out.println("Please Enter Podcast Id that You Want to Listen");
        String podcastId=scan.next();
        List<Episode> ePlist=new ArrayList<>();
        ePlist=epl.displayAllEpisodes(podcastId);
        System.out.printf("%3s %40s %28s %14s  \n","Episode Id","Episode Name","Episode Duration","Episode");
        ePlist.forEach(x-> System.out.printf("%3s %55s %15s %15s \n",x.getEpisode_id(),x.getEpisode_name(),x.getEpisode_Duration()
                ,x.getEpisode()));
        System.out.println("In this Podcast which episode do you Want to Listen!!!Please enter Episode Id");
        String epiID=scan.next();

        Episode episode=epl.searchEpisode(userobj,epiID,podcastId);
        return episode.getEpisode_filepath();
    }
}
