package com.learnmakeapi.usercollection.exception;

import java.util.UUID;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
  private String resourceName;
  private String fieldName;
  private UUID fieldValue;

  public UserNotFoundException(String resourceName, String fieldName, UUID fieldValue) {
    super(resourceName + " not found with " + fieldName+ ": "+ fieldValue);

    this.resourceName = resourceName;
    this.fieldName = fieldName;
    this.fieldValue = fieldValue;
  }
}
