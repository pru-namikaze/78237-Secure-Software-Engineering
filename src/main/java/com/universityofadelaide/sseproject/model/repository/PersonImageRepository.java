package com.universityofadelaide.sseproject.model.repository;

import com.universityofadelaide.sseproject.model.Personimage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonImageRepository extends CrudRepository<Personimage, Long> {
}
