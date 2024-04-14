package net.userregistration.user.controller;

import net.userregistration.user.entities.User;
import net.userregistration.user.payload.ApiResponce;
import net.userregistration.user.repositories.UserRepository;
import net.userregistration.user.servieces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user/api")
public class UserController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    Create User (http://localhost:9092/user/api/created)
    @PostMapping("/created")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createUser = this.userService.createUser(user);
        return new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user,
                                           @PathVariable String userId){
        User updateUser = this.userService.updateUserById(user, userId);
        return new ResponseEntity<>(updateUser, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") String userId){
        User getUserById = this.userService.getUserById(userId);
        return new ResponseEntity<>(getUserById, HttpStatus.OK);

       /* Optional<User> user = userRepo.findById(userId);
        if(!user.isEmpty()) {
            Optional<String> userName = Optional.ofNullable(user.get().getUserName());
            return new ResponseEntity<>(userName.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Sorry User with given id is not present: ", HttpStatus.NOT_FOUND);
        }*/
    }

    @GetMapping("/allUser")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUsers = this.userService.getAllUser();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponce> deleteUserById(@PathVariable("userId") String userId){
        this.userService.deleteUserById(userId);
       return new ResponseEntity<>(new ApiResponce("User deleted successfully...!!", true), HttpStatus.OK);
    }
}
