package pl.tpacuszka.taskone.menu.db.models;

public interface MenuEntry {

    /**
     * Get id of menu entry
     * @return
     */
    long getId();

    /**
     * Get name of menu entry
     * @return
     */
    String getName();

    /**
     * Get price of menu entry
     * @return
     */
    float getPrice();
}
