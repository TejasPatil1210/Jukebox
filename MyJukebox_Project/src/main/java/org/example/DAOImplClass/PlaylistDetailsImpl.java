package org.example.DAOImplClass;

import org.example.DAOInterfaces.PlaylistDetailsInterface;
import org.example.DBConnection;
import org.example.Main;
import org.example.Model.*;
import org.example.PlayAudio;
import org.example.ReadAudio1;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class PlaylistDetailsImpl implements PlaylistDetailsInterface {
    Scanner scan = new Scanner(System.in);
    SongImpl songimplobj = new SongImpl();
    PodcastImpl podimplobj = new PodcastImpl();
    EpisodeImpl epl=new EpisodeImpl();
 //   PlaylistImpl playlist=new PlaylistImpl();
    public List<PlaylistDetails> add_content_in_playlist(Playlist plobj, User userObj, String playlistName) {
        List<PlaylistDetails> playlist = new ArrayList<>();
        try {
            Connection con1 = DBConnection.getConnection();
            String selectquer = "select Playlist_name from Playlist where playlist_name='" + playlistName + "' and User_id='" + userObj.getUser_id() + "'";
            Statement sta2 = con1.createStatement();
            ResultSet res2 = sta2.executeQuery(selectquer);
            String playlistname="";
            while (res2.next()) {
                 playlistname = res2.getString(1);
            }
            if (!playlistname.equalsIgnoreCase("")) {
                while (true) {
                    System.out.println("What you want to add in the Playlist");
                    System.out.println("\n 1.Songs \n 2.Podcasts\n 3.Exit \n Enter your choice");
                    int choice = scan.nextInt();
                    try {
                        Connection con = DBConnection.getConnection();
                        switch (choice) {
                            case 1:
                                List<Song> allsongsList = new ArrayList<>();
                                allsongsList = songimplobj.displayallSongs();
                                System.out.printf("%3s %15s %15s %10s %20s %18s \n","Song Id","Song Name","Duration","Genre","Artist Name","Album Name");
                                /*allsongsList.forEach(x -> System.out.println(x.getSong_id() + "\t " + x.getSong_name() + "\t" + x.getSong_Duration()
                                        + "\t " + x.getSong_genre() + "\t " + x.getSong_artist_name() + "\t " + x.getSong_album_name()));*/
                                allsongsList.forEach(x-> System.out.printf("%3s %19s %15s %12s %21s %16s \n",x.getSong_id(),x.getSong_name(),x.getSong_Duration(),
                                        x.getSong_genre(),x.getSong_artist_name(),x.getSong_album_name()));
                                System.out.println("Enter the Song ID that You want to add in the Playlist");
                                String songid = scan.next();

                                String squery="select content_id from playlistdetails where playlist_id="+plobj.getPlaylist_id()+" and content_id='"+songid+"'";
                                Statement statement=con.createStatement();
                                ResultSet resultSet=statement.executeQuery(squery);
                                String conId="";
                                while (resultSet.next())
                                {
                                    conId=resultSet.getString(1);
                                }
                                if(conId.equalsIgnoreCase("")||(!conId.equalsIgnoreCase(songid)))
                            {
                                Song song=songimplobj.search_for_Song(userObj,songid);
                                String contentName=song.getSong_name();
                                String contentPath=song.getSong_filepath();
                                String query5 = "set foreign_key_checks=0;";
                                Statement st5 = con.createStatement();
                                st5.executeUpdate(query5);
                                System.out.println();

                                String query = "insert into Playlistdetails(playlist_id,content_id,content_Name,content_filepath) values(?,?,?,?)";
                                PreparedStatement pst = con.prepareStatement(query);
                                pst.setInt(1, plobj.getPlaylist_id());
                                pst.setString(2, songid);
                                pst.setString(3,contentName);
                                pst.setString(4,contentPath);
                                pst.executeUpdate();

                                String query6 = "set foreign_key_checks=1;";
                                Statement st6 = con.createStatement();
                                st6.executeUpdate(query6);
                            }
                            else{
                                System.out.println("This content is already in your Playlist");break;}
                                break;
                            case 2:
                                List<Podcast> allPodcastsList = new ArrayList<>();
                                allPodcastsList = podimplobj.displayAllPodcasts();
                                System.out.printf("%3s %27s %28s %25s  \n","Podcast Id","Podcast Name","Podcast Artist Name","Podcast Released Date");
                                allPodcastsList.forEach(x-> System.out.printf("%3s %40s %19s %20s \n",x.getPodcast_id(),x.getPodcast_name()
                                        ,x.getPodcast_artist(),x.getReleased_date()));
                                /*allPodcastsList.forEach(x -> System.out.println(x.getPodcast_id() + " " + x.getPodcast_name() +
                                        " " + x.getPodcast_artist() + " " + x.getReleased_date()));*/
                                System.out.println("Enter the Podcast ID that You want to add in the Playlist");
                                String podcastid = scan.next();
                                List<Episode> ePlist=new ArrayList<>();
                                ePlist=epl.displayAllEpisodes(podcastid);
                                System.out.printf("%3s %40s %28s %14s  \n","Episode Id","Episode Name","Episode Duration","Episode");
                                ePlist.forEach(x-> System.out.printf("%3s %55s %15s %15s \n",x.getEpisode_id(),x.getEpisode_name(),x.getEpisode_Duration()
                                        ,x.getEpisode()));
                               /* ePlist.forEach(x-> System.out.println(x.getEpisode_id()+"\t "+x.getEpisode_name()+"\t"+x.getEpisode_Duration()
                                        +"\t "+x.getEpisode()));*/
                                System.out.println("In this Podcast which episode do you Want to add in the Playlist!!!Please enter Episode Id");
                                String epiID=scan.next();

                                String squery1="select content_id from playlistdetails where playlist_id="+plobj.getPlaylist_id()+" and content_id='"+epiID+"'";
                                Statement statement1=con.createStatement();
                                ResultSet resultSet1=statement1.executeQuery(squery1);
                                String conId1="";
                                while (resultSet1.next())
                                {
                                    conId1=resultSet1.getString(1);
                                }
                                if(conId1.equalsIgnoreCase("")||(!conId1.equalsIgnoreCase(epiID)))
                                {
                                Episode episode=epl.searchEpisode(userObj,epiID,podcastid);
                                String content=episode.getEpisode_name();
                                String contentPath1=episode.getEpisode_filepath();
                                String quer = "set foreign_key_checks=0;";
                                Statement sta = con.createStatement();
                                sta.executeUpdate(quer);
                                System.out.println();

                                String query1 = "insert into Playlistdetails(playlist_Id,content_id,content_name,content_filepath) values(?,?,?,?)";
                                PreparedStatement pst1 = con.prepareStatement(query1);
                                pst1.setInt(1, plobj.getPlaylist_id());
                                pst1.setString(2, epiID);
                                pst1.setString(3,content);
                                pst1.setString(4,contentPath1);
                                pst1.executeUpdate();

                                String quer1 = "set foreign_key_checks=1;";
                                Statement sta1 = con.createStatement();
                                sta1.executeUpdate(quer1);}
                            else{
                                System.out.println("This content is already in your Playlist");break;}
                                break;
                            case 3:String selectquery = "select * from Playlistdetails where playlist_Id=" + plobj.getPlaylist_id();
                                Statement st = con.createStatement();
                                ResultSet res = st.executeQuery(selectquery);
                                while (res.next()) {
                                    int playlistDet_id = res.getInt(1);
                                    int playlistID = res.getInt(2);
                                    String contentid = res.getString(3);
                                    String contentname=res.getString(4);
                                    String contentpath=res.getString(5);
                                    PlaylistDetails pldObj = new PlaylistDetails(playlistDet_id, plobj, contentid,contentname,contentpath);
                                    playlist.add(pldObj);
                                }
                                return playlist;
                            default:
                                System.out.println("invalid Choice");
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }else {System.out.println("There is No Playlist with this name!!! Try again!!!");
            Main.displaymainmenu(userObj);}
        } catch (Exception e) {
            System.out.println(e);
        }
        return playlist;
    }



    public List<PlaylistDetails> remove_content_from_playlist(Playlist plObj, User userObj, String playlistName) {
        List<PlaylistDetails> playlist = new ArrayList<PlaylistDetails>();

        try {
            Connection con = DBConnection.getConnection();
            String selectquer = "select Playlist_id,playlist_name from Playlist where playlist_name='" + playlistName + "' and User_id='" + userObj.getUser_id() + "'";
            Statement sta2 = con.createStatement();
            ResultSet res2 = sta2.executeQuery(selectquer);
            String playlistname="";
            int playId=0;
            while (res2.next()) {
                playId=res2.getInt(1);
                playlistname = res2.getString(2);
            }
            if (playlistname.equalsIgnoreCase(playlistName)) {
                System.out.println("Enter the Content ID that You want to remove from the Playlist");
                String contentid = scan.next();

                String selectQue="Select content_Id from PLaylistdetails where content_Id='"+contentid+"' and Playlist_id="+plObj.getPlaylist_id();
                Statement sta = con.createStatement();
                ResultSet result = sta.executeQuery(selectQue);
                String conId="";
                while (result.next())
                {
                    conId=result.getString(1);
                }
                if(conId.equalsIgnoreCase(contentid)) {
                    //Connection con = DBConnection.getConnection();
                    String query5 = "set foreign_key_checks=0;";
                    Statement st5 = con.createStatement();
                    st5.executeUpdate(query5);

                    String query1 = "delete from Playlistdetails where content_id='" + contentid + "' and Playlist_id=" + playId;
                    Statement st = con.createStatement();
                    st.executeUpdate(query1);
                    String selectquery1 = "select * from Playlistdetails where playlist_id=" + playId;
                    Statement st1 = con.createStatement();
                    ResultSet res1 = st1.executeQuery(selectquery1);
                    while (res1.next()) {
                        int playlistDEt_id = res1.getInt(1);
                        int playlist_id = res1.getInt(2);
                        String content = res1.getString(3);
                        String contentName = res1.getString(4);
                        String contentpath = res1.getString(5);
                        PlaylistDetails pldObj = new PlaylistDetails(playlistDEt_id, plObj, content, contentName, contentpath);
                        playlist.add(pldObj);
                    }
                    String quer1 = "set foreign_key_checks=1;";
                    Statement sta1 = con.createStatement();
                    sta1.executeUpdate(quer1);
                }else {
                    System.out.println("This Content Not Found in Your Playlist!!!");
                    Main.displaymainmenu(userObj);
                }
            }else{System.out.println("Playlist Not Found!!! Try again!!!");
                Main.displaymainmenu(userObj);}
        } catch (Exception e) {
            System.out.println(e);
        }

        return playlist;
    }
    public List<PlaylistDetails> viewPlaylist(int playlistid,User userObj){
        List<PlaylistDetails> playlist=new ArrayList<>();
        System.out.println("Playlist ID="+playlistid);
        try{
            Connection con=DBConnection.getConnection();
            String selectQue1="select Playlist_Id from Playlist where Playlist_Id="+playlistid+" and USer_id='"+userObj.getUser_id()+"'";
            Statement statement=con.createStatement();
            ResultSet res1=statement.executeQuery(selectQue1);
            //System.out.println("check1");
            int playID=0;
            while(res1.next())
            {
                playID=res1.getInt(1);
            }
            if(playID==playlistid) {
                String selectQue = "select * from PlaylistDetails where Playlist_Id=" + playlistid;
                Statement st = con.createStatement();
                ResultSet res = st.executeQuery(selectQue);
                //System.out.println("check1");
                while (res.next()) {
                    int playlistDelId = res.getInt(1);
                    int playId = res.getInt(2);
                    String content = res.getString(3);
                    String contentName = res.getString(4);
                    String contentPath = res.getString(5);
                    String plName = new PlaylistImpl().getPlaylistName(userObj, playId);
                    Playlist plObj = new Playlist(playId, plName, userObj);
                    PlaylistDetails pLDObj = new PlaylistDetails(playlistDelId, plObj, content, contentName, contentPath);
                    playlist.add(pLDObj);
                }
            }else {System.out.println("Playlist Not Found");Main.displaymainmenu(userObj);}
        }catch(Exception e)
        {
            System.out.println(e);
        }
        //System.out.println("check2");
        return playlist;
    }
        public String playContentFromPlaylist (User userObj){
            List<Playlist> myPLlist=new ArrayList<>();
            String filepath = "";
            myPLlist=new PlaylistImpl().myPlaylists(userObj);
            System.out.println("--------------------------------------");
            System.out.println("            Your Playlists           ");
            System.out.println("--------------------------------------");
            System.out.printf("%10s %20s \n","Playlist ID","Playlist Name");
            myPLlist.forEach(x-> System.out.printf("%9s %20s \n",x.getPlaylist_id(),x.getPlaylist_name()));
            System.out.println("--------------------------------------");
            System.out.println("Enter Playlist Id that you want to Listen");
            int plID=scan.nextInt();

            String plname=new PlaylistImpl().getPlaylistName(userObj,plID);
            if(plname.equalsIgnoreCase("")){
                System.out.println("Playlist Not Found");
                Main.displaymainmenu(userObj);
            }
            else {
                List<PlaylistDetails> viewplaylist = new ArrayList<>();
                viewplaylist = viewPlaylist(plID, userObj);
                /* playlistdetails*/


                if (viewplaylist.size() == 0) {
                    System.out.println("Playlist is empty!!!");
                    Main.displaymainmenu(userObj);
                }
                System.out.printf("%10s %40s \n", "Content ID", "Content Name");
                viewplaylist.forEach(x -> System.out.printf("%9s %40s \n", x.getContent_id(), x.getContentName()));
                //int plId=
                System.out.println("Enter Content_Id that you want to Play ");
                String contentId = scan.next();
                scan.nextLine();

                try {
                    Connection con = DBConnection.getConnection();
                    String que = "select content_filePath from playlistdetails where content_id='" + contentId + "' and playlist_id=" + plID;
                    Statement st = con.createStatement();
                    ResultSet res = st.executeQuery(que);

                    while (res.next()) {
                        filepath = res.getString(1);
                    }
                    if (filepath.equalsIgnoreCase("")) {
                        System.out.println("There is No such content with this ID In the Playlist");
                        Main.displaymainmenu(userObj);
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            return filepath;

            }

            public void playwholePLlist(User userObj) {
                List<Playlist> myPLlist = new ArrayList<>();
                String filepath = "";
                myPLlist = new PlaylistImpl().myPlaylists(userObj);
                System.out.println("--------------------------------------");
                System.out.println("            Your Playlists           ");
                System.out.println("--------------------------------------");
                System.out.printf("%10s %20s \n", "Playlist ID", "Playlist Name");
                myPLlist.forEach(x -> System.out.printf("%9s %20s \n", x.getPlaylist_id(), x.getPlaylist_name()));
                System.out.println("--------------------------------------");

                System.out.println("Enter Playlist Id that you want to Listen");
                int plID = scan.nextInt();

                String plname = new PlaylistImpl().getPlaylistName(userObj, plID);
                if (plname.equalsIgnoreCase("")) {
                    System.out.println("Playlist Not Found");
                    Main.displaymainmenu(userObj);
                } else {
                    List<PlaylistDetails> viewplaylist = new ArrayList<>();
                    viewplaylist = viewPlaylist(plID, userObj);
                    /* playlistdetails*/


                    if (viewplaylist.size() == 0) {
                        System.out.println("Playlist is empty!!!");
                        Main.displaymainmenu(userObj);
                    }
                    System.out.println("How many times You want to play this Playlist");
                    int count=scan.nextInt();
                    new ReadAudio1().readAudio1(viewplaylist,count,userObj);
                    /*System.out.printf("%10s %40s \n", "Content ID", "Content Name");
                    viewplaylist.forEach(x -> System.out.printf("%9s %40s \n", x.getContent_id(), x.getContentName()));
                    //int plId=
                    System.out.println("Enter Content_Id that you want to Play ");
                    String contentId = scan.next();
                    scan.nextLine();*/

                }
            }


    }


