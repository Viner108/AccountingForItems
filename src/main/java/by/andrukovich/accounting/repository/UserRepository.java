package by.andrukovich.accounting.repository;

import by.andrukovich.accounting.entity.users.User;
import by.andrukovich.accounting.entity.users.UserMap;

import java.nio.file.Path;

public class UserRepository extends FileRepository<User, UserMap> {
    public UserRepository(Path path) {
        super(path);
    }
}
