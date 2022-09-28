package com.universityofadelaide.sseproject.controller;

import com.universityofadelaide.sseproject.controller.generic.GenericController;
import com.universityofadelaide.sseproject.model.Personimage;
import com.universityofadelaide.sseproject.model.repository.PersonImageRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personImage")
public class PersonImageController extends GenericController<Personimage, PersonImageRepository> {
}
