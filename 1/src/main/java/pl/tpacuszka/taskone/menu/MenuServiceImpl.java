package pl.tpacuszka.taskone.menu;

import com.google.inject.Inject;
import pl.tpacuszka.taskone.menu.db.daos.AdditionDao;
import pl.tpacuszka.taskone.menu.db.daos.CuisineDao;
import pl.tpacuszka.taskone.menu.db.daos.DrinkDao;
import pl.tpacuszka.taskone.menu.db.daos.MealDao;
import pl.tpacuszka.taskone.menu.db.models.*;

import java.util.List;

/**
 * {@inheritDoc}
 */
public class MenuServiceImpl implements MenuService {

    private CuisineDao cuisineDao;

    @Inject
    public MenuServiceImpl(CuisineDao cuisineDao) {
        this.cuisineDao = cuisineDao;
    }

    /**
     * {@inheritDoc}
     */
    public List<Cuisine> getCuisines() {
        return cuisineDao.all();
    }
}
