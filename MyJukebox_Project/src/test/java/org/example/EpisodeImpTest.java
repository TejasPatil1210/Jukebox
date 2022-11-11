package org.example;

import org.example.DAOImplClass.EpisodeImpl;

import org.example.Model.Episode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.example.Model.User;
//import java.net.UnknownServiceException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class EpisodeImpTest {

    EpisodeImpl epiImplObj=null;
    private User usertejas;
    @BeforeEach
    public void setUp()
    {
        epiImplObj=new EpisodeImpl();
    }
    @AfterEach
    public void teardown()
    {
        epiImplObj=null;
        usertejas=new User("TejasP@123","tejas123","Tejas Patil","7854120369");
    }
    @Test
    public void displayAllEpisodes_Test()
    {
     List<Episode> list=epiImplObj.displayAllEpisodes("P02");
     assertEquals(4,list.size());
     List<Episode> list1=epiImplObj.displayAllEpisodes("P01");
     assertEquals(2,list1.size());
     List<Episode> list2=epiImplObj.displayAllEpisodes("P01");
     assertEquals(2,list2.size());
    }

    @Test
    public void searchEpisode_Test()
    {
        String expected="Alex Krstic - A brutal manhunt";
        Episode actual=epiImplObj.searchEpisode(usertejas,"E03","P02");
        assertEquals(expected,actual.getEpisode_name());
        String expected1="Steve Taylor - The lasting effects of working undercover";
        Episode actual1=epiImplObj.searchEpisode(usertejas,"E06","P02");
        assertEquals(expected1,actual1.getEpisode_name());
        String expected2="The Wieght of Your Glare";
        Episode actual2=epiImplObj.searchEpisode(usertejas,"E08","P03");
        assertEquals(expected2,actual2.getEpisode_name());
        String expected3="Shalibhadra Shah CEO & Co-founder of ABC Talkies";
        Episode actual3=epiImplObj.searchEpisode(usertejas,"E01","P01");
        assertEquals(expected3,actual3.getEpisode_name());
    }
}
