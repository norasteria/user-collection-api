package com.learnmakeapi.usercollection.dto;

import com.learnmakeapi.usercollection.model.User;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponseDTO {
  private List<UserDTO> content;
  private int page;
  private int size;
  private long totalItems;
  private int totalPages;
  private boolean last;

}
