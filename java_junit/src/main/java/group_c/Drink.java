package group_c;

public enum Drink {
    WATER("water", 100),
    COKE("coke", 120);

    private DrinkObject drink;

    Drink(String name, int value) {
        drink = new DrinkObject(name, value);
    }

    public String getName() {
        return drink.name;
    }

    public int getValue() {
        return drink.value;
    }
}