package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection()
    {
        Connection con=null;
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Jukebox","root","TejasPatil143");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return con;
    }
}
