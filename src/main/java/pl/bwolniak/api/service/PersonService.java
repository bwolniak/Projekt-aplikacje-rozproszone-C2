package pl.bwolniak.api.service;

import java.io.FileWriter;
import java.io.IOException;
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
    var person = Person.builder().firstName(request.getFirstName()).lastName(request.getLastName())
        .age(request.getAge())
        .build();
    var savedPerson = personRepository.save(person);
    savePersonToFile(savedPerson);
    return savedPerson;
  }

  private void savePersonToFile(Person person) {
    try (FileWriter writer = new FileWriter("persons.txt", true)) {
      writer.write(person.toString() + "\n");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
