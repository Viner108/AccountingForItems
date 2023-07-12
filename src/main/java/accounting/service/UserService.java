package accounting.service;

import accounting.entify.places.Place;
import accounting.repository.UserRepository;

import java.nio.file.Path;
import java.util.ArrayList;

public class UserService {
    private UserRepository userRepository=new UserRepository();
    private Path path;
    private ArrayList<Place> places = new ArrayList<>();

    public UserService(Path path) {
        this.path = path;
    }
}
