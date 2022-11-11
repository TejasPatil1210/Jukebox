package org.example;
import org.example.DAOImplClass.*;
import org.example.Model.*;

import java.util.*;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        loginCredentials();
    }

    public static  void loginCredentials()
    {
        Scanner scan=new Scanner(System.in);
        UserImpl user=new UserImpl();
        //System.out.println("Hello world!");
        while (true)
        {
            System.out.println("\n 1.Sign Up \n 2.Log in  \n 3.Exit \nEnter your choice");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:user.register();break;
                case 2:user.login();break;
                case 3:System.exit(0);break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
    public static void displaymainmenu(User userObj)
    {
        Scanner scan=new Scanner(System.in);
        SongImpl songObj=new SongImpl();
        PodcastImpl podcastObj=new PodcastImpl();
        PlaylistImpl plobj=new PlaylistImpl();
        PlaylistDetailsImpl pldObj=new PlaylistDetailsImpl();
        ReadAudio readAudio=new ReadAudio();
        while (true)
        {
            System.out.println("Welcome "+userObj.getUser_name()+"!");
            System.out.println("\n 1.Songs \n 2.Podcasts \n 3.Playlist \n 4.Log Out\nEnter your choice");
            int choice = scan.nextInt();
            switch (choice) {
            case 1:
                while (true) {
                    System.out.println("\n 1.Display All Songs \n 2.Display all sorted songs \n 3.Search Song \n 4.Play Songs \n 5.Exit \n Enter your choice");
                    int choice1 = scan.nextInt();
                    switch (choice1) {
                        case 1:List<Song> allsongsList=new ArrayList<>();
                            allsongsList=songObj.displayallSongs();
                            System.out.printf("%3s %15s %15s %10s %20s %18s \n","Song Id","Song Name","Duration","Genre","Artist Name","Album Name");
                            allsongsList.forEach(x-> System.out.printf("%3s %19s %15s %12s %21s %16s \n",x.getSong_id(),x.getSong_name(),x.getSong_Duration(),
                                    x.getSong_genre(),x.getSong_artist_name(),x.getSong_album_name()));break;
                        case 2:List<Song> sortedsongsList=new ArrayList<>();
                            sortedsongsList=songObj.sort_all_Songs();
                            System.out.printf("%3s %15s %15s %10s %20s %18s \n","Song Id","Song Name","Duration","Genre","Artist Name","Album Name");
                            sortedsongsList.forEach(x-> System.out.printf("%3s %19s %15s %12s %21s %16s \n",x.getSong_id(),x.getSong_name(),x.getSong_Duration(),
                                    x.getSong_genre(),x.getSong_artist_name(),x.getSong_album_name()));break;
                        case 3:
                            while (true) {
                                System.out.println("\n 1.Search Songs by Artist Name \n 2.Search songs by Genre \n 3.Search Songs by Album Name \n 4.Search song by Song Id \n 5.Exit \n Enter your choice");
                                int choice2 = scan.nextInt();
                                List<Song> songlist=new ArrayList<>() ;
                                Song song;
                                switch (choice2) {
                                    case 1:
                                        System.out.println("Enter Artist Name:");
                                        scan.nextLine();
                                        String artist_name=scan.nextLine();
                                        scan.nextLine();
                                        System.out.println("artist Name= "+artist_name);
                                        songlist=songObj.search_Song_categorywise(userObj,artist_name,1);
                                        System.out.printf("%3s %15s %15s %10s %20s %18s \n","Song Id","Song Name","Duration","Genre","Artist Name","Album Name");
                                        songlist.forEach(x->System.out.printf("%3s %19s %15s %12s %21s %16s \n",x.getSong_id(),x.getSong_name(),x.getSong_Duration(),
                                                x.getSong_genre(),x.getSong_artist_name(),x.getSong_album_name()));
                                        break;
                                    case 2:System.out.println("Enter Genre Name:");
                                        scan.nextLine();
                                        String genre_name=scan.nextLine();
                                        scan.nextLine();
                                        songlist=songObj.search_Song_categorywise(userObj,genre_name,2);
                                        System.out.printf("%3s %15s %15s %10s %20s %18s \n","Song Id","Song Name","Duration","Genre","Artist Name","Album Name");
                                        songlist.forEach(x->System.out.printf("%3s %19s %15s %12s %21s %16s \n",x.getSong_id(),x.getSong_name(),x.getSong_Duration(),
                                                x.getSong_genre(),x.getSong_artist_name(),x.getSong_album_name()));
                                      /*  songlist.forEach(x->System.out.println(x.getSong_id()+"\t "+x.getSong_name()+"\t"+x.getSong_Duration()
                                                +"\t "+x.getSong_genre()+"\t "+x.getSong_artist_name()+"\t "+x.getSong_album_name()));*/
                                        break;
                                    case 3:System.out.println("Enter Album Name:");
                                        scan.nextLine();
                                        String album_name=scan.nextLine();
                                        scan.nextLine();
                                        System.out.println("album="+album_name);
                                        songlist=songObj.search_Song_categorywise(userObj,album_name,3);
                                        System.out.printf("%3s %15s %15s %10s %20s %18s \n","Song Id","Song Name","Duration","Genre","Artist Name","Album Name");
                                        songlist.forEach(x->System.out.printf("%3s %19s %15s %12s %21s %16s \n",x.getSong_id(),x.getSong_name(),x.getSong_Duration(),
                                                x.getSong_genre(),x.getSong_artist_name(),x.getSong_album_name()));
                                        /*songlist.forEach(x->System.out.println(x.getSong_id()+"\t "+x.getSong_name()+"\t"+x.getSong_Duration()
                                                +"\t "+x.getSong_genre()+"\t "+x.getSong_artist_name()+"\t "+x.getSong_album_name()));*/
                                        break;
                                    case 4:System.out.println("Enter Song Id:");
                                        scan.nextLine();
                                        String songId=scan.nextLine();
                                        scan.nextLine();
                                        song=songObj.search_for_Song(userObj,songId);
                                        System.out.printf("%3s %15s %15s %10s %20s %18s \n","Song Id","Song Name","Duration","Genre","Artist Name","Album Name");
                                        System.out.printf("%3s %19s %15s %12s %21s %16s \n",song.getSong_id(),song.getSong_name(),song.getSong_Duration(),song.getSong_genre()
                                                ,song.getSong_artist_name(),song.getSong_album_name());
                                        break;
                                    case 5:displaymainmenu(userObj);break;
                                    default: System.out.println("Invalid Choice");
                                }
                            }
                        case 4:
                            String songPath=songObj.playSong(userObj);
                            System.out.println("How many times You want to play this song");
                            int count=scan.nextInt();
                            readAudio.readAudio(songPath,count);
                            break;
                        case 5:displaymainmenu(userObj);break;
                        default:
                            System.out.println("Invalid Choice");
                        }
                    }

            case 2:
                while (true) {
                    System.out.println("\n 1.Display All Podcasts \n 2.Display all sorted Podcasts \n 3.Search Podcast \n 4.Play Podcast \n 5.Exit \n Enter your choice");
                    int choice1 = scan.nextInt();
                    switch (choice1) {
                        case 1:List<Podcast> allPodcastsList=new ArrayList<>();
                            allPodcastsList=podcastObj.displayAllPodcasts();
                            System.out.printf("%3s %27s %28s %25s  \n","Podcast Id","Podcast Name","Podcast Artist Name","Podcast Released Date");
                            allPodcastsList.forEach(x-> System.out.printf("%3s %40s %19s %20s \n",x.getPodcast_id(),x.getPodcast_name()
                                    ,x.getPodcast_artist(),x.getReleased_date()));break;
                        case 2:List<Podcast> sortedPodcastsList=new ArrayList<>();
                            sortedPodcastsList=podcastObj.sort_all_Podcast();
                            System.out.printf("%3s %27s %28s %25s  \n","Podcast Id","Podcast Name","Podcast Artist Name","Podcast Released Date");
                            sortedPodcastsList.forEach(x-> System.out.printf("%3s %40s %19s %20s \n",x.getPodcast_id(),x.getPodcast_name()
                                    ,x.getPodcast_artist(),x.getReleased_date()));break;
                        case 3:
                            while (true)
                            {
                                System.out.println("\n 1.Search podcast by celebrity \n 2.Search podcast by Released \n 3.Search podcast by Podcast Id \n 4.Exit \n Enter your choice");
                                int choice2 = scan.nextInt();
                                Podcast podcast;
                                switch (choice2)
                                {
                                    case 1:System.out.println("Enter celebrity Name:");
                                        scan.nextLine();
                                        String celebrity_name=scan.nextLine();
                                        scan.nextLine();
                                        System.out.println("artist Name= "+celebrity_name);
                                        podcast= podcastObj.search_for_Podcast(userObj,celebrity_name,1);
                                        System.out.printf("%3s %27s %28s %25s  \n","Podcast Id","Podcast Name","Podcast Artist Name","Podcast Released Date");
                                        System.out.printf("%3s %40s %19s %20s \n",podcast.getPodcast_id(),podcast.getPodcast_name(),podcast.getPodcast_artist(),
                                                podcast.getReleased_date());
                                        break;
                                    case 2:System.out.println("Enter Date:");
                                        String date=scan.next();
                                        scan.nextLine();
                                        System.out.println("date= "+date);
                                        podcast= podcastObj.search_for_Podcast(userObj,date,2);
                                        System.out.printf("%3s %27s %28s %25s  \n","Podcast Id","Podcast Name","Podcast Artist Name","Podcast Released Date");
                                        System.out.printf("%3s %40s %19s %20s \n",podcast.getPodcast_id(),podcast.getPodcast_name(),podcast.getPodcast_artist(),
                                                podcast.getReleased_date());
                                       /* System.out.println(podcast.getPodcast_id()+""+podcast.getPodcast_name()+""+podcast.getReleased_date()+""+
                                                podcast.getPodcast_artist());*/
                                        break;
                                    case 3:System.out.println("Enter Podcast id");
                                        String podcastid=scan.next();
                                        scan.nextLine();
                                        podcast= podcastObj.search_for_Podcast(userObj,podcastid,3);
                                        System.out.printf("%3s %27s %28s %25s  \n","Podcast Id","Podcast Name","Podcast Artist Name","Podcast Released Date");
                                        System.out.printf("%3s %40s %19s %20s \n",podcast.getPodcast_id(),podcast.getPodcast_name(), podcast.getPodcast_artist(),
                                                podcast.getReleased_date());
                                        break;
                                    case 4:displaymainmenu(userObj);break;
                                    default: System.out.println("Invalid Choice");

                                }
                            }

                        case 4:  String epiPath=podcastObj.playPodcast(userObj);
                            System.out.println("How many times do you want to play this Episode of Podcast");
                            int count=scan.nextInt();
                            readAudio.readAudio(epiPath,count);
                        case 5:displaymainmenu(userObj);break;
                        default:
                            System.out.println("Invalid Choice");
                    }
                }

            case 3:
                while (true) {
                System.out.println("\n 1.My Playlists \n 2.Create Playlist \n 3.Delete Playlist \n 4.Add content in Playlist " +
                        "\n 5.Delete content from Playlist \n 6.Play content from Playlist \n 7.Play whole Playlist \n 8.Exit \n Enter your choice");
                int choice1 = scan.nextInt();
                switch (choice1) {
                    case 1:

                        List<Playlist> myPLlist=new ArrayList<>();
                        myPLlist=plobj.myPlaylists(userObj);
                        if(myPLlist.size()==0){
                            System.out.println("currently you don't have created any playlist");break;
                        }

                        else {
                            while (true) {
                            System.out.println("--------------------------------------");
                            System.out.println("            Your Playlists           ");
                            System.out.println("--------------------------------------");
                            System.out.printf("%10s %20s \n", "Playlist ID", "Playlist Name");
                            myPLlist.forEach(x -> System.out.printf("%9s %20s \n", x.getPlaylist_id(), x.getPlaylist_name()));
                            System.out.println("--------------------------------------");

                            //while (true) {
                                System.out.println("Do you want to view the contents of the playlists?");
                                System.out.println(" 1.Yes \n 2.No \n Enter your choice");
                                int choice2 = scan.nextInt();
                                scan.nextLine();
                                switch (choice2) {
                                    case 1:
                                        System.out.println("Enter Playlist Id:");
                                        int plistID = scan.nextInt();
                                        scan.nextLine();
                                        List<PlaylistDetails> viewplaylist = new ArrayList<>();
                                        viewplaylist = pldObj.viewPlaylist(plistID, userObj);
                                        if (viewplaylist.size() == 0) {
                                            System.out.println("Playlist is empty!!!");
                                        } else {
                                            System.out.printf("%10s %40s \n", "Content ID", "Content Name");
                                            viewplaylist.forEach(x -> System.out.printf("%9s %40s \n", x.getContent_id(), x.getContentName()));
                                        }
                                        break;
                                    case 2:
                                        Main.displaymainmenu(userObj);
                                        break;
                                    default:
                                        System.out.println("Invalid Choice");
                                }
                            }
                        }
                        //break;
                    case 2:List<PlaylistDetails> newPLlist=new ArrayList<>();
                        newPLlist=plobj.createPlaylist(userObj);
                        if (newPLlist.size()!=0){
                            System.out.printf("%10s %40s \n","Content ID","Content Name");
                            newPLlist.forEach(x-> System.out.printf("%9s %40s \n",x.getContent_id(),x.getContentName()));}
                        break;
                    case 3:plobj.deletePlaylist(userObj);break;
                    case 4:
                        List<Playlist> myPLlist1=new ArrayList<>();
                        myPLlist1=plobj.myPlaylists(userObj);
                        System.out.println("--------------------------------------");
                        System.out.println("            Your Playlists           ");
                        System.out.println("--------------------------------------");
                        System.out.printf("%10s %20s \n","Playlist ID","Playlist Name");
                        myPLlist1.forEach(x-> System.out.printf("%9s %20s \n",x.getPlaylist_id(),x.getPlaylist_name()));
                        System.out.println("--------------------------------------");
                        System.out.println("Enter Playlist Id in that you want to add content:");
                       // scan.nextLine();
                        int pllistID=scan.nextInt();
                        scan.nextLine();
                        //System.out.println("plname="+plName);
                        System.out.println();

                        String pLName=plobj.getPlaylistName(userObj,pllistID);
                        if(pLName.equalsIgnoreCase("")){
                            System.out.println("Playlist Not Found");break;
                        }
                        Playlist plobj1=new Playlist(pllistID,pLName,userObj);
                        List<PlaylistDetails> updatedlist=new ArrayList<>();
                        updatedlist=pldObj.add_content_in_playlist(plobj1,userObj,pLName);
                        System.out.printf("%10s %40s \n","Content ID","Content Name");
                        updatedlist.forEach(x-> System.out.printf("%9s %40s \n",x.getContent_id(),x.getContentName()));break;
                    case 5:List<Playlist> myPLlist2=new ArrayList<>();
                        myPLlist2=plobj.myPlaylists(userObj);
                        System.out.println("--------------------------------------");
                        System.out.println("            Your Playlists           ");
                        System.out.println("--------------------------------------");
                        System.out.printf("%10s %20s \n","Playlist ID","Playlist Name");
                        myPLlist2.forEach(x-> System.out.printf("%9s %20s \n",x.getPlaylist_id(),x.getPlaylist_name()));
                        System.out.println("--------------------------------------");
                        System.out.println("Enter Playlist Id from that you want to delete content:");
                        int pLlistId=scan.nextInt();
                        String plName1=plobj.getPlaylistName(userObj,pLlistId);
                        if(plName1.equalsIgnoreCase("")){
                            System.out.println("Playlist Not Found");break;
                        }
                        List<PlaylistDetails> viewplaylist=new ArrayList<>();
                        viewplaylist=pldObj.viewPlaylist(pLlistId,userObj);
                        System.out.printf("%10s %40s \n","Content ID","Content Name");
                        viewplaylist.forEach(x-> System.out.printf("%9s %40s \n",x.getContent_id(),x.getContentName()));

                        Playlist plobj2=new Playlist(pLlistId,plName1,userObj);
                        List<PlaylistDetails> updatedlist1=new ArrayList<>();
                        updatedlist1=pldObj.remove_content_from_playlist(plobj2,userObj,plName1);
                        System.out.printf("%10s %40s \n","Content ID","Content Name");
                        updatedlist1.forEach(x-> System.out.printf("%9s %40s \n",x.getContent_id(),x.getContentName()));break;
                    case 6:String contentPath=pldObj.playContentFromPlaylist(userObj);
                        System.out.println("How many times You want to play this content");
                        int count=scan.nextInt();
                        readAudio.readAudio(contentPath,count);
                        break;
                    case 7:pldObj.playwholePLlist(userObj);
                    case 8:displaymainmenu(userObj);break;
                    default: System.out.println("Invalid Choice");
                }
            }
            case 4:loginCredentials();break;
            default: System.out.println("Invalid choice");
        }
    }
}
}