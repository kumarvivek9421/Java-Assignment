package net.userregistration.user.servieces.Impl;

import net.userregistration.user.entities.JournalEvent;
import net.userregistration.user.entities.User;
import net.userregistration.user.exception.ResourceNotFoundException;
import net.userregistration.user.repositories.UserRepository;
import net.userregistration.user.servieces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public User createUser(User user) {
        String randomId = UUID.randomUUID().toString();
        user.setUserId(randomId);
        return this.userRepo.save(user);
    }
    @Override
    public User updateUserById(User user, String userId) {
        User updateUser = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        updateUser.setUserName(user.getUserName());
        updateUser.setEmail(user.getEmail());
        return this.userRepo.save(updateUser);
    }
    @Override
    public User getUserById(String userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

//        fetch Event for the above user from JournalEvent
//        http://localhost:9091/event/api/460ff61e-8e6f-4802-aea0-96521aabe828

        JournalEvent forObject = restTemplate.getForObject("http://localhost:9091/event/api/460ff61e-8e6f-4802-aea0-96521aabe828" + user.getUserId(), JournalEvent.class);
        logger.info(String.valueOf(forObject));
        user.setEvents(forObject);

//        List<JournalEvent> collect = Arrays.stream(forObject).collect(Collectors.toList());
        return user;
    }
    @Override
    public List<User> getAllUser() {
            List<User> allUser = this.userRepo.findAll();
        return allUser;
    }
    @Override
    public void deleteUserById(String userId) {
        User deleteUser = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        this.userRepo.delete(deleteUser);
    }
}
