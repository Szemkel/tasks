package pl.tpacuszka.taskone.ordering.db.daos;

import com.google.inject.Inject;
import org.hibernate.SessionFactory;
import pl.tpacuszka.taskone.core.BasicDao;
import pl.tpacuszka.taskone.ordering.db.models.Order;
import pl.tpacuszka.taskone.ordering.db.models.OrderEntry;

import java.util.List;

/**
 * {@inheritDoc}
 */
final public class OrderEntryDaoImpl extends BasicDao implements OrderEntryDao {

    @Inject
    public OrderEntryDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    /**
     * {@inheritDoc}
     */
    public void create(OrderEntry orderEntry) {
        beginSessionAndTransaction();
        session.save(orderEntry);
        finalizeSessionAndTransaction();
    }

    /**
     * {@inheritDoc}
     */
    public OrderEntry findById(long id) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public List<OrderEntry> findByOrder(Order order) {
        return null;
    }
}
