package pl.tpacuszka.taskone.menu.db.models;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

/**
 * Represents addition for meal, drink or dessert
 */
@Entity
@Table(name = "addition")
final public class Addition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private float price;

    @ManyToOne
    @JoinColumn(name = "drink_id")
    private Drink drink;

    public Addition() {
    }

    /**
     * Get id of addition
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     * Get name of addition
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Get price of addition
     * @return
     */
    public float getPrice() {
        return price;
    }

    /**
     * Get menu entry to which addition belongs
     * @return
     */
    public Drink getDrink() {
        return drink;
    }
}
