package by.andrukovich.accounting.entify.users;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
@Data
@XmlRootElement
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class User extends Object implements Serializable {
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "password")
    private String password;
    @XmlElement(name = "online")
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
