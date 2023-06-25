package accounting.users;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID=1L;
    private String name;
    private int id;
    private String password;

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

    @Override
    public String toString() {
        return "User{" +
                "Имя пользователя='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
