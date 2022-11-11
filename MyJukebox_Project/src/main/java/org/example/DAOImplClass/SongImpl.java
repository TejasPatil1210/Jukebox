package org.example.DAOImplClass;

import org.example.DAOInterfaces.SongInterface;
import org.example.DBConnection;
import org.example.Main;
import org.example.Model.Song;
import org.example.Model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SongImpl implements SongInterface {
    Scanner scan = new Scanner(System.in);

    public List<Song> displayallSongs() {
        List<Song> allSongs = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String query = "Select * from Song";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(query);
            while (res.next()) {
                String songId = res.getString(1);
                String songName = res.getString(2);
                Time songDuration = res.getTime(3);
                String songGenre = res.getString(4);
                String song_Artist_Name = res.getString(5);
                String song_Album_Name = res.getString(6);
                String song_filePath = res.getString(7);
                Song songObj = new Song(songId, songName, songDuration, songGenre, song_Artist_Name, song_Album_Name, song_filePath);
                allSongs.add(songObj);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return allSongs;
    }

    public List<Song> sort_all_Songs() {
        List<Song> allSongs = new ArrayList<>();
        List<Song> sortedSongs=new ArrayList<>();
        System.out.println("\n 1.Sort Songs by Album \n 2.Sort Songs by Genre \n 3.Sort Songs by Artist \n Enter your choice");
        int choice = scan.nextInt();
        try {
            Connection con=DBConnection.getConnection();
            Statement st;ResultSet res;String query;
            query="select * from Song ";
            st=con.createStatement();
            res=st.executeQuery(query);
            while (res.next())
            {
                String songId = res.getString(1);
                String songName = res.getString(2);
                Time songDuration = res.getTime(3);
                String songGenre = res.getString(4);
                String song_Artist_Name = res.getString(5);
                String song_Album_Name = res.getString(6);
                String song_filePath = res.getString(7);
                Song songObj = new Song(songId, songName, songDuration, songGenre, song_Artist_Name, song_Album_Name, song_filePath);
                allSongs.add(songObj);
            }
            switch (choice) {
                case 1:
                     sortedSongs=allSongs.stream().sorted((p1,p2)->p1.getSong_album_name().compareTo(p2.getSong_album_name())).collect(Collectors.toList());
                    return sortedSongs;
                case 2:
                    sortedSongs=allSongs.stream().sorted((p1,p2)->p1.getSong_genre().compareTo(p2.getSong_genre())).collect(Collectors.toList());
                    return sortedSongs;
                case 3:
                    sortedSongs=allSongs.stream().sorted((p1,p2)->p1.getSong_artist_name().compareTo(p2.getSong_artist_name())).collect(Collectors.toList());
                    return sortedSongs;
                default:
                    System.out.println("Invalid Choice");
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return sortedSongs;
    }


        public List<Song> search_Song_categorywise (User userObj,String searchsong,int choice){
        List<Song> allSongs=new ArrayList<>();
        Song song=null;
            try
            {
                Connection con=DBConnection.getConnection();
                switch(choice)
                {
                    case 1:
                        /*songscategorywise=allSongs.stream().filter(x->x.getSong_artist_name().equalsIgnoreCase(searchsong)).collect(Collectors.toList());
                        return songscategorywise;*/
                        String query1 = "select * from Song where Song_Artist_Name like '" + searchsong + "%'";
                        Statement st1 = con.createStatement();
                        ResultSet res1 = st1.executeQuery(query1);
                        while (res1.next()) {
                            String songId = res1.getString(1);
                            String songName = res1.getString(2);
                            Time songDuration = res1.getTime(3);
                            String songGenre = res1.getString(4);
                            String song_Artist_Name = res1.getString(5);
                            String song_Album_Name = res1.getString(6);
                            String song_filePath = res1.getString(7);
                            song = new Song(songId, songName, songDuration, songGenre, song_Artist_Name, song_Album_Name, song_filePath);
                            allSongs.add(song);
                        } break;
                    case 2:
                        String query2 = "select * from Song where Song_Genre like '" + searchsong + "%'";
                        Statement st2 = con.createStatement();
                        ResultSet res2 = st2.executeQuery(query2);
                        while (res2.next()) {
                            String songId = res2.getString(1);
                            String songName = res2.getString(2);
                            Time songDuration = res2.getTime(3);
                            String songGenre = res2.getString(4);
                            String song_Artist_Name = res2.getString(5);
                            String song_Album_Name = res2.getString(6);
                            String song_filePath = res2.getString(7);
                            song = new Song(songId, songName, songDuration, songGenre, song_Artist_Name, song_Album_Name, song_filePath);
                            allSongs.add(song);
                        }break;
                    case 3:
                        String query3 = "select * from Song where Song_Album_Name like '" + searchsong + "%'";
                        Statement st3 = con.createStatement();
                        ResultSet res3 = st3.executeQuery(query3);
                        while (res3.next()) {
                            String songId = res3.getString(1);
                            String songName = res3.getString(2);
                            Time songDuration = res3.getTime(3);
                            String songGenre = res3.getString(4);
                            String song_Artist_Name = res3.getString(5);
                            String song_Album_Name = res3.getString(6);
                            String song_filePath = res3.getString(7);
                            song = new Song(songId, songName, songDuration, songGenre, song_Artist_Name, song_Album_Name, song_filePath);
                            allSongs.add(song);
                        }break;
                }

            }catch (Exception e)
            {
                System.out.println(e);
            }
           // if (song==null){System.out.println("Song Not Found!!!Try Again");Main.displaymainmenu(userObj);}
            return allSongs;
        }
    public Song search_for_Song(User userObj,String song_id){
        Song song=null;
        try {
            Connection con=DBConnection.getConnection();
            String query4 = "select * from Song where Song_Id='" + song_id + "'";
            Statement st4 = con.createStatement();
            ResultSet res4 = st4.executeQuery(query4);
            while (res4.next()) {
                String songId = res4.getString(1);
                String songName = res4.getString(2);
                Time songDuration = res4.getTime(3);
                String songGenre = res4.getString(4);
                String song_Artist_Name = res4.getString(5);
                String song_Album_Name = res4.getString(6);
                String song_filePath = res4.getString(7);
                song = new Song(songId, songName, songDuration, songGenre, song_Artist_Name, song_Album_Name, song_filePath);
            }
        }catch (Exception e)
        {
            System.out.println(e);
        }
        if (song==null){System.out.println("Song Not Found!!!Try Again");Main.displaymainmenu(userObj);}
        return song;
    }
    public String playSong(User userObj)
    {
        List<Song> allsongsList1=new ArrayList<>();
        allsongsList1=displayallSongs();
        System.out.printf("%3s %15s %15s %10s %20s %18s \n","Song Id","Song Name","Duration","Genre","Artist Name","Album Name");
        allsongsList1.forEach(x-> System.out.printf("%3s %19s %15s %12s %21s %16s \n",x.getSong_id(),x.getSong_name(),x.getSong_Duration(),
                x.getSong_genre(),x.getSong_artist_name(),x.getSong_album_name()));
        System.out.println("Enter Song id that you want to Play");
        String songid1=scan.next();
        Song song1=search_for_Song(userObj,songid1);
        return song1.getSong_filepath();
    }
}
/*System.out.printf("%3s %15s %15s %10s %20s %18s \n","Song Id","Song Name","Duration","Genre","Artist Name","Album Name");
                            allsongsList.forEach(x-> System.out.printf("%3s %19s %15s %12s %21s %16s \n",x.getSong_id(),x.getSong_name(),x.getSong_Duration(),
                                    x.getSong_genre(),x.getSong_artist_name(),x.getSong_album_name()));*/