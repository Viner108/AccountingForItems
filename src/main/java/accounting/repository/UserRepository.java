package accounting.repository;

import accounting.entify.users.User;
import accounting.entify.users.UserMap;

import java.nio.file.Path;

public class UserRepository extends FileRepository<User, UserMap> {
    public UserRepository(Path path) {
        super(path);
    }
}
