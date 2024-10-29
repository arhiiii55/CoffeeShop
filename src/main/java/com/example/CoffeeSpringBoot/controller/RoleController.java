//package com.example.CoffeeSpringBoot.controller;
//import java.util.List;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.CoffeeSpringBoot.entity.Role;
//import com.example.CoffeeSpringBoot.service.UserService;
//
//@RestController
//public class RoleController {
//	
//	private UserService userService;
//	
//	@Autowired 
//	public RoleController(UserService userService, ModelMapper modelMapper) {
//		this.userService = userService;
//	};
//	 
////	@SuppressWarnings("unchecked")
//	@GetMapping("/Roles")
//    public ResponseEntity<?> getRole() {
//		List<Role> roles = userService.getAllRole();
//		if(!roles.isEmpty()) {
//	        return ResponseEntity.ok(roles);
//		}else {
//			return ResponseEntity.notFound().build();
//		}
//    }
//	    
//    @PostMapping("/Roles")
//    public ResponseEntity<?> createRole(@RequestBody Role role) {
//        Role roleNew = userService.testCreateRole(role);
//       
//        return ResponseEntity.ok(roleNew);
//    }
//    
//}
