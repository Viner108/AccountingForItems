package users;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "Имя пользователя='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
