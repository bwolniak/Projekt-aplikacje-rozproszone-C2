package pl.bwolniak.api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bwolniak.api.model.Person;
import pl.bwolniak.api.service.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {

  private PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @GetMapping
  public List<Person> getAllPersons() {
    return personService.getAllPersons();
  }

  @PostMapping
  public Person createPerson(@RequestBody Person person) {
    return personService.createPerson(person);
  }

}
