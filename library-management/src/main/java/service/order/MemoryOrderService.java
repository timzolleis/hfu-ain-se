package service.order;

import entity.order.Order;
import entity.order.OrderEntry;
import entity.order.OrderRepository;

import java.util.Date;

public class MemoryOrderService implements OrderService {

    private final OrderRepository orderRepository;

    public MemoryOrderService(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(int customerId, Date startDate, Date endDate) {
        final Order order = new Order();
        order.setCreatedAt(new Date());
        order.setStartDate(startDate);
        order.setEndDate(endDate);
        order.setCustomerId(customerId);
        return this.orderRepository.createOrder(order);
    }


    @Override
    public void addItemToOrder(Order order, int libraryItemId) {
        final OrderEntry orderEntry = new OrderEntry();
        orderEntry.setLibraryItemId(libraryItemId);
        order.getBorrowedItems().add(orderEntry);
        //TODO: Implement the rest

    }

    @Override
    public void removeItemFromOrder(Order order, int libraryItemId) {
        //TODO: Implement that

    }

    @Override
    public void returnItemOnOrder(Order order, int libraryItemId) {
        //TODO: Implement that

    }
}
