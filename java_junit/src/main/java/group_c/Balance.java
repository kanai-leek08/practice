package group_c;

public class Balance {
    int value;

    public Balance() {
    }

    public boolean isAddable(int money) {
        if (money == 1) {
            return true;
        }
        if (money == 5) {
            return true;
        }
        if (money == 5000) {
            return true;
        }
        if (money == 10000) {
            return true;
        }
        return false;
    }

    void addMoney(int money) {
        this.value = this.value + money;
    }

    public int getValue() {
        return this.value;
    }

    public void reset() {
        this.value = 0;
    }

    void debit(int value) {
        this.value = this.value - value;
    }
}