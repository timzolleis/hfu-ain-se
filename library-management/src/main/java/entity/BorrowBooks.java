package entity;

import entity.libraryitem.Book;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BorrowBooks {

    // Map mit ID als Schlüssel und BorrowedBook als Wert
    private final Map<Integer, BorrowedBook> BorrowedBooks = new HashMap<>();
    private int ID = 0;

    // Ablaufdatum berechnen (14 Tage ab heute)
    private Date validuntil() {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DATE, 14);
        return calendar.getTime();
    }

    // ID eines Buches ermitteln
    private int getID(Book book) {
        for (Map.Entry<Integer, BorrowedBook> entry : BorrowedBooks.entrySet()) {
            if (entry.getValue().getBook().equals(book)) {
                return entry.getKey();
            }
        }
        return -1; // Falls das Buch nicht gefunden wird
    }

    // Buch hinzufügen und Ablaufdatum zuweisen
    public void addBorrowedBook(final Book book) {
        ID++;
        Date dueDate = validuntil(); // Ablaufdatum berechnen
        BorrowedBooks.put(ID, new BorrowedBook(book, dueDate));
    }

    // Buch entfernen
    public void removeBorrowedBook(final Book book) {
        int bookID = getID(book);
        if (bookID != -1) {
            BorrowedBooks.remove(bookID);
        }
    }

    // Ablaufdatum verlängern (erneut 14 Tage)
    public void extendBorrowedBook(final Book book) {
        int bookID = getID(book);
        if (bookID != -1) {
            BorrowedBook borrowedBook = BorrowedBooks.get(bookID);
            borrowedBook.setDueDate(validuntil()); // Ablaufdatum aktualisieren
        }
    }

    // Alle ausgeliehenen Bücher zurückgeben
    public Map<Integer, BorrowedBook> getBorrowedBooks() {
        return new HashMap<>(BorrowedBooks); // Kopie der Map zurückgeben
    }
}