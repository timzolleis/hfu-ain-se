package entity.borrow;

import entity.libraryitem.LibraryItem;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BorrowedItem {
    private int customerId;
    private LibraryItem borrowedItem;
    private Date dueDate;
}
