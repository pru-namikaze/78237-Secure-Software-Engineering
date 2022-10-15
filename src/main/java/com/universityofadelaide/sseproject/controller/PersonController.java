package com.universityofadelaide.sseproject.controller;

import com.universityofadelaide.sseproject.controller.generic.GenericController;
import com.universityofadelaide.sseproject.model.Person;
import com.universityofadelaide.sseproject.model.repository.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/person")
@Controller
public class PersonController extends GenericController<Person, PersonRepository> {
  @RequestMapping("/profile")
  public ModelAndView getProfile(){
    return new ModelAndView("profile.html");
  }
}
