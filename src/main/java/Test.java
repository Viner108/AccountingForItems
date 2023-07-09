import accounting.AccountingForItemsApplication;

import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Random;
import java.util.RandomAccess;

public class Test {
    public static void main(String[] args) throws IOException {
        AccountingForItemsApplication application=new AccountingForItemsApplication();
        application.clean();
        application.createUser("X","Y");
        application.createUser("X2","Y2");
        application.createUser("X3","Y3");
        application.createUser("X4","Y4");
        application.loginUser("X","Y");
        application.isUser("X2","Y2");
        application.save();
        application.readAll();
        application.getTable().insert(application.getComputer(),application.getPerson1(),application.getLog());
        application.getTable().insert(application.getComputer(),application.getPerson2(),application.getLog());
        application.getTable().remove(application.getComputer(),application.getPerson2(),application.getLog());
        application.getTable().movement(application.getComputer(),application.getPerson1(),application.getBed(),application.getLog());
        application.randomPlace(application.getDress(),application.getPerson1(),application.getTable(),application.getArmchair(),application.getBed(),application.getFloor());
        application.searchInThisRoom(application.getDress(),application.getPerson2(),application.getFloor(),application.getBed(),application.getTable(),application.getArmchair(),application.getSuitcase());
        application.getTable().answerSearch(application.getDress(),application.getPerson1(),application.getLog());
        application.AllRoom(application.getComputer(),application.loginUser("X","Y"));
        application.AllRoom(application.getComputer(),application.loginUser("X5","Y5"));
        application.drugExpirationDate(application.getMedicine());
        application.documentExpirationDate(application.getDocument());
    }
}
