package accounting.service;

import accounting.entify.places.Place;
import accounting.entify.users.User;
import accounting.entify.users.UserMap;
import accounting.repository.Repository;
import accounting.repository.UserRepository;

import java.nio.file.Path;
import java.util.ArrayList;

public class UserService {
    private Path path;
    private ArrayList<Place> places = new ArrayList<>();
    private Repository repository;

    public UserService(Path path, Repository<User, UserMap> repository) {
        this.path = path;
        this.repository=repository;
    }
}
