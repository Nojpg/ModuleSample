package services.service;

import domain.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    User takeUser(Long id);
    List<User> takeAll();
}
