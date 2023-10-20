package accounting.repository;

import java.util.ArrayList;

public interface Repository<T,R> {
    void writeToFile(ArrayList<T> allItem, R elements);
    ArrayList<T> readFileWithItems();
    void cleanFile();
    void writeWithAppend(ArrayList<T> allUser, R elements, boolean append);
}
