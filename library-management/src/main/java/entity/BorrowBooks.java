package entity;

import entity.libraryitem.Book;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BorrowBooks implements BorrowBooksInterface{

    private final Map<Integer, Date> BorrowedBooks = new HashMap<>();

    private Date validuntil(){
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DATE, 14);
        return calendar.getTime();
    }

    @Override
    public void addBorrowedBook(final Book book) {//hinzufügen
        Date validuntil = validuntil();
        BorrowedBooks.put(book.getId(), validuntil);
    }

    @Override
    public void removeBorrowedBook(final Book book) { //entfernen
        BorrowedBooks.remove(book.getId(),book);
    }

    @Override
    public void extendBorrowedBook(final Book book) { //verlängern
        BorrowedBooks.remove(book.getId(), book);
        Date validuntil = validuntil();
        BorrowedBooks.put(book.getId(), validuntil);
    }


    @Override
    public Map<Integer, Date> getBorrowedBooks() { //Liste der Bücher
        return Map.of();
    }
}
