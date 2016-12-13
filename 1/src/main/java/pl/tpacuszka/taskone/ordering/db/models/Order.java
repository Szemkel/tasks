package pl.tpacuszka.taskone.ordering.db.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents customer order
 */
@Entity
@Table(name = "placed_order")
final public class Order {

    public Order() {
    }

    public Order(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    /**
     * Id of order
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long id;

    /**
     * Menu entries ordered by client
     */
    @OneToMany(mappedBy = "order")
    private List<OrderEntry> orderedEntries = new ArrayList<OrderEntry>();

    /**
     * Table number where client sits
     */
    @Column(name = "table_number")
    private int tableNumber;

    /**
     * Get id of order
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     * Get list of ordered entries
     * @return
     */
    public List<OrderEntry> getOrderedEntries() {
        return orderedEntries;
    }

    /**
     * Add new entry to order
     * @param entry
     */
    public void addEntry(OrderEntry entry) {
        if (entry == null) {
            return;
        }
        orderedEntries.add(entry);
    }
}
