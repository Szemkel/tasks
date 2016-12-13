package pl.tpacuszka.taskone.core;

import com.google.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Basic operations in every dao
 */
abstract public class BasicDao {

    private SessionFactory sessionFactory;
    protected Session session;
    private Transaction transaction;

    public BasicDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Open db session
     */
    protected void openSession() {
        session = sessionFactory.openSession();
    }

    /**
     * Begins session and transaction
     */
    protected void beginSessionAndTransaction() {
        openSession();
        transaction = session.beginTransaction();
    }

    /**
     * Finalizes session and transaction
     */
    protected void finalizeSessionAndTransaction() {
        transaction.commit();
        closeSession();
    }

    /**
     * Close db session
     */
    protected void closeSession() {
        if (null == session) {
            return;
        }
        session.close();
    }
}
