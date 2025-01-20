package entity;

import entity.libraryitem.Book;

import java.util.Date;

public class BorrowedBook {
    private final Book book;
    private Date dueDate;

    public BorrowedBook(Book book, Date dueDate) {
        this.book = book;
        this.dueDate = dueDate;
    }

    public Book getBook() {
        return book;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Book: " + book + ", Due Date: " + dueDate;
    }
}