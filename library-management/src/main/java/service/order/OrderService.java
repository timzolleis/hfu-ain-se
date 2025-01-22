package service.order;

import entity.order.Order;

import java.util.Date;

public interface OrderService {
    public Order createOrder(final int customerId, final Date startDate, final Date endDate);

    public void addItemToOrder(final Order order, final int libraryItemId);

    public void removeItemFromOrder(final Order order, final int libraryItemId);

    public void returnItemOnOrder(final Order order, final int libraryItemId);


}
