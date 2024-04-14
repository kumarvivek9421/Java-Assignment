package net.userregistration.user.servieces;

import net.userregistration.user.entities.User;

import java.util.List;

public interface UserService {

//    Create User
    User createUser(User user);

//    Update User
    User updateUserById(User user, String userId);

//    Get Singel User
    User getUserById(String userId);

//    Get All User
    List<User> getAllUser();

//    Delete User
    void deleteUserById(String userId);

}
