package pl.tpacuszka.taskone.ordering.db.daos;

import pl.tpacuszka.taskone.ordering.db.models.Order;
import pl.tpacuszka.taskone.ordering.db.models.OrderEntry;

import java.util.List;

/**
 * Handles db operations on OrderEntry
 */
public interface OrderEntryDao {

    /**
     * Creates new order entry
     * @param orderEntry
     * @return
     */
    void create(OrderEntry orderEntry);

    /**
     * Finds OrderEntry by id
     * @param id
     * @return
     */
    OrderEntry findById(long id);

    /**
     * Finds all OrderEntry by given order
     * @param order
     * @return
     */
    List<OrderEntry> findByOrder(Order order);
}
