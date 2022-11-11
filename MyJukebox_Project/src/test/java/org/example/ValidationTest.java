package org.example;

import org.example.DAOImplClass.SongImpl;
import org.example.Model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.Validation;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class ValidationTest {
    Validation valid=null;
    private User usertejas;
    @BeforeEach
    public void setUp()
    {
        valid=new Validation();
    }
    @AfterEach
    public void teardown()
    {
        valid=null;
        //usertejas=new User("TejasP@123","tejas123","Tejas Patil","7854120369");
    }

    @Test
    public void isPhoneNoValid_Test()
    {
        int expected=0;
        int actual=valid.isPhoneNoValid("987456123");
        assertEquals(expected,actual);
        int expected1=0;
        int actual1=valid.isPhoneNoValid("5456123456");
        assertEquals(expected1,actual1);
        int expected2=1;
        int actual2=valid.isPhoneNoValid("9874561230");
        assertEquals(expected2,actual2);
    }
    @Test
    public void checkUserId_Test()
    {
        int expected=0;
        int actual=valid.checkUserId("TejasP@123");
        assertEquals(expected,actual);
        int expected1=1;
        int actual1=valid.checkUserId("TejasP123");
        assertEquals(expected1,actual1);
        int expected2=0;
        int actual2=valid.checkUserId("Ritika123");
        assertEquals(expected2,actual2);
    }

    @Test
    public void checkUserIdexists_Test()
    {
        int expected=1;
        int actual=valid.checkUserIdexists("TejasP@123");
        assertEquals(expected,actual);
        int expected1=0;
        int actual1=valid.checkUserIdexists("TejasP123");
        assertEquals(expected1,actual1);
        int expected2=1;
        int actual2=valid.checkUserIdexists("Ritika123");
        assertEquals(expected2,actual2);
    }

    @Test
    public void checkPassword_Test()
    {
        int expected=1;
        int actual=valid.checkPassword("tejas123","tejas123");
        assertEquals(expected,actual);
        int expected1=0;
        int actual1=valid.checkPassword("TEJAS123","tejas123");
        assertEquals(expected1,actual1);
        int expected2=0;
        int actual2=valid.checkPassword("riti123","Riti123");
        assertEquals(expected2,actual2);
    }

    @Test
    public void dupMobileNochk_Test()
    {
        int expected=0;
        int actual=valid.dupMobileNochk("7854120369");
        assertEquals(expected,actual);
        int expected1=0;
        int actual1=valid.dupMobileNochk("9854763215");
        assertEquals(expected1,actual1);
        int expected2=1;
        int actual2=valid.dupMobileNochk("9885639512");
        assertEquals(expected2,actual2);
    }


}
