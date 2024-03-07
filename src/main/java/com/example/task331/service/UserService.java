package com.example.task331.service;

import com.example.task331.model.User;
import com.example.task331.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public void addUser(User user) {
        userRepo.save(user);
    }

    public List<User> getUserList() {
        return (List<User>) userRepo.findAll();
    }

    public User getUserById(long id) throws Exception {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new Exception("User of ID: " +id+ " not found");
    }

    public void updateUserById(long id, String firstName, String lastName, String country) {
        Optional<User> optionalUser = userRepo.findById(id);
        User user = optionalUser.get();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setCountry(country);
        userRepo.save(user);
    }

    public void deleteUserById(long id) {
        userRepo.deleteById(id);
    }
}
