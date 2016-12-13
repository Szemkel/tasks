package pl.tpacuszka.taskone.menu.db.daos;


import pl.tpacuszka.taskone.menu.db.models.Cuisine;
import pl.tpacuszka.taskone.menu.db.models.Meal;

import java.util.List;

/**
 * Handles db operations on Meal
 */
public interface MealDao {

    /**
     * Create new meal
     * @param meal
     * @return
     */
    void create(Meal meal);

    /**
     * Find meal by its id
     * @param id
     * @return
     */
    Meal findById(long id);

    /**
     * Find meal by Cuisine
     * @param cuisine
     * @return
     */
    List<Meal> findByCuisine(Cuisine cuisine);
}
