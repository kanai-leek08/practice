package vendingmachine;

public class VendingMachine {
    public static final String DRINK_TYPE_WATER = "water";
    public static final String DRINK_TYPE_COLA = "cola";
    private int money=0;
    private int change=0;
    public void insertMoney(int money) {
        if (isUnacceptableMoney(money)){
            this.change = 1;
            return;
        }
        this.money += money;
        this.change=0;
    }

    public String purchase(String drinkType) {
        if(isShortageMoney()){
            return "";
        }
        if(drinkType.equals(DRINK_TYPE_WATER)){
            this.change = 50;
            return DRINK_TYPE_WATER;
        }
        return DRINK_TYPE_COLA;
    }

    public String purchase() {
        if(isShortageMoney()){
            return "";
        }
        this.money -= 100;
        this.change = this.money;
        return DRINK_TYPE_WATER;
    }

    private boolean isShortageMoney() {
        return this.money==50;
    }

    public int getChange() {
        this.money=0;
        return this.change;
    }

    private boolean isUnacceptableMoney(int money) {
        return money == 1;
    }
}
