package pl.tpacuszka.taskone.cli;

import com.google.inject.Inject;
import org.hibernate.sql.ordering.antlr.OrderingSpecification;
import pl.tpacuszka.taskone.menu.MenuService;
import pl.tpacuszka.taskone.menu.db.models.*;
import pl.tpacuszka.taskone.ordering.OrderingService;
import pl.tpacuszka.taskone.ordering.db.models.Order;
import pl.tpacuszka.taskone.ordering.db.models.OrderEntry;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

final public class Start {

    private final static int DRINK_TYPE = 1;
    private final static int DISH_TYPE = 2;
    private MenuService menuService;
    private OrderingService orderingService;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Inject
    public Start(MenuService menuService, OrderingService orderingService) {
        this.menuService = menuService;
        this.orderingService = orderingService;
    }

    /**
     * Start ordering process
     */
    public void startOrdering() {
        System.out.println("Hello");
        Boolean isFinished = false;
        Order order = new Order(1);
        while (!isFinished) {
            try {
                isFinished = placeOrder(order);
            } catch (IOException e) {
                System.out.println("Error. Something went wrong");
            }
        }
    }

    /**
     * Place order
     * @param order
     * @return
     * @throws IOException
     */
    private Boolean placeOrder(Order order) throws IOException {
        Cuisine cuisine = selectCuisine();
        if (cuisine == null) {
            return finalizeOrder(order) ? true : placeOrder(order);
        }

        Integer mealType = selectMealType();
        if (mealType == null) {
            return finalizeOrder(order) ? true : placeOrder(order);
        }

        if (mealType == DRINK_TYPE) {
            Drink drink = selectDrink(cuisine);
            Addition addition = selectAddition(drink);
            OrderEntry drinkEntry = createOrderEntry(drink, order, addition);
            order.addEntry(drinkEntry);
        } else {
            OrderEntry mealEntry = createOrderEntry(selectMeal(cuisine), order);
            order.addEntry(mealEntry);
            OrderEntry dessertEntry = createOrderEntry(selectDessert(cuisine), order);
            order.addEntry(dessertEntry);
        }

        Boolean isFinished = finalizeOrder(order);
        if (isFinished) {
            orderingService.create(order);
            return true;
        }
        return false;
    }

    /**
     * Create order entry
     * @return
     */
    private OrderEntry createOrderEntry(MenuEntry menuEntry, Order order, Addition addition) {
        if (menuEntry == null) {
            return null;
        }

        OrderEntry.Builder builder = new OrderEntry.Builder(menuEntry, order);
        if (addition != null) {
            builder.withAddition(addition);
        }
        return builder.create();
    }

    /**
     * Create order without addition
     * @param menuEntry
     * @param order
     * @return
     */
    private OrderEntry createOrderEntry(MenuEntry menuEntry, Order order) {
        return createOrderEntry(menuEntry, order, null);
    }

    /**
     * Check if user want to finalize order
     * @return
     * @throws IOException
     * @param order
     */
    private Boolean finalizeOrder(Order order) throws IOException {
        System.out.println("Your order contains: ");
        List<OrderEntry> orderedEntries = order.getOrderedEntries();
        for (int i = 0; i < orderedEntries.size(); i++) {
            OrderEntry entry = orderedEntries.get(i);
            System.out.println(String.format("%d. %s \t %f", i+1, entry.getName(), entry.getPrice()));
        }

        System.out.println("Is it all?");
        System.out.println(String.format("%d. %s", 1, "Yes"));
        System.out.println(String.format("%d. %s", 2, "No"));

        return getInteger(2) == 1;
    }

    /**
     * Select type of the meal you want
     * @return
     */
    private Integer selectMealType() throws IOException {
        System.out.println("What do you want to order: ");
        System.out.println(String.format("%d. %s", DRINK_TYPE, "Drink"));
        System.out.println(String.format("%d. %s", DISH_TYPE, "Dish"));
        System.out.println("Insert corresponding number or # to finish: ");

        return getInteger(2);
    }

    /**
     * Select meal from given cuisine
     * @param cuisine
     */
    private Meal selectMeal(Cuisine cuisine) throws IOException {
        System.out.println("What do you want to order: ");
        List<Meal> meals = cuisine.getMeals();
        for (int i = 0; i < meals.size(); i++) {
            System.out.println(String.format("%d. %s", i + 1, meals.get(i).getName()));
        }
        System.out.println("Insert corresponding number or # to finish: ");

        Integer choice = getInteger(meals.size());
        return choice != null ? meals.get(choice - 1) : null;
    }

    /**
     * Select meal from given cuisine
     * @param cuisine
     */
    private Meal selectDessert(Cuisine cuisine) throws IOException {
        System.out.println("What do you want to order: ");
        List<Meal> desserts = cuisine.getDesserts();
        for (int i = 0; i < desserts.size(); i++) {
            System.out.println(String.format("%d. %s", i + 1, desserts.get(i).getName()));
        }
        System.out.println("Insert corresponding number or # to finish: ");

        Integer choice = getInteger(desserts.size());
        return choice != null ? desserts.get(choice - 1) : null;
    }

    /**
     * Select type of the meal you want
     * @return
     */
    private Drink selectDrink(Cuisine cuisine) throws IOException {
        System.out.println("What do you want to order: ");
        List<Drink> drinks = cuisine.getDrinks();
        for (int i = 0; i < drinks.size(); i++) {
            System.out.println(String.format("%d. %s", i + 1, drinks.get(i).getName()));
        }
        System.out.println("Insert corresponding number or # to finish: ");

        Integer choice = getInteger(drinks.size());
        return choice != null ? drinks.get(choice - 1) : null;
    }

    /**
     * Select addition to drink
     * @param drink
     * @return
     * @throws IOException
     */
    private Addition selectAddition(Drink drink) throws IOException {
        if (drink == null) {
            return null;
        }
        List<Addition> additions = drink.getAdditions();
        if (additions.size() < 1) {
            return null;
        }
        for (int i = 0; i < additions.size(); i++) {
            System.out.println(String.format("%d. %s", i + 1, additions.get(i).getName()));
        }
        System.out.println("Insert corresponding number or # to finish: ");

        Integer choice = getInteger(additions.size());
        return choice != null ? additions.get(choice - 1) : null;
    }

    /**
     * Break ordering process
     */
    private void breakOrdering() {
        System.out.println("See you soon");
    }

    /**
     * Select cuisine
     */
    private Cuisine selectCuisine() throws IOException {
        System.out.println("Which cuisine do you like: ");
        List<Cuisine> cuisines = menuService.getCuisines();
        for (int i = 0; i < cuisines.size(); i++) {
            String text = String.format("%d. %s", i + 1, cuisines.get(i).getName());
            System.out.println(text);
        }
        System.out.println("Insert corresponding number or # to finish: ");

        Integer choice = getInteger(cuisines.size());
        return choice != null ? cuisines.get(choice - 1) : null;
    }

    /**
     * Get Integer from cli
     * @return
     * @throws IOException
     */
    private Integer getInteger(int max) throws IOException {
        Integer number;
        do {
            String numberString = reader.readLine();
            if (numberString.charAt(0) == '#') {
                return null;
            }

            try {
                number = Integer.parseInt(numberString);
            } catch (NumberFormatException e) {
                System.out.println("Your input was not valid");
                continue;
            }

            if (number > max) {
                System.out.println("Your number was too big");
                continue;
            }

            if (number < 1) {
                System.out.println("Your number must be at least 1");
                continue;
            }
            return number;
        } while (true);
    }
}
