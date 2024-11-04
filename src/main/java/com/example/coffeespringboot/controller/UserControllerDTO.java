package com.example.coffeespringboot.controller;
// package com.example.CoffeeSpringBoot.controller;
//
// import com.example.CoffeeSpringBoot.dto.RoleDTO;
// import com.example.CoffeeSpringBoot.dto.UserDTO;
// import com.example.CoffeeSpringBoot.entity.Role;
// import com.example.CoffeeSpringBoot.entity.User;
// import com.example.CoffeeSpringBoot.service.UserService;
// import org.modelmapper.ModelMapper;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RestController;
//
// import java.util.ArrayList;
// import java.util.List;
//
// @RestController
// public class UserControllerDTO {
//
//     @Autowired
//     private UserService userService;
//
//     @Autowired
//     private ModelMapper modelMapper;
//
//     @GetMapping("/usersDTO")
//     public ResponseEntity<?> getAllUser() {
//         UserDTO userDTO = new UserDTO();
//         List<User> users = userService.getAllUserDTO();
//         if (users != null) {
//             System.out.println("not thinh at all");
//             UserDTO userRe = modelMapper.map(users, UserDTO.class);
//             return ResponseEntity.ok(userRe);
//         } else {
//             UserDTO userRe = modelMapper.map(users, UserDTO.class);
//             System.out.println("có null");
//             return ResponseEntity.ok(userRe);
//         }
//     }
//
//     @GetMapping("/usersDTO/{id}")
//     public ResponseEntity<?> getUserById(@PathVariable int id) {
//         User user = userService.getUserByIdDTO(id);
//         if (user != null) {
//             UserDTO userDTO = modelMapper.map(user, UserDTO.class);
//             return ResponseEntity.ok(userDTO);
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//
//     }
//
////     @GetMapping("/RoleDTO")
////     public ResponseEntity<?> getRoleDTO() {
////         List<Role> roles = userService.getRole();
////         List<RoleDTO> roleDTOS = new ArrayList<>();
////         for (Role role : roles) {
////             RoleDTO roleDTO = modelMapper.map(role, RoleDTO.class);
////             roleDTOS.add(roleDTO);
////         }
////         if (!roleDTOS.isEmpty()) {
////             return ResponseEntity.ok(roleDTOS);
////         } else {
////             return ResponseEntity.notFound().build();
////         }
////     }
//
//     @GetMapping("/RoleDTO/{id}")
//     public ResponseEntity<?> getByIdRoleDTO(@PathVariable int id) {
//         Role role = userService.getRoleById(id);
//         if (role != null) {
//             RoleDTO roleDTO = modelMapper.map(role, RoleDTO.class);
//             return ResponseEntity.ok(roleDTO);
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }
// }
