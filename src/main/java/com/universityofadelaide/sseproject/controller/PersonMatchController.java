package com.universityofadelaide.sseproject.controller;

import com.universityofadelaide.sseproject.controller.generic.GenericController;
import com.universityofadelaide.sseproject.model.Personmatch;
import com.universityofadelaide.sseproject.model.repository.PersonMatchRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personMatch")
public class PersonMatchController extends GenericController<Personmatch, PersonMatchRepository> {
}
