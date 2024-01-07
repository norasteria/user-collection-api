/*
*
* Model package is for mapping data from specific db table that defined from @Table annotation
*
*/

package com.learnmakeapi.usercollection.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // will generate getter setter constructor for all fields
@AllArgsConstructor
@NoArgsConstructor
@Entity  // as tag that
@Table(
    name="user", // name of the table
    schema="user_collection",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"ktp_number"})} // validate specific field to be unique
)
public class User {
  @Id
  @GeneratedValue(
      strategy = GenerationType.UUID // for generate UUID value
  )
  private UUID id;

  @NotNull
  @Column(name = "first_name")
  private String firstName;

  @Nullable
  @Column(name = "last_name")
  private String lastName;

  @NotNull
  private int age;

  @NotNull
  @Column(name = "ktp_number")
  private String ktpNumber;
}
