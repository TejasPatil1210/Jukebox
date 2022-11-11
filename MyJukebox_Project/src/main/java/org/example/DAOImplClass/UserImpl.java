package org.example.DAOImplClass;

import org.example.DAOInterfaces.UserInterface;
import org.example.DBConnection;
import org.example.Main;
import org.example.Model.User;
import org.example.Validation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class UserImpl implements UserInterface {
    Scanner scan=new Scanner(System.in);
    Validation validation=new Validation();
    public void login() {
        System.out.println("Enter Your User ID");
        String userid = scan.next();
        int useridchk = validation.checkUserIdexists(userid);
        while (useridchk == 0) {
            System.out.println("This User Id is Not Exist!!!Please Enter valid User Id!");
            System.out.println("Enter Your User ID");
            userid = scan.next();
            useridchk = validation.checkUserIdexists(userid);
        }
        System.out.println("Enter Password");
        String password = scan.next();
        try {
            Connection con = DBConnection.getConnection();
            String selectQue1 = "Select Password from User where User_Id='" + userid + "'";
            Statement st = con.createStatement();
            ResultSet rs1 = st.executeQuery(selectQue1);
            String pass1 = "";

            while (rs1.next()) {
                pass1 = rs1.getString(1);
            }

            int passwdchk = validation.checkPassword(password, pass1);
            while (passwdchk == 0) {
                System.out.println("Incorrect Password!!!Please Enter again");
                System.out.println("Enter Password");
                password = scan.next();
                passwdchk = validation.checkPassword(password, pass1);
            }
            String selectQuery = "Select * from User where User_Id='" + userid + "'";
            Statement st1 = con.createStatement();
            ResultSet res = st1.executeQuery(selectQuery);
            while (res.next())
            {
                String user_id=res.getString(1);
                String Upassword=res.getString(2);
                String user_name=res.getString(3);
                String mobile=res.getString(4);
                User userObj=new User(user_id,Upassword,user_name,mobile);
                Main.displaymainmenu(userObj);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public void register(){
        System.out.println("Enter Mobile Number");
        String mobNo=scan.next();
        scan.nextLine();
        int mobchk1=validation.isPhoneNoValid(mobNo);
        while (mobchk1==0)
        {
                System.out.println("Mobile Number is Invalid!!!Please Enter Again");
                System.out.println("Enter Mobile Number");
                mobNo = scan.next();
                scan.nextLine();
                mobchk1 = validation.isPhoneNoValid(mobNo);
        }
        try
        {
          Connection con=DBConnection.getConnection();
            /*String selectQue="select Mobile_No from user where Mobile_No='"+mobNo+"'";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(selectQue);
            String mobchk="";
            while (rs.next())
            {
                mobchk=rs.getString(1);
            }*/
            int mobchk=validation.dupMobileNochk(mobNo);
            if(mobchk==1)
            {
                System.out.println("Enter Your Full Name:");
                String full_Name=scan.nextLine();
                System.out.println("Set User ID to your Account");
                String User_Id=scan.next();
                scan.nextLine();
                int uIDCheck=validation.validUserId(User_Id);
                int Ucheck=validation.checkUserId(User_Id);
                while (Ucheck==0 || uIDCheck==0)
                {
                    if(Ucheck==0) {
                        System.out.println("This User ID is already exists. Please try with another one! ");
                        System.out.println("Set User ID to Your Account:");
                        User_Id = scan.next();
                        scan.nextLine();
                        Ucheck = validation.checkUserId(User_Id);
                        uIDCheck=validation.validUserId(User_Id);
                    }
                    if(uIDCheck==0)
                    {
                        System.out.println("Invalid User ID!!!User ID Contains minimum 6 characters/digits");
                        System.out.println("Set User ID to Your Account:");
                        User_Id = scan.next();
                        scan.nextLine();
                        uIDCheck=validation.validUserId(User_Id);
                        Ucheck = validation.checkUserId(User_Id);
                    }
                }
                System.out.println("Set Password to Your Account:");
                String password=scan.next();
                int validPass=validation.validpass(password);
                while (validPass==0)
                {
                    System.out.println("Invalid Password!!!Password Contains minimum 4 characters/digits");
                    System.out.println("Set Password to Your Account:");
                    password=scan.next();
                    validPass=validation.validpass(password);
                }

                String query = "insert into User values(?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1,User_Id);
                pst.setString(2,password);
                pst.setString(3,full_Name);
                pst.setString(4,mobNo);
                pst.executeUpdate();
                User userObj=new User(User_Id,password,full_Name,mobNo);
                Main.displaymainmenu(userObj);
            }
            else {
                System.out.println("You already have an Account");Main.loginCredentials();
            }
            }catch (Exception e)
        {
            System.out.println(e);
        }


    }
}
