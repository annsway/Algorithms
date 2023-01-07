package OOD.RestaurantReservationSystem;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Meal> meals;
    private Table table;
    private Party party;

    public Order(Table table, Party party) {
        this.meals = new ArrayList<>();
        this.table = table;
        this.party = party;
    }

    public float getBill() {
        float bill = 0;
        for (Meal meal : meals) {
            bill += meal.getPrice();
        }
        return bill;
    }

    public void mergeOrder(Order order) {
        for (Meal meal : order.getMeals()) {
            meals.add(meal);
        }
    }

    public List<Meal> getMeals() {
        return this.meals;
    }
}
