package com.kenny.app.rest.Controller;

import com.kenny.app.rest.Model.User;
import com.kenny.app.rest.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {
@Autowired
    private UserRepo userRepo;
    @GetMapping("/")
    public String greet(){
        return "WELCOME!";
    }
    @GetMapping("getUsers")
    public List<User> getUsers(){
        return userRepo.findAll();
    }
@PostMapping("saveUser")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);
        return "saved...";
    }

    @PutMapping("updateUser/{id}")
    public String updateUser(@PathVariable long id , @RequestBody User user){
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setAge(user.getAge());
        updatedUser.setOccupation(user.getOccupation());
        userRepo.save(updatedUser);
        return "updated";
    }

    @DeleteMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable long id){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Deleted user with id : " + id;
    }
}
