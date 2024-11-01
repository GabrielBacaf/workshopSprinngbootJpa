package com.projectWebServices.project.resource;


import com.projectWebServices.project.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource  {


public ResponseEntity<User> findAll(){
    User u = new User(1L, "Maria", "maria@gmail.com", "999999", "12345");
    return ResponseEntity.ok().body(u);

}

}
