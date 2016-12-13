package pl.tpacuszka.taskone.ordering;

import com.google.inject.Inject;
import pl.tpacuszka.taskone.ordering.db.daos.OrderDao;
import pl.tpacuszka.taskone.ordering.db.daos.OrderEntryDao;
import pl.tpacuszka.taskone.ordering.db.models.Order;
import pl.tpacuszka.taskone.ordering.db.models.OrderEntry;

public class OrderingServiceImpl implements OrderingService {

    private OrderDao orderDao;
    private OrderEntryDao orderEntryDao;

    @Inject
    public OrderingServiceImpl(OrderDao orderDao, OrderEntryDao orderEntryDao) {
        this.orderDao = orderDao;
        this.orderEntryDao = orderEntryDao;
    }

    /**
     * {@inheritDoc}
     */
    public void create(Order order) {
        orderDao.create(order);
        for (OrderEntry entry : order.getOrderedEntries()) {
            orderEntryDao.create(entry);
        }
    }
}
