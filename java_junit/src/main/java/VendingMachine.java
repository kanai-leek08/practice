import java.util.*;

public class VendingMachine {

    private final Stock stock = new Stock();
    int totalDeposit = 0;
    List<Money> deposit = new ArrayList();
    private final Map<String, Integer> menus = new HashMap<>();

    public VendingMachine() {
        registerMenu("water", 100);
        registerMenu("tea", 120);
        registerMenu("richWater", 120);
        registerMenu("superRichWater", 150);
    }

    private void registerMenu(String name, int price) {
        menus.put(name, price);
        stock.items.put(name, 0);
    }

    public String provide(String orderDrinkName) {
        if (totalDeposit >= menus.get(orderDrinkName) && stock.exist(orderDrinkName)) {
            totalDeposit -= menus.get(orderDrinkName);
            stock.items.put(orderDrinkName, stock.decrement(orderDrinkName));
            return orderDrinkName;
        } else {
            return null;
        }
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
        stock.increment(drink);
    }

    public int getStock(String drink) {
        return stock.items.get(drink);
    }

    public void receive(Money money) {
        if (Arrays.asList(10, 50, 100, 500, 1000).contains(money.value)) {
            deposit.add(money);
            totalDeposit += money.value;
        }
    }
}
