import java.util.List;

public class VendingMachine {

    public static int receive(List<Integer> moneyList) {
        return moneyList.stream().mapToInt(money -> money).sum();
    }

    public String buy(int money, String order) {

        if (money >= getPrice(order)) {
            return order;
        }
        return null;
    }

    private int getPrice(String order) {
        if (order.equals("water")) {
            return 100;
        } else {
            return 120;
        }
    }

}
