package com.learnmakeapi.usercollection.cotroller;

import com.learnmakeapi.usercollection.dto.UserDTO;
import com.learnmakeapi.usercollection.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  // create new user
  @PostMapping
  public ResponseEntity<UserDTO> createUser(@RequestBody @NotNull @Valid UserDTO userDTO){
    return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);
  }

  // get all users
  @GetMapping
  public List<UserDTO> getAllUsers(){
    return userService.getAllUsers();
  }

  // get user by given id
  @GetMapping("/{id}")
  public  ResponseEntity<UserDTO> getUserById(@PathVariable(name = "id") UUID id){
    return ResponseEntity.ok(userService.getUserById(id));
  }
}
