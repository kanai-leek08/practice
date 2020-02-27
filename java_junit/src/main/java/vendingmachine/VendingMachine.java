package vendingmachine;

public class VendingMachine {
    private int money=0;
    private int change=0;
    public void insertCoin(int money) {
        if (isUnacceptableMoney(money)){
            this.change = 1;
            return;
        }
        this.money += money;
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
        return this.change;
    }

    private boolean isUnacceptableMoney(int money) {
        return money == 1;
    }
}
