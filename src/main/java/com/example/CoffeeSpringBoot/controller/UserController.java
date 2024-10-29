package com.example.CoffeeSpringBoot.controller;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.CoffeeSpringBoot.dto.RoleDTO;
import com.example.CoffeeSpringBoot.dto.UserDTO;
import com.example.CoffeeSpringBoot.entity.Role;
import com.example.CoffeeSpringBoot.entity.User;
import com.example.CoffeeSpringBoot.service.UserService;

@Controller
@RequestMapping("/api/v1")
public class UserController {

	private UserService userService;
	private ModelMapper modelMapper;

	// Quick and dirty: inject employee Service (use constructor injection)
	@Autowired
	public UserController(UserService userService, ModelMapper modelMapper) {
		this.userService = userService;
		this.modelMapper = modelMapper;
	}

	@RequestMapping("/test-page2")
	public String admin(Model model) {
		List<String> gmails = userService.getAllEmail();
		model.addAttribute("allGmail", gmails);
		return "User-Page";
	}

	@PostMapping("/users")
	public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
		List<User> users = userService.getAllUser();
		users.forEach(u -> System.out.println(u));
//		for (User user : users) {
//			if (userDTO != null) {
//				if (!user.getAccountName().equals(userDTO.getAccountName()) && !user.getEmail().equals(userDTO.getEmail())
//						&&  (user.getPhone() != userDTO.getPhone())){
//					User userMap = modelMapper.map(userDTO, User.class);
//					List<User> userList = userService.createUser(userMap);
//					return ResponseEntity.status(HttpStatus.OK).body(userList);
//				}else {
//					return  ResponseEntity.badRequest().body("user is exist ");
//				}
//			}
//		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id) {
		List<User> users = userService.deleteUserById(id);
		return ResponseEntity.ok(users);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody User user) {
		if (id == user.getIdUser()) {
			User users = userService.updateUserById(id, user);
			if (users == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
			}
			return ResponseEntity.status(HttpStatus.OK).body(users);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID user not found!");
	}

	@GetMapping("/users/{name}")
	public ResponseEntity<?> getUserByName(@PathVariable String name) {

		User users = userService.getUserByName(name);
		if (users == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
		}
		System.out.println(users.getIdRole().getRoleName());

		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

	@GetMapping("/users-1")
	public ResponseEntity<?> getUsers() {
		List<User> users = userService.getAllUser();
		if (!users.isEmpty()) {
			List<UserDTO> usersDTO = users.stream().map(user -> modelMapper.map(user, UserDTO.class))
					.collect(Collectors.toList());
			return ResponseEntity.ok(usersDTO);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

//
//    -----------------------------------------------------return status response--------------------------------------------------
// 
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable int id) {
		User user = userService.getUserByIdDTO(id);
		if (user != null) {
			UserDTO userDTO = modelMapper.map(user, UserDTO.class);
			return ResponseEntity.ok(userDTO);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@GetMapping("/roles/{id}")
	public ResponseEntity<?> getRoleNameById(@PathVariable int id) {
		List<String> roles = userService.getRoleNamesById(id);
		System.out.println("oki " + userService.isAdminUser(id));
		return ResponseEntity.ok(roles);
	}

	@GetMapping("/RoleDTO/{id}")
	public ResponseEntity<?> getByIdRoleDTO(@PathVariable int id) {
		Role role = userService.getRoleById(id);
		if (role != null) {
			RoleDTO roleDTO = modelMapper.map(role, RoleDTO.class);
			return ResponseEntity.ok(roleDTO);
		} else {
			// throw view 404 not found
			return ResponseEntity.notFound().build();
		}
	}

}
