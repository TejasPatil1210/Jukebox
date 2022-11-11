package org.example.DAOImplClass;

import org.example.DAOInterfaces.PlaylistDetailsInterface;
import org.example.DAOInterfaces.PlaylistInterface;
import org.example.DBConnection;
import org.example.Main;
import org.example.Model.Playlist;
import org.example.Model.PlaylistDetails;
import org.example.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlaylistImpl implements PlaylistInterface {
    Scanner scan=new Scanner(System.in);
    PlaylistDetailsImpl plimplObj=new PlaylistDetailsImpl();
    public List<PlaylistDetails> createPlaylist(User userObj){
        System.out.println("Set PlayList Name");
        String playlistName=scan.nextLine();
        scan.nextLine();
        List<PlaylistDetails> newPLList=new ArrayList<>();
        //System.out.println("size before="+newPLList.size());
        try{
            Connection con= DBConnection.getConnection();
            String selectQue="select Playlist_Name from Playlist where Playlist_Name='"+playlistName+"' and User_id='"+userObj.getUser_id()+"'";
            Statement st=con.createStatement();
            ResultSet res=st.executeQuery(selectQue);
            String pllistname="";
            while(res.next())
            {
                pllistname=res.getString(1);
            }
            System.out.println("check1"+pllistname);
            if((!pllistname.equalsIgnoreCase(playlistName)) ||(pllistname.equalsIgnoreCase("")))
            {

                String query="insert into Playlist(Playlist_Name,User_id) values(?,?)";
                PreparedStatement pst=con.prepareStatement(query);
                pst.setString(1,playlistName);
                pst.setString(2,userObj.getUser_id());
                pst.executeUpdate();
               int plid=getPlaylistId(userObj,playlistName);
                Playlist plObj=new Playlist(plid,playlistName,userObj);
                newPLList=plimplObj.add_content_in_playlist(plObj,userObj,playlistName);
                System.out.println("PlayList "+playlistName+ " is Successfully Created");
               // System.out.println("Size after"+newPLList.size());
            }

            else
            {
                System.out.println("This Playlist Name is Already Exists!!! Please Try with Another One!!!");
                createPlaylist(userObj);
            }
        }catch (Exception e){
            System.out.println(e);
        }
       //System.out.println("check  "+newPLList.size());
        //System.out.println("return");
        return newPLList;
    }
    public void deletePlaylist(User userObj){
       List<Playlist> view_Playlist=myPlaylists(userObj);
        System.out.println("--------------------------------------");
        System.out.println("            Your Playlists           ");
        System.out.println("--------------------------------------");
        System.out.printf("%10s %20s \n","Playlist ID","Playlist Name");
        view_Playlist.forEach(x-> System.out.printf("%9s %20s \n",x.getPlaylist_id(),x.getPlaylist_name()));
        System.out.println("--------------------------------------");

        System.out.println("Enter PlayList ID that you want to Delete");
        int playlistID=scan.nextInt();
        scan.nextLine();
        try{
            Connection con= DBConnection.getConnection();
            String selectQue="select Playlist_id from Playlist where Playlist_Id="+playlistID+" and User_id='"+userObj.getUser_id()+"'";
            Statement st=con.createStatement();
            ResultSet res=st.executeQuery(selectQue);
            int pllistId=0;
            while(res.next())
            {
                pllistId=res.getInt(1);
            }
            if((playlistID==pllistId))
            {
                String query5="set foreign_key_checks=1;";
                Statement st5 = con.createStatement();
                st5.executeUpdate(query5);
                String query="delete from Playlist where Playlist_Id="+playlistID+" and User_id='"+userObj.getUser_id()+"'";
                Statement st1=con.createStatement();
                st1.executeUpdate(query);

                System.out.println("PlayList is Successfully deleted");
                Main.displaymainmenu(userObj);
            }
            else
            {
                System.out.println("Playlist Not Found!!!");
                Main.displaymainmenu(userObj);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }


    public List<Playlist> myPlaylists(User userObj){
        List<Playlist> playlist=new ArrayList<>();
        try{
            Connection con=DBConnection.getConnection();
            String selectQue="select Playlist_id,Playlist_Name from Playlist where User_id='"+userObj.getUser_id()+"'";
            Statement st=con.createStatement();
            ResultSet res=st.executeQuery(selectQue);
            while(res.next())
            {
                int playlist_id=res.getInt(1);
                String playlistName=res.getString(2);
                Playlist plObj=new Playlist(playlist_id,playlistName,userObj);
                playlist.add(plObj);
            }

        }catch(Exception e)
        {
            System.out.println(e);
        }

        return playlist;
    }

    public String getPlaylistName(User userobj,int plId)
    {
        String plNAme="";
        try{
            Connection con=DBConnection.getConnection();
            String selectq="select Playlist_Name from playlist where playlist_id="+plId+" and User_id='"+userobj.getUser_id()+"'";
            Statement st=con.createStatement();
            ResultSet res=st.executeQuery(selectq);

            while(res.next())
            {
                plNAme=res.getString(1);
            }
            if(plNAme.equalsIgnoreCase("")) {System.out.println("Playlist Not Found!!!");
            Main.displaymainmenu(userobj);}
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return plNAme;
    }


    public int getPlaylistId(User userobj,String plName)
    {
        int plId=0;
        try{
            Connection con=DBConnection.getConnection();
            String selectq="select Playlist_Id from playlist where playlist_Name='"+plName+"' and User_id='"+userobj.getUser_id()+"'";
            Statement st=con.createStatement();
            ResultSet res=st.executeQuery(selectq);

            while(res.next())
            {
                plId=res.getInt(1);
            }
            if(plId==0) {System.out.println("Playlist Not Found!!!");
                Main.displaymainmenu(userobj);}
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return plId;
    }
}
