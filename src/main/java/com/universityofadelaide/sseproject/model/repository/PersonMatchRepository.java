package com.universityofadelaide.sseproject.model.repository;

import com.universityofadelaide.sseproject.model.Personmatch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonMatchRepository extends CrudRepository<Personmatch, Long> {
}
