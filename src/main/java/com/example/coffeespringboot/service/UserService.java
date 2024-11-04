package com.example.coffeespringboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.coffeespringboot.entity.Role;
import com.example.coffeespringboot.entity.User;

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
