package presentation;

import service.person.PersonService;
import utility.components.TextInput;
import utility.form.Form;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class PersonController {

    private final static String FIRST_NAME_INPUT = "firstName";
    private final static String LAST_NAME_INPUT = "lastName";
    private final static String AGE_INPUT = "age";
    private final PersonService personService;

    public PersonController(final PersonService personService) {
        this.personService = personService;
    }

    public void addPerson() {
        final Form form = new Form();
        final TextInput firstNameInput = new TextInput().setLabel("First name").setName(FIRST_NAME_INPUT);
        final TextInput lastNameInput = new TextInput().setLabel("Last name").setName(LAST_NAME_INPUT);
        final TextInput ageInput = new TextInput().setLabel("Age").setName(AGE_INPUT);
        form.addInput(firstNameInput);
        form.addInput(lastNameInput);
        form.addInput(ageInput);
        final Map<String, String> result = form.run();
        final Integer age = Integer.parseInt(result.get(AGE_INPUT));
        final Date birthDate = this.calculateDate(age);
        this.personService.createPerson(result.get(FIRST_NAME_INPUT), result.get(LAST_NAME_INPUT), birthDate);
    }

    private final Date calculateDate(final Integer age) {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -age);
        return calendar.getTime();
    }
}
