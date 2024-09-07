package pl.bwolniak.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bwolniak.api.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
