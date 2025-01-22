package presentation;

import entity.libraryitem.Book;
import entity.libraryitem.LibraryItem;
import entity.libraryitem.Magazine;
import service.library.LibraryItemService;
import utility.components.Selection;
import utility.components.TextInput;
import utility.form.Form;

import java.util.Map;

public class LibraryItemController {
    private final static String NAME_INPUT = "name";
    private final static String AUTHOR_INPUT = "author";
    private final static String TYPE_INPUT = "type";

    private final LibraryItemService libraryItemService;

    public LibraryItemController(final LibraryItemService libraryItemService) {
        this.libraryItemService = libraryItemService;
    }

    public void listItems() {
        this.libraryItemService.getLibraryItems().forEach(item -> {
            System.out.println("Item: " + item.getName());
            System.out.println("Quantity: " + item.getQuantity());
            System.out.println("Stock: " + item.getStock());
        });
    }

    public void addItem() {
        final Form form = new Form();
        final TextInput nameInput = new TextInput().setLabel("Name").setName(NAME_INPUT);
        final TextInput authorInput = new TextInput().setLabel("Author").setName(AUTHOR_INPUT);
        final Selection typeInput = new Selection().setLabel("Type").setName(TYPE_INPUT).setOptions(new String[]{"Book", "Magazine"});
        form.addInput(nameInput);
        form.addInput(authorInput);
        form.addInput(typeInput);
        final Map<String, String> result = form.run();
        final String name = result.get(NAME_INPUT);
        final String type = result.get(TYPE_INPUT);
        if (type.equals("Book")) {
            this.handleCreateBook(name);
        }
        if (type.equals("Magazine")) {
            this.handleCreateMagazine(name);
        }
    }

    private void handleCreateBook(final String name) {
        final Book book = new Book();
        book.setName(name);
        book.setQuantity(this.getRandomQuantity());
        final LibraryItem createdItem = this.libraryItemService.createLibraryItem(book);
        System.out.println("Added book: " + book.getName() + " with ID: " + createdItem.getId());
    }

    private void handleCreateMagazine(final String name) {
        final Magazine magazine = new Magazine();
        magazine.setName(name);
        magazine.setQuantity(this.getRandomQuantity());
        final LibraryItem createdItem = this.libraryItemService.createLibraryItem(magazine);
        System.out.println("Added magazine: " + magazine.getName() + " with ID: " + createdItem.getId()); ;
    }

    //Get random quantity between 50 and 100
    private Integer getRandomQuantity() {
        return (int) (Math.random() * 50 + 50);
    }

}
