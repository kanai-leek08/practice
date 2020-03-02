package group_c;

public class Stock {
    int count;
    private Drink drink;

    public Stock(Drink drink) {
        this.drink = drink;
    }

    void add(Drink target) {
        if (this.drink == target){
            count++;
        }
    }

    void remove(Drink target) {
        if (this.drink == target) {
            count--;
        }
    }

    public String getName() {
        return this.drink.getName();
    }

    String printStock() {
        return getName() + ": " + count;
    }
}