package entity.order;

import lombok.Data;

import java.util.Date;

@Data
public class OrderEntry {
    private int libraryItemId;
    private Date returnedAt;


}
