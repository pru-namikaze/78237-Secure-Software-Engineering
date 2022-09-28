package com.universityofadelaide.sseproject.model.repository;

import com.universityofadelaide.sseproject.model.Personcredential;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonCredentialRepository extends CrudRepository<Personcredential, Long> {
}
