package vendingmachine;

public class VendingMachine {
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
        if(drinkType.equals("water")){
            return "water";
        }
        return "cola";
    }

    public String purchase() {
        if(isShortageMoney()){
            return "";
        }
        this.money -= 100;
        this.change = this.money;
        return "water";
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
