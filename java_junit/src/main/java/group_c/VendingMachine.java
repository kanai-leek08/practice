package group_c;

public class VendingMachine {
    private int money;
    private int waterCount;
    private int cokeCount;

    public int getTotalMoney() {
        return this.money;
    }

    public void addMoney(int money) {
        if (isAddable(money)) return;
        this.money += money;
    }

    private boolean isAddable(int money) {
        if (money == 1 ) {
            return true;
        }
        if (money == 5 ) {
            return true;
        }
        if (money == 5000 ) {
            return true;
        }
        if (money == 10000 ) {
            return true;
        }
        return false;
    }

    public int getReturnMoney() {
        return this.money;
    }

    public String printDrinkCount() {
        return "water: " + this.waterCount +", coke: " + this.cokeCount;
    }

    public void addDrink(String name) {
        if(name == "water") {
            waterCount++;
        } else{
            cokeCount++;
        }

    }
}
