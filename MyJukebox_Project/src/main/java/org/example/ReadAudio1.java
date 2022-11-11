package org.example;
import org.example.Model.PlaylistDetails;
import org.example.Model.User;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class ReadAudio1 {

    public void readAudio1(List<PlaylistDetails> mylist, int count,User userObj) {
        int size = mylist.size();
        ListIterator<PlaylistDetails> iterate = mylist.listIterator();
        while (iterate.hasNext()) {
            PlayAudio playAudio = new PlayAudio();
            int c = 0;
            count = count - 1;
            try {
                playAudio.playAudio1(iterate.next().getContentPath(), count);

                playAudio.play();
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    System.out.println("1. pause");
                    System.out.println("2. resume");
                    System.out.println("3. restart");
                    System.out.println("4. Next");
                    System.out.println("5. Prev");
                    System.out.println("6. stop");

                    if (c == 6) {
                        break;
                    }

                    if (scanner.hasNextInt()) {
                        c = scanner.nextInt();
                    } else {
                        break;
                    }
                    switch (c) {
                        case 1:
                            playAudio.pause();
                            break;
                        case 2:
                            playAudio.resumeAudio();
                            break;
                        case 3:
                            playAudio.restart();
                            break;
                        case 4:
                            playAudio.stop1();
                            //Main.displaymainmenu(userObj);/*
                           if(iterate.hasNext())
                           {
                               playAudio.playAudio1(iterate.next().getContentPath(),1);

                           }
                           else{
                               //System.out.println("check");
                               Main.displaymainmenu(userObj);
                           }

                            //*if(iterate.next().getContentPath().equalsIgnoreCase(""))


                            break;
                        case 5:
                            playAudio.stop();
                            iterate.hasPrevious();
                            if(iterate.hasPrevious())
                            {
                                playAudio.playAudio1(iterate.previous().getContentPath(),1);

                            }
                            else {
                                System.out.println("check");
                                Main.displaymainmenu(userObj);
                            }
                            //iterate.hasPrevious();
                            /*if(iterate.previous().getContentPath().equalsIgnoreCase(""))
                            {
                                System.out.println("check");
                                playAudio.stop();
                            }
                            playAudio.playAudio1(iterate.previous().getContentPath(),1);*/
                            break;
                        case 6:
                            playAudio.stop();
                           Main.displaymainmenu(userObj);
                            break;
                    }
                }
            } catch (Exception ex) {
                System.out.println("Error with playing sound." + ex);
            }
        }
    }
}

