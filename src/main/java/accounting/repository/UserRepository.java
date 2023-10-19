package accounting.repository;

import accounting.entify.users.User;

import java.nio.file.Path;

public class UserRepository extends FileRepository<User> {
    public UserRepository(Path path) {
        super(path);
    }
}
