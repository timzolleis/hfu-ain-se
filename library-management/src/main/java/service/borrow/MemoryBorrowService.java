package service.borrow;

import entity.borrow.BorrowedItem;
import exception.OutOfStockException;

import java.util.*;

public class MemoryBorrowService implements BorrowService {
    private final Map<Integer, BorrowedItem> borrowedItems = new HashMap<>();

    private final Date calculateDueDate(final Date baseDate, final int daysToAdd) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(baseDate);
        calendar.add(Calendar.DATE, daysToAdd);
        return calendar.getTime();
    }

    private Optional<Integer> getId(final BorrowedItem item) {
        return this.borrowedItems.entrySet().stream()
                .filter(entry -> entry.getValue().equals(item))
                .map(Map.Entry::getKey)
                .findFirst();
    }

    @Override
    public void addItem(final BorrowedItem item) throws OutOfStockException {
        if (item.getBorrowedItem().getStock() == 0) {
            throw new OutOfStockException("Item is out of stock");
        }
        item.setDueDate(this.calculateDueDate(new Date(), 14));
        final int nextId = borrowedItems.size() + 1;
        this.borrowedItems.put(nextId, item);
        item.getBorrowedItem().setStock(item.getBorrowedItem().getStock() - 1);
    }

    @Override
    public void removeItem(final BorrowedItem item) {
        this.getId(item).ifPresent(this.borrowedItems::remove);
        item.getBorrowedItem().setStock(item.getBorrowedItem().getStock() + 1);
    }

    @Override
    public void extendItem(final BorrowedItem item) {
        this.getId(item).map(this.borrowedItems::get)
                .ifPresent(borrowedItem -> borrowedItem.setDueDate(this.calculateDueDate(borrowedItem.getDueDate(), 14)));

    }

    @Override
    public List<BorrowedItem> getBorrowedItems() {
        return List.copyOf(this.borrowedItems.values());
    }
}
