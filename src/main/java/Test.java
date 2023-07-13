import accounting.AccountingForItemsApplication;

import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Random;
import java.util.RandomAccess;

public class Test {
    public static void main(String[] args) throws IOException {
        AccountingForItemsApplication application=new AccountingForItemsApplication();
       testCreateUser();
       testLoginUser();
        application.clean();
    }
    public static void testCreateUser(){
        AccountingForItemsApplication application=new AccountingForItemsApplication();
        application.createUser("X","Y");
        application.clean();
    }
    public static void testLoginUser(){
        AccountingForItemsApplication application=new AccountingForItemsApplication();
        application.createUser("X","Y");
        System.out.println(application.loginUser("X","Y").toString());
        application.readAll();
    }
}
