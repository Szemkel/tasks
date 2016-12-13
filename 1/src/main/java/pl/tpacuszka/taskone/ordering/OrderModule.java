package pl.tpacuszka.taskone.ordering;

import com.google.inject.AbstractModule;
import org.hibernate.sql.ordering.antlr.OrderingSpecification;
import pl.tpacuszka.taskone.ordering.db.daos.OrderDao;
import pl.tpacuszka.taskone.ordering.db.daos.OrderDaoImpl;
import pl.tpacuszka.taskone.ordering.db.daos.OrderEntryDao;
import pl.tpacuszka.taskone.ordering.db.daos.OrderEntryDaoImpl;

public class OrderModule extends AbstractModule {
    protected void configure() {
        bind(OrderDao.class).to(OrderDaoImpl.class);
        bind(OrderEntryDao.class).to(OrderEntryDaoImpl.class);
        bind(OrderingService.class).to(OrderingServiceImpl.class);
    }
}
