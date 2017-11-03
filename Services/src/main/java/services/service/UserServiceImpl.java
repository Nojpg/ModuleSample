package services.service;

import domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    public User saveUser(User user) {
        logger.info("Added " + user);
        userRepository.save(user);
        return user;
    }

    public User takeUser(Long id) {
        User user = userRepository.findOne(id);
        logger.info("Took " + user);
        return user;
    }

    public List<User> takeAll() {
        List<User> users = (List<User>) userRepository.findAll();
        logger.info("Took " + users.toString());
        return users;
    }
}
