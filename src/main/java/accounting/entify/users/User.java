package accounting.entify.users;

import java.io.Serializable;

public class User extends Object implements Serializable {
    private String name;
    private int id;
    private String password;
    private boolean online=false;
    public User(String name, int id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public String getName() {
        return name;
    }


    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "Имя пользователя='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
