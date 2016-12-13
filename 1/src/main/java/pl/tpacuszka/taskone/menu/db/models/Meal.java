package pl.tpacuszka.taskone.menu.db.models;

import javax.persistence.*;

/**
 * Represents meal from the menu
 */
@Entity
@Table(name = "meal")
final public class Meal implements MenuEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private float price;

    @Enumerated(EnumType.STRING)
    private MealType type;

    @ManyToOne
    @JoinColumn(name = "cuisine_id")
    private Cuisine cuisine;

    public Meal() {
    }

    Meal(String name, float price) {
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
     * Get meal type
     * @return
     */
    public MealType getType() {
        return type;
    }
}
