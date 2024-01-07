/*
*  Creating design data for FE
* */

package com.learnmakeapi.usercollection.dto;

import java.util.UUID;
import lombok.Data;

@Data // for generating getter & setter
public class UserDTO {
private UUID id;

private  String firstName;

private String lastName;

private  int age;

private String ktpNumber;
}
