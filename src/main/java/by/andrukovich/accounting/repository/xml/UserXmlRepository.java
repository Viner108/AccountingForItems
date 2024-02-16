package by.andrukovich.accounting.repository.xml;

import by.andrukovich.accounting.entity.users.User;
import by.andrukovich.accounting.entity.users.UserMap;

import java.nio.file.Path;

public class UserXmlRepository extends FileXmlRepository<User, UserMap>{

    public UserXmlRepository(Path path) {
        super(path);
    }
}
