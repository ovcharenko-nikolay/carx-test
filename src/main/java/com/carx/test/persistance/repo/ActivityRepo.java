package com.carx.test.persistance.repo;

import com.carx.test.persistance.model.Activity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ActivityRepo extends CrudRepository<Activity, UUID> {

}
