package org.example;

import org.example.DAOImplClass.SongImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.Model.Song;
import org.example.Model.User;
//import java.net.UnknownServiceException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SongImplTest {
    SongImpl songImplObj=null;
    private User usertejas;
    @BeforeEach
    public void setUp()
    {
        songImplObj=new SongImpl();
    }
    @AfterEach
    public void teardown()
    {
        songImplObj=null;
        usertejas=new User("TejasP@123","tejas123","Tejas Patil","7854120369");
    }
    @Test
    public void display_allSongs_test()
    {
        assertEquals(5,songImplObj.displayallSongs().size());
        String expected="Srivalli";
        String actual=songImplObj.displayallSongs().get(2).getSong_name();
        assertEquals(expected,actual);

    }

    @Test
    public void search_Song_categorywise_test() {
        List<Song> list = songImplObj.search_Song_categorywise(usertejas, "Kgf", 3);
        assertEquals(2, list.size());
        List<Song> list1 = songImplObj.search_Song_categorywise(usertejas, "s", 1);
        assertEquals(2, list1.size());
        List<Song> list2 = songImplObj.search_Song_categorywise(usertejas, "pa", 3);
        assertEquals(1, list2.size());
        List<Song> list3 = songImplObj.search_Song_categorywise(usertejas, "bolly", 2);
        assertEquals(3, list3.size());
    }
    @Test
    public void display_search_for_song_test()
    {
        String expected="Sulthan";
        Song actual=songImplObj.search_for_Song(usertejas,"S01");
        assertEquals(expected,actual.getSong_name());
        String expected1="Laal Bindi";
        Song actual1=songImplObj.search_for_Song(usertejas,"S05");
        assertEquals(expected1,actual1.getSong_name());
    }
}
