package pl.tpacuszka.taskone.core;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppModule extends AbstractModule {

    protected void configure() {

    }

    @Provides
    SessionFactory provideDbSessionFactory() {
        return new Configuration()
                .configure()
                .buildSessionFactory();
    }
}
