import java.util.HashMap;
import java.util.Map;

public class Stock {
    final Map<String, Integer> items = new HashMap<String, Integer>();

    public Stock() {
    }

    int decrement(String orderDrinkName) {
        return items.get(orderDrinkName) - 1;
    }

    boolean exist(String orderDrinkName) {
        return items.get(orderDrinkName) > 0;
    }

    void increment(String drink) {
        items.put(drink, items.get(drink) + 1);
    }
}