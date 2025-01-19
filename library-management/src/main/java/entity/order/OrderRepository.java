package entity.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepository {


    private final Map<Integer, Order> orderMap = new HashMap<>();

    public final List<Order> listOrders() {
        return List.copyOf(orderMap.values());
    }

    public final Order createOrder(final Order order) {
        final int id = orderMap.size() + 1;
        order.setId(id);
        orderMap.put(id, order);
        return order;
    }

    public void updateOrder(final Order order) {
        orderMap.put(order.getId(), order);
    }

    public void deleteOrder(final Order order) {
        orderMap.remove(order.getId());
    }


}
