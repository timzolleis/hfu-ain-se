package service.person;

import entity.Person;
import entity.PersonRepository;
import exception.PersonNotFoundException;

import java.util.Date;
import java.util.List;

public class MemoryPersonService implements PersonService {

    private final PersonRepository personRepository;

    public MemoryPersonService(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void createPerson(final String firstName, final String lastName, final Date birthDate) {
        final Person personToCreate = new Person();
        personToCreate.setFirstName(firstName);
        personToCreate.setLastName(lastName);
        personToCreate.setBirthDate(birthDate);
        final Person createdPerson = this.personRepository.createPerson(personToCreate);
        System.out.println("Created person with id: " + createdPerson.getId());
    }

    @Override
    public final List<Person> listPersons() {
        return this.personRepository.listPersons();
    }

    @Override
    public Person findPersonById(int id) {
        return this.personRepository.findPersonById(id).orElseThrow(() -> new PersonNotFoundException("Person with id " + id + " not found"));
    }
}
