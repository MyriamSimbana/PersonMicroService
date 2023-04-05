package com.example.demo.repository;

import com.example.demo.domain.jpa.StatusJpa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface StatusRepository extends CrudRepository<StatusJpa,Integer> {
}
