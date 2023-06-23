import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        AccountingForItemsApplication application=new AccountingForItemsApplication();
        application.getTable().insert(application.getComputer(),application.getPerson1());
        application.getTable().insert(application.getComputer(),application.getPerson2());
        application.save();
        application.read();

    }
}
