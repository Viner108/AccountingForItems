package accounting.repository;

import java.util.ArrayList;

public interface Repository<T> {
    void writeAll( T... items);
    ArrayList<T> readFileWithItems();
    void cleanFile();
    void write( ArrayList<T> allItem);
    void writeWithAppend(ArrayList<T> allUser, boolean append);
}
