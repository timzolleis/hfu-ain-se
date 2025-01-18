package presentation;

import entity.Book;
import entity.LibraryItem;
import entity.Magazine;
import service.library.LibraryItemService;
import utility.components.Selection;
import utility.components.TextInput;
import utility.form.Form;

import java.util.Map;

public class LibraryItemController {

    private static final String ID_FIELD = "id";
    private static final String AUTHOR_FIELD = "author";
    private static final String NAME_FIELD = "name";
    private static final String DESCRIPTION_FIELD = "description";
    private static final String QUANTITY_FIELD = "quantity";
    private static final String TYPE_FIELD = "type";

    private final LibraryItemService libraryItemService;

    public LibraryItemController(LibraryItemService libraryItemService) {
        this.libraryItemService = libraryItemService;
    }

    public void addLibraryItem() {
        final Form form = new Form();
        final Selection typeSelection = new Selection().setLabel("Type").setName(TYPE_FIELD).setOptions(new String[]{"Book", "Magazine"});
        final TextInput authorInput = new TextInput().setLabel("Author").setName(AUTHOR_FIELD);
        final TextInput nameInput = new TextInput().setLabel("Name").setName(NAME_FIELD);
        final TextInput descriptionInput = new TextInput().setLabel("Description").setName(DESCRIPTION_FIELD);
        final TextInput quantityInput = new TextInput().setLabel("Quantity").setName(QUANTITY_FIELD);
        form.addInput(typeSelection);
        form.addInput(authorInput);
        form.addInput(nameInput);
        form.addInput(descriptionInput);
        form.addInput(quantityInput);
        final Map<String, String> result = form.run();
        final LibraryItem libraryItem;
        if ("Book".equals(result.get(TYPE_FIELD))) {
            libraryItem = new Book();
        } else {
            libraryItem = new Magazine();
        }
        libraryItem.setAuthor(result.get(AUTHOR_FIELD));
        libraryItem.setName(result.get(NAME_FIELD));
        libraryItem.setDescription(result.get(DESCRIPTION_FIELD));
        libraryItem.setQuantity(Integer.parseInt(result.get(QUANTITY_FIELD)));
        this.libraryItemService.createLibraryItem(libraryItem);
    }

    public void editLibraryItem() {
        final Form form = new Form();
        final TextInput idInput = new TextInput().setLabel("ID").setName(ID_FIELD);
        final TextInput authorInput = new TextInput().setLabel("Author").setName(AUTHOR_FIELD);
        final TextInput nameInput = new TextInput().setLabel("Name").setName(NAME_FIELD);
        final TextInput descriptionInput = new TextInput().setLabel("Description").setName(DESCRIPTION_FIELD);
        final TextInput quantityInput = new TextInput().setLabel("Quantity").setName(QUANTITY_FIELD);
        form.addInput(idInput);
        form.addInput(authorInput);
        form.addInput(nameInput);
        form.addInput(descriptionInput);
        form.addInput(quantityInput);
        final Map<String, String> result = form.run();
        final LibraryItem libraryItem = this.libraryItemService.findLibraryItemById(Integer.parseInt(result.get(ID_FIELD))).orElseThrow(() -> new IllegalArgumentException("Library item not found"));
        libraryItem.setAuthor(result.get(AUTHOR_FIELD));
        libraryItem.setName(result.get(NAME_FIELD));
        libraryItem.setDescription(result.get(DESCRIPTION_FIELD));
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
