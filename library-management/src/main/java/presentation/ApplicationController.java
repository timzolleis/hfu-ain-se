package presentation;

import entity.libraryitem.LibraryItemRepository;
import entity.person.PersonRepository;
import entity.user.UserRepository;
import service.borrow.BorrowService;
import service.borrow.MemoryBorrowService;
import service.library.LibraryItemService;
import service.library.MemoryLibraryItemService;
import service.person.MemoryPersonService;
import service.person.PersonService;
import service.user.MemoryUserService;
import service.user.UserService;
import utility.components.TextInput;
import utility.form.Form;

import java.util.Map;

public class ApplicationController {


    private final BorrowController borrowController;
    private final PersonController personController;
    private final UserController userController;
    private final LibraryItemController libraryItemController;

    //Services
    private final PersonService personService = new MemoryPersonService(new PersonRepository());
    private final LibraryItemService libraryItemService = new MemoryLibraryItemService(new LibraryItemRepository());
    private final BorrowService borrowService = new MemoryBorrowService();
    private final UserService userService = new MemoryUserService();


    public ApplicationController() {
        this.borrowController = new BorrowController(borrowService, libraryItemService, personService);
        this.personController = new PersonController(personService);
        this.userController = new UserController(userService);
        this.libraryItemController = new LibraryItemController(libraryItemService);
    }

    public void start() {
        final Form form = new Form();
        final TextInput input = new TextInput().setLabel("Command").setName("command");
        form.addInput(input);
        final Map<String, String> result = form.run();
        final String command = result.get("command");
        if (!command.equals("exit")) {
            handleCommand(command);
            this.start();
        }
        System.out.println("See ya, cowboy!");
    }

    private void handleCommand(final String command) {
        switch (command) {
            case "borrow": {
                this.borrowController.addItem();
                break;
            }
            case "extend": {
                this.borrowController.extendItem();
                break;
            }
            case "return": {
                this.borrowController.returnItem();
                break;
            }
            case "listBorrowedItems": {
                this.borrowController.listItems();
                break;
            }
            case "listItems": {
                this.libraryItemController.listItems();
                break;
            }
            case "addItem": {
                this.libraryItemController.addItem();
                break;
            }
            case "addPerson": {
                this.personController.addPerson();
                break;
            }
            case "addUser": {
                this.userController.createUser();
                break;
            }
            default:
                System.out.println("Unknown command: " + command);
        }
    }

}
