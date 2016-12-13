package pl.tpacuszka.taskone.ordering.db.daos;

import com.google.inject.Inject;
import org.hibernate.SessionFactory;
import pl.tpacuszka.taskone.core.BasicDao;
import pl.tpacuszka.taskone.ordering.db.models.Order;

/**
 * OrderDao implementation that uses mysql as db
 */
final public class OrderDaoImpl extends BasicDao implements OrderDao {

    @Inject
    public OrderDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    /**
     * {@inheritDoc}
     */
    public void create(Order order) {
        beginSessionAndTransaction();
        session.save(order);
        finalizeSessionAndTransaction();
    }

    /**
     * {@inheritDoc}
     */
    public Order findById(long id) {
        return null;
    }
}
