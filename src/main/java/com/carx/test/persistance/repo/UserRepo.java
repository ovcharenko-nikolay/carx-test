package com.carx.test.persistance.repo;

import com.carx.test.persistance.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepo extends CrudRepository<User, UUID> {

}
