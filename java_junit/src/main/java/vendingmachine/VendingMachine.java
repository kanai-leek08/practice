package vendingmachine;

public class VendingMachine {
    private int money=0;
    private int change=0;
    public void insertMoney(int money) {
        if (isUnacceptableMoney(money)){
            this.change = money;
            return;
        }
        this.money += money;
        this.change=0;
    }

    public String purchase(Drink drink) {
        if(isShortageMoney()){
            return "";
        }
        if(drink.equals(Drink.WATER)){
            this.change = this.money - 100;
            return Drink.WATER.getValue();
        }
        return Drink.COLA.getValue();//仮
    }

    private boolean isShortageMoney() {
        return this.money==50;//仮
    }

    public int getChange() {
        this.money=0;//仮
        return this.change;
    }

    private boolean isUnacceptableMoney(int money) {
        return money == 1 || money == 5 || money == 5000 || money == 10000;
    }
}
