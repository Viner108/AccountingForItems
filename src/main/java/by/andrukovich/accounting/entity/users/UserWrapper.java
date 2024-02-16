package by.andrukovich.accounting.entity.users;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class UserWrapper {
    @XmlElement(name = "user")
    public List<User> users = new ArrayList<User>();
}
