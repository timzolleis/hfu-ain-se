package service.library;

import entity.LibraryItem;

public interface LibraryItemService {
    LibraryItem createLibraryItem(LibraryItem libraryItem);
    LibraryItem updateLibraryItem(int id, LibraryItem libraryItem);
    boolean deleteLibraryItem(int id);
    LibraryItem reorderLibraryItem(int id, int quantity);
}
