package pl.tpacuszka.taskone.ordering.db.models;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import pl.tpacuszka.taskone.menu.db.models.Addition;
import pl.tpacuszka.taskone.menu.db.models.Drink;
import pl.tpacuszka.taskone.menu.db.models.Meal;
import pl.tpacuszka.taskone.menu.db.models.MenuEntry;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents order entry
 */
@Entity
@Table(name = "order_entry")
final public class OrderEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Any(metaColumn = @Column(name = "entryType"))
    @AnyMetaDef(idType = "long", metaType = "string",
            metaValues = {
            @MetaValue(targetEntity = Meal.class, value = "meal"),
            @MetaValue(targetEntity = Drink.class, value = "drink")
    })
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "entryId")
    private MenuEntry menuEntry;

    @ManyToMany
    @JoinTable(name = "order_entry_addition",
            joinColumns = @JoinColumn(name = "order_entry_id"),
            inverseJoinColumns = @JoinColumn(name = "addition_id")
    )
    private List<Addition> additions;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderEntry(MenuEntry menuEntry, Order order) {
        this.menuEntry = menuEntry;
        this.order = order;
    }

    /**
     * Get id of order entry
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     * Get name of the order
     * @return
     */
    public String getName() {
        return menuEntry.getName();
    }

    /**
     * Get order to which entry belongs
     * @return
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Get price for one dish in order entry
     * @return
     */
    public float getPrice() {
        return menuEntry.getPrice();
    }

    /**
     * Set order entry additions
     * @param additions
     */
    private void setAdditions(List<Addition> additions) {
        this.additions = additions;
    }

    /**
     * Create instance of OrderEntry
     */
    public static class Builder {
        private MenuEntry menuEntry;
        private List<Addition> additions = new ArrayList<Addition>();
        private Order order;

        public Builder(MenuEntry menuEntry, Order order) {
            this.menuEntry = menuEntry;
            this.order = order;
        }

        /**
         * Add addition to order entry
         * @param addition
         * @return
         */
        public Builder withAddition(Addition addition) {
            additions.add(addition);
            return this;
        }

        /**
         * Create new instance of order entry
         * @return
         */
        public OrderEntry create() {
            OrderEntry entry = new OrderEntry(menuEntry, order);
            entry.setAdditions(additions);
            return entry;
        }
    }
}
