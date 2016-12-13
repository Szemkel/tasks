package pl.tpacuszka.taskone.menu.db.daos;

import com.google.inject.Inject;
import org.hibernate.SessionFactory;
import pl.tpacuszka.taskone.core.BasicDao;
import pl.tpacuszka.taskone.menu.db.models.Addition;
import pl.tpacuszka.taskone.menu.db.models.Cuisine;

import javax.persistence.Query;
import java.util.List;

/**
 * {@inheritDoc}
 */
final public class CuisineDaoImpl extends BasicDao implements CuisineDao {

    @Inject
    public CuisineDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    /**
     * {@inheritDoc}
     */
    public List<Cuisine> all() {
        openSession();
        Query query = session.createQuery("from Cuisine");
        List<Cuisine> cuisines = query.getResultList();
        closeSession();
        return cuisines;
    }

    /**
     * {@inheritDoc}
     */
    public Cuisine create(Cuisine cuisine) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public Cuisine findById(long id) {
        openSession();
        Cuisine cuisine = session.get(Cuisine.class, id);
        closeSession();
        return cuisine;
    }
}
