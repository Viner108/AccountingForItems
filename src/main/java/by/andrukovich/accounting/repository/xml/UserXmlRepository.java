package by.andrukovich.accounting.repository.xml;

import by.andrukovich.accounting.entify.users.User;
import by.andrukovich.accounting.entify.users.UserMap;

import java.nio.file.Path;

public class UserXmlRepository extends FileXmlRepository<User, UserMap>{

    public UserXmlRepository(Path path) {
        super(path);
    }
}
