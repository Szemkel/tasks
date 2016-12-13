package pl.tpacuszka.taskone.menu.db.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents meal from the menu
 */
@Entity
@Table(name = "drink")
final public class Drink implements MenuEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private float price;

    @ManyToOne
    @JoinColumn(name = "cuisine_id")
    private Cuisine cuisine;

    @OneToMany(mappedBy = "drink")
    private List<Addition> additions;

    public Drink() {
    }

    Drink(String name, float price) {
        this.name = name;
        this.price = price;
    }

    /**
     * {@inheritDoc}
     */
    public long getId() {
        return id;
    }

    /**
     * {@inheritDoc}
     */
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    public float getPrice() {
        return price;
    }

    /**
     * Get all available drink additions
     * @return
     */
    public List<Addition> getAdditions() {
        return additions;
    }
}
