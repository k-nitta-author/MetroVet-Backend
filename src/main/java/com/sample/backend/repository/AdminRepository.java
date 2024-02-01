package com.sample.backend.repository;

import com.sample.backend.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Integer> {

}
