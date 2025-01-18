package entity;

import java.util.Date;
import java.util.Map;

public interface BorrowBooksInterface {
    void addBorrowedBook(Book book);
    void removeBorrowedBook(Book book);
    void extendBorrowedBook(Book book);
    Map <Integer, Date> getBorrowedBooks();
}
