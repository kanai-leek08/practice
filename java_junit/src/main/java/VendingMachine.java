import java.util.Arrays;

public class VendingMachine {

    int totalDeposit = 0;

    public void receive(int money) {
        if (Arrays.asList(10, 50, 100, 500, 1000).contains(money)) {
            totalDeposit += money;
        }
    }

    public String provide(String order) {
        if (totalDeposit >= getPrice(order)) {
            totalDeposit -= getPrice(order);
            return order;
        } else {
            return null;
        }
    }

    private int getPrice(String order) {
        return order.equals("water") ? 100 : 120;

    }

    public int displayTotalDeposit() {
        return totalDeposit;
    }

    public int returnChange() {
        int change = totalDeposit;
        totalDeposit = 0;
        return change;
    }
}
