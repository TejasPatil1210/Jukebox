package org.example;
import org.example.DAOImplClass.PlaylistImpl;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.example.Model.Playlist;
import org.example.Model.User;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class PlaylistImplTest {
    private User userTejas;
    private User ritika;
    PlaylistImpl playlistImplObj=null;
    @BeforeEach
    public void setUp()
    {
        playlistImplObj=new PlaylistImpl();
        userTejas=new User("TejasP@123","tejas123","Tejas Patil","7854120369");
        ritika=new User("Ritika123","riti123","Ritika Sharma","9854763215");
    }
    @AfterEach
    public void teardown()
    {
        playlistImplObj=null;
    }
   @Test
   public void myplaylist_test()
   {

       List<Playlist> list=playlistImplObj.myPlaylists(userTejas);
       assertEquals(4,list.size());
       List<Playlist> list1=playlistImplObj.myPlaylists(ritika);
       assertEquals(2,list1.size());
   }

    @Test
    public void getPlaylistNAme_test() {
        String expected="Gym";
        String actual=playlistImplObj.getPlaylistName(userTejas,1004);
        assertEquals(expected,actual);
        String expected1="Lofy";
        String actual1=playlistImplObj.getPlaylistName(userTejas,1008);
        assertEquals(expected1,actual1);
        String expected2="Party";
        String actual2=playlistImplObj.getPlaylistName(ritika,1007);
        assertEquals(expected2,actual2);
    }
    @Test
    public void getPlaylistId_test() {
        int expected=1002;
        int actual=playlistImplObj.getPlaylistId(ritika,"Gym");
        assertEquals(expected,actual);
        int expected1=1005;
        int actual1=playlistImplObj.getPlaylistId(userTejas,"Love");
        assertEquals(expected1,actual1);
        int expected2=1007;
        int actual2=playlistImplObj.getPlaylistId(ritika,"Party");
        assertEquals(expected2,actual2);
    }




}
