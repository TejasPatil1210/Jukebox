package org.example;

import org.example.DAOImplClass.PlaylistDetailsImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.example.Model.PlaylistDetails;
import org.example.Model.User;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaylistDetailsImplTest {
    private User userTejas;
    private User ritika;
    PlaylistDetailsImpl playlistDetailsImplObj=null;
    @BeforeEach
    public void setUp()
    {
        playlistDetailsImplObj=new PlaylistDetailsImpl();
        userTejas=new User("TejasP@123","tejas123","Tejas Patil","7854120369");
        ritika=new User("Ritika123","riti123","Ritika Sharma","9854763215");
    }
    @AfterEach
    public void teardown()
    {
        playlistDetailsImplObj=null;
    }
    @Test
    public void viewPlaylist_test()
    {
        List<PlaylistDetails> list=playlistDetailsImplObj.viewPlaylist(1005,userTejas);
        assertEquals(3,list.size());
        String expected="Pasoori";
        assertEquals(expected,list.get(1).getContentName());
        String expected1="Sulthan";
        assertEquals(expected1,list.get(0).getContentName());
        List<PlaylistDetails> list1=playlistDetailsImplObj.viewPlaylist(1002,ritika);
        assertEquals(3,list1.size());
        String expected2="Srivalli";
        assertEquals(expected2,list1.get(0).getContentName());
    }

}
