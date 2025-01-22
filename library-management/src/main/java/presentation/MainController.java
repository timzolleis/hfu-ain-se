package presentation;

import service.borrow.MemoryBorrowService;
import service.library.LibraryItemService;
import service.library.MemoryLibraryItemService;
import service.person.MemoryPersonService;
import service.person.PersonService;
import utility.components.TextInput;
import utility.form.Form;

import java.util.Map;

public class MainController {
    private LibraryItemService libraryItemService = new MemoryLibraryItemService();
    private LibraryItemController libraryItemController = new LibraryItemController(libraryItemService);
    private PersonService personService = new MemoryPersonService();
    private PersonController personController = new PersonController(personService);
    private BorrowController borrowController = new BorrowController(new MemoryBorrowService(), libraryItemService, personService);
    public void getcommand(){
        Form commandForm = new Form();
        TextInput commandInput = new TextInput().setLabel("command").setName("command");
        commandForm.addInput(commandInput);
        Map<String, String> result = commandForm.run();
        String command = result.get("command");
        handleCommand(command);
    }

    private void handleCommand(String command){
        switch(command){
            case "exit":
                System.exit(0);
                break;

            case "addbook":
                libraryItemController.addItem();
                break;

            case "getbook":
                libraryItemController.listItems();
                break;

            case "addperson":
                personController.addPerson();
                break;

            case "addborrowbook":
                borrowController.addItem();
                break;

            case "getborrowbook":
                borrowController.listItems();
                break;

            case "extendbook":
                borrowController.extendItem();
                break;

            case "returnbook":
                borrowController.returnItem();
                break;

            default:
                System.out.println("Invalid command");
                break;

        }
        getcommand();
    }
}
