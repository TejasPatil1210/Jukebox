package org.example.Model;

public class User {
    private String user_id;
    private String password;
  //  private String email_id;
    private String user_name;
    private String mobile_no;

    public User(String user_id, String password, String user_name, String mobile_no) {
        this.user_id = user_id;
        this.password = password;
       // this.email_id = email_id;
        this.user_name = user_name;
        this.mobile_no = mobile_no;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
/*
    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }
*/
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", password='" + password + '\'' +
                ", user_name='" + user_name + '\'' +
                ", mobile_no='" + mobile_no + '\'' +
                '}';
    }
}
