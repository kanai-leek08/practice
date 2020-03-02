package group_b.vendingmachine;

public class VendingMachine {
    private int money=0;
    private int change=0;

    public void insertMoney(int money) {
        if (isUnacceptableMoney(money)){
            this.change = money;
            return;
        }
        this.money += money;
    }

    // 商品を買って、お釣りを出す(お釣りは取り出してない)
    public String purchase(Drink drink) {
        if(isShortageMoney(drink)){
            return "";
        }
        this.change += this.money - drink.getPrice();
        this.money=0;
        return drink.getValue();
    }

    private boolean isShortageMoney(Drink drink) {
        return this.money < drink.getPrice();
    }

    // お釣りを取り出す (お釣りを見るだけではない)
    public int getChange() {
        int returnChange = this.change;
        this.change = 0;
        return returnChange;
    }

    private boolean isUnacceptableMoney(int money) {
        return money == 1 || money == 5 || money == 5000 || money == 10000;
    }
}
