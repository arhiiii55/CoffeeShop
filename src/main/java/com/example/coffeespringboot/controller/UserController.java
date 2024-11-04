package com.example.coffeespringboot.controller;

import java.util.ArrayList;
import java.util.List;
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

import com.example.coffeespringboot.dto.RoleDTO;
import com.example.coffeespringboot.dto.UserDTO;
import com.example.coffeespringboot.entity.Role;
import com.example.coffeespringboot.entity.User;
import com.example.coffeespringboot.service.UserService;

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
		List<User> userList = new ArrayList<>();
//		User user = modelMapper.map(userDTO, User.class);
		users.forEach(user -> {
			if (user.getAccountName().equals(userDTO.getAccountName())) {
	            System.out.println(userDTO.getAccountName() + "DTO đã tồn tại trong danh sách.");
	        }else if(user.getPhone() == (userDTO.getPhone())) {
	        	System.out.println(userDTO.getPhone() + "DTO đã tồn tại trong danh sách.");
	        }
			else {
	            System.out.println("defau");
	        }
		});	
		
//		users.forEach(u -> System.out.println(u));
		if(!userList.isEmpty()) 
			return ResponseEntity.status(HttpStatus.OK).body(userList);
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
