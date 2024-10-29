package com.example.CoffeeSpringBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.CoffeeSpringBoot.entity.User;

import lombok.experimental.PackagePrivate;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    void deleteUserByIdUser(int id);
    
    @Query("select email from User")
    List<String> getallGmail();
    
  // Native Query
    @Query( value  = "select distinct * from coffeedb.user ue where ue.user_name = :name " , nativeQuery = true)
    User findUserByName(@Param("name") String name);
    
    @Query(value  = "SELECT user.user_name FROM user INNER JOIN role ON user.role = role.id_role WHERE role.id_role = :id" , nativeQuery = true)
    List<String> getAllRoleName(@Param("id") int id);
    
    @Query("SELECT r.roleName FROM Role r WHERE r.idRole = :id" )
    String findRoleByid(@Param("id") int id);
}
