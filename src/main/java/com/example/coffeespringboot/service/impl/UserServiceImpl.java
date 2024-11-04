package com.example.coffeespringboot.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffeespringboot.constant.ConstantUtil;
import com.example.coffeespringboot.entity.Role;
import com.example.coffeespringboot.entity.User;
import com.example.coffeespringboot.repository.RoleRepo;
import com.example.coffeespringboot.repository.UserRepository;
import com.example.coffeespringboot.service.UserService;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private RoleRepo roleRepo;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepo roleRepo) {
		this.userRepository = userRepository;
		this.roleRepo = roleRepo;
	}
	/*
	 * Check user is admin 
	 * Check user is customer
	 * 
	 * */
	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(int id) {
		return userRepository.findById(id).stream().findFirst().orElse(null);
	}

	@Override
	public User updateUserById(int id, User user) {
		User userRepo = getUserById(id);
		if (userRepo != null) {
			userRepo = user;
			userRepository.save(userRepo);
		}
		return userRepo;
	}

	@Override
	@Transactional
	public List<User> deleteUserById(int id) {
		userRepository.deleteUserByIdUser(id);
		return getAllUser();
	}

	@Override
	public List<User> createUser(User user) {
		userRepository.save(user);
		return userRepository.findAll();
	}

	@Override
	public User getUserByIdDTO(int id) {
		return userRepository.findById(id).stream().findFirst().orElse(null);
	}

	@Override
	public Role getRoleById(int roleId) {
		Optional<Role> optRole = roleRepo.findById(roleId);
		Role role = null;
		if (optRole.isPresent()) {
			role = optRole.get();
			return role;
		} else {
			throw new RuntimeException("Did not find employee id - " + roleId);
		}
	}

	@Override
	public Role testCreateRole(Role role) {
		if (role.getRoleName() != null) {
			return roleRepo.save(role);
		} else {
			throw new NullPointerException();
		}
	}

	@Override
	public List<Role> getAllRole() {
		return roleRepo.findAll();
	}

	@Override
	public List<String> getAllEmail() {
		return userRepository.getallGmail();
	}

	@Override
	public User getUserByName(String name) {
		return userRepository.findUserByName(name);
	}
	
	@Override
	public Boolean isAdminUser(int id) {
		String roleName = userRepository.findRoleByid(id);
	    Pattern pattern = Pattern.compile(ConstantUtil.STAFF, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(roleName.trim());
	    boolean matchFound = matcher.find();
	    if(matchFound) {
	    	return true;
	    } else {
	    	return false;
	    }
	}
	
	@Override
	public List<String> getRoleNamesById(int id) {
		return userRepository.getAllRoleName(id);
	}
}
