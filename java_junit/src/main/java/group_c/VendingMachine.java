package group_c;

public class VendingMachine {
    private final Balance balance = new Balance();
    private final DrinkStock drinkStock = new DrinkStock();

    public int getTotalMoney() {
        return this.balance.getValue();
    }

    public void addMoney(int value) {
        if (this.balance.isAddable(value)) return;
        this.balance.addMoney(value);
    }

    public int getReturnMoney() {
        int change = this.getTotalMoney();
        this.balance.reset();
        return change;
    }

    public String printDrinkCount() {
        return drinkStock.printDrinkCount2();
    }

    public void addDrink(Drink drink) {
        drinkStock.addDrink(drink);
    }

    public void purchase(Drink drink) {
        if (this.balance.getValue() >= drink.getValue()) {
            this.balance.debit(drink.getValue());
            drinkStock.remove(drink);
        }
    }

}
