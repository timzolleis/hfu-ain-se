package entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PersonRepository {

    private final Map<Integer, Person> personMap = new HashMap<>();

    public final Person createPerson(final Person person) {
        final int id = personMap.size() + 1;
        person.setId(id);
        personMap.put(id, person);
        return person;
    }

    public final Optional<Person> findPersonById(final int id) {
        return Optional.ofNullable(personMap.get(id));
    }

    public final List<Person> listPersons() {
        return List.copyOf(personMap.values());
    }

}
