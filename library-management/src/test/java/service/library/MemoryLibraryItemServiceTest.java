package service.library;

import entity.libraryitem.Book;
import entity.libraryitem.LibraryItem;
import entity.libraryitem.LibraryItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoryLibraryItemServiceTest {

    private LibraryItemService libraryItemService;

    @BeforeEach
    void setUp() {
        this.libraryItemService = new MemoryLibraryItemService();
    }

    @Test
    void createLibraryItem() {
        LibraryItem book = new Book();
        book.setAuthor("Author");
        book.setName("Book Name");
        book.setDescription("Description");
        book.setQuantity(10);

        LibraryItem createdBook = libraryItemService.createLibraryItem(book);

        assertNotNull(createdBook);
        assertEquals("Author", createdBook.getAuthor());
        assertEquals("Book Name", createdBook.getName());
        assertEquals("Description", createdBook.getDescription());
        assertEquals(10, createdBook.getQuantity());
    }

    @Test
    void updateLibraryItem() {
        LibraryItem book = new Book();
        book.setAuthor("Author");
        book.setName("Book Name");
        book.setDescription("Description");
        book.setQuantity(10);

        LibraryItem createdBook = libraryItemService.createLibraryItem(book);
        createdBook.setAuthor("New Author");

        LibraryItem updatedBook = libraryItemService.updateLibraryItem(createdBook.getId(), createdBook);

        assertNotNull(updatedBook);
        assertEquals("New Author", updatedBook.getAuthor());
    }

    @Test
    void deleteLibraryItem() {
        LibraryItem book = new Book();
        book.setAuthor("Author");
        book.setName("Book Name");
        book.setDescription("Description");
        book.setQuantity(10);

        LibraryItem createdBook = libraryItemService.createLibraryItem(book);

        boolean isDeleted = libraryItemService.deleteLibraryItem(createdBook.getId());

        assertTrue(isDeleted);
    }

    @Test
    void reorderLibraryItem() {
        LibraryItem book = new Book();
        book.setAuthor("Author");
        book.setName("Book Name");
        book.setDescription("Description");
        book.setQuantity(10);

        LibraryItem createdBook = libraryItemService.createLibraryItem(book);

        LibraryItem reorderedBook = libraryItemService.reorderLibraryItem(createdBook.getId(), 5);

        assertNotNull(reorderedBook);
        assertEquals(15, reorderedBook.getQuantity());
    }
}
