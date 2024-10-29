package com.example.CoffeeSpringBoot.service;

import com.example.CoffeeSpringBoot.entity.Role;
import com.example.CoffeeSpringBoot.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getAllUser();

    User getUserById(int id);
    
    User getUserByName(String name);

    User updateUserById(int id, User user);

    List<User> deleteUserById(int id);

    List<User> createUser(User user);

    User getUserByIdDTO(int id);
    
    Role getRoleById(int id);

    Role testCreateRole(Role role);
    
    List<Role> getAllRole();
    
    List<String> getAllEmail();
    
    Boolean isAdminUser(int id);
    
    List<String> getRoleNamesById(int id);
}
