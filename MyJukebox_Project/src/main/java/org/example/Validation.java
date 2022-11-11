package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public int isPhoneNoValid(String phone)
    {
        Pattern p=Pattern.compile("^(\\+)(0|91)?[6-9][0-9]{9}$");
        Pattern p1=Pattern.compile("^[6-9][0-9]{9}$");
        Matcher m=p.matcher(phone);
        Matcher m1=p1.matcher(phone);
        if((m.find())||(m1.find())) return 1;
        else return 0;
    }

    public int checkUserId(String userIdIP )
    {
        String userid="";
        try {
            Connection con1 = DBConnection.getConnection();
            String selectQue1 = "Select User_Id from User where User_Id='" + userIdIP + "'";
            Statement st1 = con1.createStatement();
            ResultSet rs3 = st1.executeQuery(selectQue1);
            //String  = "";
            while (rs3.next()) {
                userid = rs3.getString(1);
            }

        } catch (Exception e) {
            System.out.println("Error----" + e);
        }
        if (!userIdIP.equalsIgnoreCase(userid)) return 1;
        else return 0;
    }


    public int checkUserIdexists(String userIdIP )
    {
        String userid="";
        try {
            Connection con1 = DBConnection.getConnection();
            String selectQue1 = "Select User_Id from User where User_Id='" + userIdIP + "'";
            Statement st1 = con1.createStatement();
            ResultSet rs3 = st1.executeQuery(selectQue1);
            //String  = "";
            while (rs3.next()) {
                userid = rs3.getString(1);
            }

        } catch (Exception e) {
            System.out.println("Error----" + e);
        }
        if (userIdIP.equalsIgnoreCase(userid)) return 1;
        else return 0;
    }

    public int checkPassword(String PassIP,String pass )
    {
        if(PassIP.equals(pass)) return 1;
        else return 0;
    }

    public int dupMobileNochk(String phone)
    {
        String mobile_No="";
        try {
            Connection con1 =DBConnection.getConnection();
            String selectQue1 = "Select Mobile_No from user where Mobile_No='" + phone + "'";
            Statement st1 = con1.createStatement();
            ResultSet rs3 = st1.executeQuery(selectQue1);
            //String  = "";
            while (rs3.next()) {
                mobile_No = rs3.getString(1);
            }

        } catch (Exception e) {
            System.out.println("Error----" + e);
        }
        if (!mobile_No.equalsIgnoreCase(phone)||mobile_No.equalsIgnoreCase("")) return 1;
        else return 0;
    }

    public int validpass(String password)
    {

        int passlen=password.length();

        if(passlen>=4) return 1;
        else return 0;


        /*Pattern p=Pattern.compile("^(\\+)(0|91)?[6-9][0-9]{9}$");
        Pattern p1=Pattern.compile("^[6-9][0-9]{9}$");
        Matcher m=p.matcher(phone);
        Matcher m1=p1.matcher(phone);
        if((m.find())||(m1.find())) return 1;
        else return 0;*/
    }
    public int validUserId(String userId)
    {

        int userlen=userId.length();

        if(userlen>=6) return 1;
        else return 0;


        /*Pattern p=Pattern.compile("^(\\+)(0|91)?[6-9][0-9]{9}$");
        Pattern p1=Pattern.compile("^[6-9][0-9]{9}$");
        Matcher m=p.matcher(phone);
        Matcher m1=p1.matcher(phone);
        if((m.find())||(m1.find())) return 1;
        else return 0;*/
    }
}
//mobchk.equalsIgnoreCase(null) || !(mobchk.equalsIgnoreCase(mobNo)
