package accounting.service;

import accounting.entify.places.Place;
import accounting.repository.UserRepository;

import java.nio.file.Path;
import java.util.ArrayList;

public class UserService {
    private Path path;
    private ArrayList<Place> places = new ArrayList<>();
    private UserRepository userRepository=new UserRepository(path);

    public UserService(Path path) {
        this.path = path;
    }
}
