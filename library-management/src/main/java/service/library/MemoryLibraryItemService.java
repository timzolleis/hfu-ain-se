package service.library;

import entity.libraryitem.LibraryItem;
import entity.libraryitem.LibraryItemRepository;
import exception.LibraryItemNotFoundException;

import java.util.List;

public class MemoryLibraryItemService implements LibraryItemService {

    private final LibraryItemRepository libraryItemRepository;

    public MemoryLibraryItemService(LibraryItemRepository libraryItemRepository) {
        this.libraryItemRepository = libraryItemRepository;
    }

    @Override
    public LibraryItem findLibraryItemById(int id) {
        return libraryItemRepository.findLibraryItemById(id).orElseThrow(() -> new LibraryItemNotFoundException("Library item not found"));
    }

    @Override
    public LibraryItem createLibraryItem(LibraryItem libraryItem) {
        return libraryItemRepository.createLibraryItem(libraryItem);
    }

    @Override
    public LibraryItem updateLibraryItem(int id, LibraryItem libraryItem) {
        return libraryItemRepository.updateLibraryItem(id, libraryItem);
    }

    @Override
    public boolean deleteLibraryItem(int id) {
        return libraryItemRepository.deleteLibraryItem(id);
    }

    @Override
    public LibraryItem reorderLibraryItem(int id, int quantity) {
        return libraryItemRepository.reorderLibraryItem(id, quantity);
    }

    @Override
    public List<LibraryItem> getLibraryItems() {
        return libraryItemRepository.listLibraryItems();
    }
}
