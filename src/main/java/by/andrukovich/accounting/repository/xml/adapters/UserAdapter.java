package by.andrukovich.accounting.repository.xml.adapters;

import by.andrukovich.accounting.entity.users.User;
import by.andrukovich.accounting.entity.users.UserWrapper;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserAdapter extends XmlAdapter<UserWrapper, Map<Integer, User>> {

    @Override
    public Map<Integer, User> unmarshal(UserWrapper userWrapper) throws Exception {
        Map<Integer, User> userMap = null;
        if (userWrapper != null && userWrapper.users != null && !userWrapper.users.isEmpty()) {
            userMap = new HashMap<Integer, User>();
            int i=0;
            for (User user : userWrapper.users) {
                userMap.put(i,user);
                i++;
            }
        }
        return userMap;
    }

    @Override
    public UserWrapper marshal(Map<Integer, User> userMap) throws Exception {
        UserWrapper wrapper = new UserWrapper();
        List<User> elements = new ArrayList<User>();
        for (Map.Entry<Integer, User> property : userMap.entrySet()) {
            elements.add(property.getValue());
        }
        wrapper.users = elements;
        return wrapper;
    }
}