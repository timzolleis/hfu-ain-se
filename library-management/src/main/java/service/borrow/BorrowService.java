package service.borrow;

import entity.borrow.BorrowedItem;

import java.util.List;

public interface BorrowService {


    public void addItem(final BorrowedItem item);

    public void removeItem(final BorrowedItem item);

    public void extendItem(final BorrowedItem item);

    public List<BorrowedItem> getBorrowedItems();

}
