package com.learnmakeapi.usercollection.service;

import com.learnmakeapi.usercollection.dto.UserDTO;
import com.learnmakeapi.usercollection.model.User;
import java.util.List;

public interface UserService {
  UserDTO createUser(UserDTO userDTO);

  List<UserDTO> getAllUsers();
}
