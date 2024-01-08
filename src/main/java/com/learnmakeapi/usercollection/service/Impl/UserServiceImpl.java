/*
* The (logic) implementation of UserService
* */

package com.learnmakeapi.usercollection.service.Impl;

import com.learnmakeapi.usercollection.dto.UserDTO;
import com.learnmakeapi.usercollection.exception.UserNotFoundException;
import com.learnmakeapi.usercollection.model.User;
import com.learnmakeapi.usercollection.repository.UserRepository;
import com.learnmakeapi.usercollection.service.UserService;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDTO createUser(UserDTO userDTO) {
    // Convert to DTO data (from FE) to model/entity (for DB)
    User userModel = mapToUserModel(userDTO);
    User newUser = userRepository.save(userModel); // for saving to DB & save to `newUser` variable to return back to FE

    // Convert model/entity (data to give to DB) into DTO (data that will give to FE)
    UserDTO userResponse = mapToUserDto(newUser);
    return userResponse;
  }

  @Override
  public List<UserDTO> getAllUsers() {
    List<User> allUsers = userRepository.findAll(); // getting all users data from DB

    return allUsers.stream()
        .map(user -> mapToUserDto(user))
        .collect(Collectors.toList()); // get the stream result to list

  }

  @Override
  public UserDTO getUserById(UUID id) {
    User selectedUser = userRepository
        .findById(id)
        .orElseThrow(()-> new UserNotFoundException("User", "id", id)); // handle if got undefined user by given id
    return mapToUserDto(selectedUser);
  }

  private User mapToUserModel(UserDTO userDTO){
    User userModel = new User();
    userModel.setFirstName(userDTO.getFirstName());
    userModel.setLastName(userDTO.getLastName());
    userModel.setAge(userDTO.getAge());
    userModel.setKtpNumber(userDTO.getKtpNumber());

    return userModel;
  }

  private UserDTO mapToUserDto(User userModel){
    UserDTO userResponse = new UserDTO();
    userResponse.setId(userModel.getId());
    userResponse.setFirstName(userModel.getFirstName());
    userResponse.setLastName(userModel.getLastName());
    userResponse.setAge(userModel.getAge());
    userResponse.setKtpNumber(userModel.getKtpNumber());

    return userResponse;
  }

}
