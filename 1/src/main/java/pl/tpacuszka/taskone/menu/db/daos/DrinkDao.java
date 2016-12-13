package pl.tpacuszka.taskone.menu.db.daos;

import pl.tpacuszka.taskone.menu.db.models.Cuisine;
import pl.tpacuszka.taskone.menu.db.models.Drink;

import java.util.List;

/**
 * Handles db operations on Drink
 */
public interface DrinkDao {

    /**
     * Create new drink
     * @param drink
     * @return
     */
    Drink create(Drink drink);

    /**
     * Find drink by id
     * @param id
     * @return
     */
    Drink findById(long id);

    /**
     * Find drinks by cuisine
     * @param cuisine
     * @return
     */
    List<Drink> findByCuisine(Cuisine cuisine);
}
