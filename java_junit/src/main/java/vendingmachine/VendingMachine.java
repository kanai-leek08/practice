package vendingmachine;

public class VendingMachine {
    private int money=0;
    private int change=0;
    public void insertCoin(int money) {
        if (money == 1){
            this.change = 1;
            return;
        }
        this.money += money;
    }

    public String purchase() {
        if(this.money==50){
            return "";
        }
        this.money -= 100;
        this.change = this.money;
        return "water";
    }

    public int getChange() {
        if(this.money==150){
            return this.change;
        }
        return this.change;
    }
}
