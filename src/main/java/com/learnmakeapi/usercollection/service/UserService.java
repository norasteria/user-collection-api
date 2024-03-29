package com.learnmakeapi.usercollection.service;

import com.learnmakeapi.usercollection.dto.UserDTO;
import com.learnmakeapi.usercollection.dto.UserResponseDTO;
import com.learnmakeapi.usercollection.model.User;
import java.util.List;
import java.util.UUID;

public interface UserService {
  UserDTO createUser(UserDTO userDTO);

  UserResponseDTO getAllUsers(int page, int size);

  UserDTO getUserById(UUID id);

  UserDTO updateUser(UUID id, UserDTO updatedUserDto);

  void deletePostById(UUID id);
}
