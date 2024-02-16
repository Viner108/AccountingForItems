package by.andrukovich.accounting.entity.users;

import by.andrukovich.accounting.repository.xml.adapters.UserAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Map;

@XmlRootElement(name = "UserMap")
public class UserMap {
    Map<Integer, User> userMap;

    public Map<Integer, User> getUserMap() {
        return userMap;
    }
    @XmlElement(name = "Users")
    @XmlJavaTypeAdapter(UserAdapter.class)
    public void setUserMap(Map<Integer, User> userMap) {
        this.userMap = userMap;
    }
}