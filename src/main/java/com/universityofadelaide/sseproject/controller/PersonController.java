package com.universityofadelaide.sseproject.controller;

import com.universityofadelaide.sseproject.controller.generic.GenericController;
import com.universityofadelaide.sseproject.model.Person;
import com.universityofadelaide.sseproject.model.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController extends GenericController<Person, PersonRepository> {
}
