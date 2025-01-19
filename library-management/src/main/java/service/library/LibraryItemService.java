package service.library;

import entity.libraryitem.LibraryItem;

import java.util.Optional;

public interface LibraryItemService {
    LibraryItem findLibraryItemById(int id);

    LibraryItem createLibraryItem(LibraryItem libraryItem);

    LibraryItem updateLibraryItem(int id, LibraryItem libraryItem);

    boolean deleteLibraryItem(int id);

    LibraryItem reorderLibraryItem(int id, int quantity);
}
