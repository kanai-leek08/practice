package group_b.vendingmachine;

public enum Drink {
    WATER("water", 100), COLA("cola", 120);
    private String value;
    private int price;

    public String getValue() {
        return value;
    }

    Drink(String value, int price) {
        this.value = value;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}