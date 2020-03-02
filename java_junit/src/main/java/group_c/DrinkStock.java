package group_c;

public class DrinkStock {
    final Stock cokeStock;
    final Stock waterStock;

    public DrinkStock() {
        this.cokeStock = new Stock(Drink.COKE);
        this.waterStock = new Stock(Drink.WATER);
    }

    void addDrink(Drink drink) {
        waterStock.add(drink);
        cokeStock.add(drink);
    }

    public void remove(Drink drink) {
        waterStock.remove(drink);
        cokeStock.remove(drink);
    }

    public String printDrinkCount2() {
        return waterStock.printStock() + ", " + cokeStock.printStock();
    }

}