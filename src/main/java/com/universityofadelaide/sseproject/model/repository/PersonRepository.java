package com.universityofadelaide.sseproject.model.repository;

import com.universityofadelaide.sseproject.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
