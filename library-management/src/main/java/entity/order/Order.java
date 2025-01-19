package entity.order;

import entity.person.Person;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
public class Order {
    private int id;
    private int customerId;
    private Date createdAt;
    private Date startDate;
    private Date endDate;
    private final List<OrderEntry> borrowedItems = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
