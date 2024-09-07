package pl.bwolniak.api.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import pl.bwolniak.api.model.Person;
import pl.bwolniak.api.repository.PersonRepository;

@Service
public class PersonService {

  private final PersonRepository personRepository;

  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public List<Person> getAllPersons() {
    return personRepository.findAll().stream()
        .map(person -> new Person(person.getId(), person.getFirstName(), person.getLastName(), person.getAge()))
        .collect(
            Collectors.toList());
  }

  public Person createPerson(Person request) {
    var p = Person.builder().firstName(request.getFirstName()).lastName(request.getLastName()).age(request.getAge())
        .build();
    return personRepository.save(p);
  }

}
