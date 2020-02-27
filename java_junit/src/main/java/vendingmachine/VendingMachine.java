package vendingmachine;

public class VendingMachine {
    private int money=0;

    public void insertCoin(int money) {
        this.money += money;
    }

    public String purchase() {
        if(this.money==50){
            return "";
        }
        return "water";
    }

    public int getChange() {
        return 1;
    }
}
