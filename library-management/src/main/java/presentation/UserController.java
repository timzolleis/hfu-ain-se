package presentation;

import service.UserService;
import utility.components.TextInput;
import utility.form.Form;

import java.util.Map;

public class UserController {

    private static final String USERNAME_FIELD = "username";
    private static final String PASSWORD_FIELD = "password";

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    public void createUser() {
        final Form form = new Form();
        final TextInput usernameInput = new TextInput().setLabel("Username").setName(USERNAME_FIELD);
        final TextInput passwordInput = new TextInput().setLabel("Password").setName(PASSWORD_FIELD);
        form.addInput(usernameInput);
        form.addInput(passwordInput);
        final Map<String, String> values = form.run();
        this.userService.addUser(values.get(USERNAME_FIELD), values.get(PASSWORD_FIELD));
    }


}
