package presentation;

import entity.LibraryItem;
import service.library.LibraryItemService;
import utility.components.TextInput;
import utility.form.Form;

import java.util.Map;

public class LibraryItemController {

    private static final String ID_FIELD = "id";
    private static final String AUTHOR_FIELD = "author";
    private static final String QUANTITY_FIELD = "quantity";

    private final LibraryItemService libraryItemService;

    public LibraryItemController(LibraryItemService libraryItemService) {
        this.libraryItemService = libraryItemService;
    }

    public void addLibraryItem() {
        final Form form = new Form();
        final TextInput authorInput = new TextInput().setLabel("Author").setName(AUTHOR_FIELD);
        final TextInput quantityInput = new TextInput().setLabel("Quantity").setName(QUANTITY_FIELD);
        form.addInput(authorInput);
        form.addInput(quantityInput);
        final Map<String, String> result = form.run();
        final LibraryItem libraryItem = new LibraryItem();
        libraryItem.setAuthor(result.get(AUTHOR_FIELD));
        libraryItem.setQuantity(Integer.parseInt(result.get(QUANTITY_FIELD)));
        this.libraryItemService.createLibraryItem(libraryItem);
    }

    public void editLibraryItem() {
        final Form form = new Form();
        final TextInput idInput = new TextInput().setLabel("ID").setName(ID_FIELD);
        final TextInput authorInput = new TextInput().setLabel("Author").setName(AUTHOR_FIELD);
        final TextInput quantityInput = new TextInput().setLabel("Quantity").setName(QUANTITY_FIELD);
        form.addInput(idInput);
        form.addInput(authorInput);
        form.addInput(quantityInput);
        final Map<String, String> result = form.run();
        final LibraryItem libraryItem = new LibraryItem();
        libraryItem.setId(Integer.parseInt(result.get(ID_FIELD)));
        libraryItem.setAuthor(result.get(AUTHOR_FIELD));
        libraryItem.setQuantity(Integer.parseInt(result.get(QUANTITY_FIELD)));
        this.libraryItemService.updateLibraryItem(libraryItem.getId(), libraryItem);
    }

    public void deleteLibraryItem() {
        final Form form = new Form();
        final TextInput idInput = new TextInput().setLabel("ID").setName(ID_FIELD);
        form.addInput(idInput);
        final Map<String, String> result = form.run();
        this.libraryItemService.deleteLibraryItem(Integer.parseInt(result.get(ID_FIELD)));
    }
}
