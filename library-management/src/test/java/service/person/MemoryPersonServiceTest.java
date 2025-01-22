package service.person;

import entity.person.Person;
import entity.person.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryPersonServiceTest {

    private PersonService personService;

    @BeforeEach
    void setUp() {
        this.personService = new MemoryPersonService();
    }

    @Test
    void createPerson() {
        this.personService.createPerson("John", "Doe", null);
        final List<Person> persons = this.personService.listPersons();
        assertEquals(1, persons.size());
        final Person person = persons.getFirst();
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
    }

    @Test
    void listPersons() {
        this.personService.createPerson("John", "Doe", null);
        this.personService.createPerson("Jane", "Doe", null);
        final List<Person> persons = this.personService.listPersons();
        assertEquals(2, persons.size());
    }

    @Test
    void findPersonById() {
        this.personService.createPerson("John", "Doe", null);
        final List<Person> persons = this.personService.listPersons();
        final Person person = persons.getFirst();
        final Person foundPerson = this.personService.findPersonById(person.getId());
        assertEquals(person, foundPerson);
    }
}