package pl.tpacuszka.taskone.menu.db.models;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents cuisine
 */
@Entity
@Table(name = "cuisine")
final public class Cuisine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "cuisine")
    private List<Meal> meals;

    @OneToMany(mappedBy = "cuisine")
    private List<Drink> drinks;

    public Cuisine(String name) {
        this.name = name;
    }

    public Cuisine() {
    }

    /**
     * Id of cuisine
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     * Name of cuisine
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Get meals from this cuisine
     * @return
     */
    public List<Meal> getMeals() {
        return meals.stream().filter(meal -> meal.getType() == MealType.DISH).collect(Collectors.toList());
    }

    /**
     * Get drinks from this cuisine
     * @return
     */
    public List<Drink> getDrinks() {
        return drinks;
    }

    /**
     * Get desserts
     * @return
     */
    public List<Meal> getDesserts() {
        return meals.stream().filter(meal -> meal.getType() == MealType.DESSERT).collect(Collectors.toList());
    }
}
