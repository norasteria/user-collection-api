/*
*
*  Creating repository as an interface for the related model/entity,
*  in this case, for UserRepository is interface for User model/entity
*
* */

package com.learnmakeapi.usercollection.repository;

import com.learnmakeapi.usercollection.model.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, UUID> {

}
