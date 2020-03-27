public class Money {
    int value;

    public Money(int value) {
        if (value == 120) {
            throw new RuntimeException("invalid money value");
        }
        this.value = value;
    }
}
