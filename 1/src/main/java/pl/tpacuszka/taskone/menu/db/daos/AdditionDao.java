package pl.tpacuszka.taskone.menu.db.daos;

import pl.tpacuszka.taskone.menu.db.models.Addition;
import pl.tpacuszka.taskone.menu.db.models.Drink;
import pl.tpacuszka.taskone.menu.db.models.MenuEntry;

import java.util.List;

/**
 * Handles operations on Additions in db
 */
public interface AdditionDao {

    /**
     * Create new addition
     * @param addition
     * @return
     */
    void create(Addition addition);

    /**
     * Find addition by its id
     * @param id
     * @return
     */
    Addition findById(long id);

    /**
     * Find additions by MenuEntry
     * @param menuEntry
     * @return
     */
    List<Addition> findByDrink(Drink drink);
}
