package pl.tpacuszka.taskone.menu.db.daos;

import pl.tpacuszka.taskone.menu.db.models.Cuisine;

import java.util.List;

/**
 * Handles db operations on Cuisine
 */
public interface CuisineDao {

    /**
     * Get all available Cuisine
     * @return
     */
    List<Cuisine> all();

    /**
     * Create new cuisine
     * @param cuisine
     * @return
     */
    Cuisine create(Cuisine cuisine);

    /**
     * Find cuisine by id
     * @param id
     * @return
     */
    Cuisine findById(long id);
}
