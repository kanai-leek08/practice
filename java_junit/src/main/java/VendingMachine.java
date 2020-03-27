import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    int totalDeposit = 0;
    private final Map<String, Integer> drink = new HashMap<>();
    private final Map<String, Integer> stock = new HashMap<>();

    public VendingMachine() {
        registerMenu("water",100);
        registerMenu("tea",120);
        registerMenu("richWater",120);
        registerMenu("superRichWater",150);
    }

    private void registerMenu(String name, int price) {
        drink.put(name,price);
        stock.put(name,0);
    }

    public void receive(int money) {
        if (Arrays.asList(10, 50, 100, 500, 1000).contains(money)) {
            totalDeposit += money;
        }
    }

    public String provide(String order) {
        if (totalDeposit >= getPrice(order) && stock.get(order) > 0) {
            totalDeposit -= getPrice(order);
            stock.put(order, stock.get(order) - 1);
            return order;
        } else {
            return null;
        }
    }

    private int getPrice(String order) {
        return drink.get(order);
    }

    public int displayTotalDeposit() {
        return totalDeposit;
    }

    public int returnChange() {
        int change = totalDeposit;
        totalDeposit = 0;
        return change;
    }

    public void stock(String drink) {
        stock.put(drink, stock.get(drink) + 1);
    }

    public int getStock(String drink) {
        return stock.get(drink);
    }
}
