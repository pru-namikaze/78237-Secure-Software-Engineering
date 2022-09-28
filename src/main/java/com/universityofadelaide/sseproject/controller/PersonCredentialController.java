package com.universityofadelaide.sseproject.controller;

import com.universityofadelaide.sseproject.controller.generic.GenericController;
import com.universityofadelaide.sseproject.model.Personcredential;
import com.universityofadelaide.sseproject.model.repository.PersonCredentialRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personCredential")
public class PersonCredentialController extends GenericController<Personcredential, PersonCredentialRepository> {
}
