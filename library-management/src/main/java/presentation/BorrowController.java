package presentation;

import entity.borrow.BorrowedItem;
import entity.libraryitem.LibraryItem;
import entity.person.Person;
import exception.OutOfStockException;
import service.borrow.BorrowService;
import service.library.LibraryItemService;
import service.person.PersonService;
import utility.components.Selection;
import utility.components.TextInput;
import utility.form.Form;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class BorrowController {
    private final BorrowService service;
    private final LibraryItemService libraryItemService;

    private final PersonService personService;
    private static final String SELECTED_ITEM_FIELD = "selectedItem";
    private static final String SELECTED_PERSON_FIELD = "selectedPerson";

    public BorrowController(final BorrowService service, final LibraryItemService libraryItemService, final PersonService personService) {
        this.service = service;
        this.libraryItemService = libraryItemService;
        this.personService = personService;
    }


    public void listItems() {
        final List<BorrowedItem> borrowedItems = this.service.getBorrowedItems();
        borrowedItems.forEach(item -> {
            System.out.println("Item: " + item.getBorrowedItem().getName());
            System.out.println("Due date: " + item.getDueDate());
        });
    }

    public void addItem() {
        final Form form = new Form();
        final List<LibraryItem> items = this.libraryItemService.getLibraryItems();
        final String[] itemNames = items.stream().map(LibraryItem::getName).toArray(String[]::new);
        final List<Person> persons = this.personService.listPersons();
        final String[] personNames = persons.stream().map(Person::getFirstName).toArray(String[]::new);
        final Selection selectedBookInput = new Selection()
                .setLabel("Select book")
                .setName(SELECTED_ITEM_FIELD)
                .setOptions(items.stream().map(LibraryItem::getName).toArray(String[]::new));
        final Selection selectedPersonInput = new Selection()
                .setLabel("Select person")
                .setName(SELECTED_PERSON_FIELD)
                .setOptions(personNames);
        form.addInput(selectedBookInput);
        form.addInput(selectedPersonInput);
        final Map<String, String> result = form.run();
        final Optional<LibraryItem> selectedItem = items.stream().filter(i -> i.getName().equals(result.get(SELECTED_ITEM_FIELD))).findFirst();
        final Optional<Person> selectedPerson = persons.stream().filter(p -> p.getFirstName().equals(result.get(SELECTED_PERSON_FIELD))).findFirst();
        try {
            selectedItem.ifPresent(libraryItem -> {
                final BorrowedItem borrowedItem = new BorrowedItem();
                borrowedItem.setBorrowedItem(libraryItem);
                selectedPerson.ifPresent(person -> borrowedItem.setCustomerId(person.getId()));
                this.service.addItem(borrowedItem);
            });
        } catch (OutOfStockException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void extendItem() {
        this.selectBorrowedItem().ifPresent(this.service::extendItem);
    }

    public void returnItem() {
        this.selectBorrowedItem().ifPresent(this.service::removeItem);
    }

    private Optional<BorrowedItem> selectBorrowedItem() {
        final List<BorrowedItem> borrowedItems = this.service.getBorrowedItems();
        final String[] borrowedItemNames = borrowedItems.stream().map(item -> item.getBorrowedItem().getName()).toArray(String[]::new);
        final Form form = new Form();
        final Selection selectedBook = new Selection()
                .setLabel("Select book")
                .setName(SELECTED_ITEM_FIELD)
                .setOptions(borrowedItemNames);
        form.addInput(selectedBook);
        final Map<String, String> result = form.run();
        return borrowedItems.stream().filter(i -> i.getBorrowedItem().getName().equals(result.get(SELECTED_ITEM_FIELD))).findFirst();
    }


}
