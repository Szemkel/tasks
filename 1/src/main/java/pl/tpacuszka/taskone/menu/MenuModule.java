package pl.tpacuszka.taskone.menu;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.tpacuszka.taskone.menu.db.daos.*;
import pl.tpacuszka.taskone.menu.db.models.Meal;

public class MenuModule extends AbstractModule {

    protected void configure() {
        bind(CuisineDao.class).to(CuisineDaoImpl.class);
        bind(MenuService.class).to(MenuServiceImpl.class);
    }
}
