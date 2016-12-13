package pl.tpacuszka.taskone.menu;

import pl.tpacuszka.taskone.menu.db.models.*;

import java.util.List;

/**
 * Represents menu operations
 */
public interface MenuService {

    /**
     * Get all available cuisines
     * @return
     */
    List<Cuisine> getCuisines();

}
