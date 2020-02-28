package vendingmachine;

public enum Drink {
    WATER("water"), COLA("cola");
    private String value;

    public String getValue() {
        return value;
    }

    Drink(String value) {
        this.value = value;
    }
}