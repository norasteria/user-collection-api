package com.learnmakeapi.usercollection.service;

import com.learnmakeapi.usercollection.dto.UserDTO;
import com.learnmakeapi.usercollection.model.User;
import java.util.List;
import java.util.UUID;

public interface UserService {
  UserDTO createUser(UserDTO userDTO);

  List<UserDTO> getAllUsers();

  UserDTO getUserById(UUID id);
}
