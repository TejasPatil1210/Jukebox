package org.example;

import org.example.DAOImplClass.PodcastImpl;
import org.example.Model.Song;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.Model.Podcast;
import org.example.Model.User;
//import java.net.UnknownServiceException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class PodcastImplTest {
    PodcastImpl podcastImplObj=null;
    private User usertejas;
    @BeforeEach
    public void setUp()
    {
        podcastImplObj=new PodcastImpl();
    }
    @AfterEach
    public void teardown()
    {
        podcastImplObj=null;
        usertejas=new User("TejasP@123","tejas123","Tejas Patil","7854120369");
    }
    @Test
    public void display_allPodcasts_test()
    {
        assertEquals(3,podcastImplObj.displayAllPodcasts().size());
        String expected="P02";
        String actual=podcastImplObj.displayAllPodcasts().get(1).getPodcast_id();
        assertEquals(expected,actual);

    }

    @Test
    public void search_for_Podcast_test() {
        String expected="The Indian Startup SHow";
        Podcast actual=podcastImplObj.search_for_Podcast(usertejas,"Neil Patel",1);
        assertEquals(expected,actual.getPodcast_name());
        String expected1="The Other Stories";
        Podcast actual1=podcastImplObj.search_for_Podcast(usertejas,"P03",3);
        assertEquals(expected1,actual1.getPodcast_name());
        String expected2="The Other Stories";
        Podcast actual2=podcastImplObj.search_for_Podcast(usertejas,"2019-05-30",2);
        assertEquals(expected1,actual1.getPodcast_name());
    }

}


