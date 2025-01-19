package entity.libraryitem;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LibraryItemRepository {

    private final Map<Integer, LibraryItem> libraryItemMap = new HashMap<>();

    public LibraryItem createLibraryItem(LibraryItem libraryItem) {
        final int id = libraryItemMap.size() + 1;
        libraryItem.setId(id);
        libraryItemMap.put(id, libraryItem);
        return libraryItem;
    }

    public Optional<LibraryItem> findLibraryItemById(int id) {
        return Optional.ofNullable(libraryItemMap.get(id));
    }

    public LibraryItem updateLibraryItem(int id, LibraryItem libraryItem) {
        if (libraryItemMap.containsKey(id)) {
            libraryItem.setId(id);
            libraryItemMap.put(id, libraryItem);
            return libraryItem;
        }
        return null;
    }

    public boolean deleteLibraryItem(int id) {
        return libraryItemMap.remove(id) != null;
    }

    public LibraryItem reorderLibraryItem(int id, int quantity) {
        LibraryItem libraryItem = libraryItemMap.get(id);
        if (libraryItem != null) {
            libraryItem.setQuantity(libraryItem.getQuantity() + quantity);
            return libraryItem;
        }
        return null;
    }
}
