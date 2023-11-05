package by.andrukovich.accounting.repository;

import java.util.ArrayList;

public interface Repository<T,R> {
    ArrayList<T> readFileWithItems();
    R readFromFile(R elementMap) throws  Exception;
    void cleanFile();
    void writeToFile(ArrayList<T> allUser, R elements, boolean append) throws  Exception;
}
