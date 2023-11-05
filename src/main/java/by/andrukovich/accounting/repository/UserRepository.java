package by.andrukovich.accounting.repository;

import by.andrukovich.accounting.entify.users.User;
import by.andrukovich.accounting.entify.users.UserMap;

import java.nio.file.Path;

public class UserRepository extends FileRepository<User, UserMap> {
    public UserRepository(Path path) {
        super(path);
    }
}
