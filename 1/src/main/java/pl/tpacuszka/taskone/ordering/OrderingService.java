package pl.tpacuszka.taskone.ordering;

import pl.tpacuszka.taskone.ordering.db.models.Order;

public interface OrderingService {

    void create(Order order);
}
