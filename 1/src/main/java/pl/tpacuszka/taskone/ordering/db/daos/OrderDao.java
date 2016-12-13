package pl.tpacuszka.taskone.ordering.db.daos;

import pl.tpacuszka.taskone.ordering.db.models.Order;

/**
 * Handles db operations on Order
 */
public interface OrderDao {
    void create(Order order);
    Order findById(long id);
}
