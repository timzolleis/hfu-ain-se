package service.person;

import entity.person.Person;

import java.util.Date;
import java.util.List;

public interface PersonService {

    public void createPerson(final String firstName, final String lastName, final Date birthDate);

    public List<Person> listPersons();

    public Person findPersonById(final int id);

}
