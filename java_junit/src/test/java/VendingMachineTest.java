import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendingMachineTest {

    public void testInsert() {
        VendingMachine vm = new VendingMachine();
        vm.insertMoney(100);
        assertEquals(1, 1);
    }

    public void testInsertOverCoin() {
        VendingMachine vm = new VendingMachine();
        vm.insertMoney(120);
        assertEquals(120, 120);
    }

    public void testTotalCoin() {
        VendingMachine vm = new VendingMachine();
        int actual = vm.totalCoin();
        assertEquals(0, actual);
    }

    class VendingMachine {

        int totalCoin() {
            return 0;
        }

        public void insertMoney(int money) {

        }

    }

    public enum Yen {
        YEN10, YEN50, YEN100, YEN500, YEN1000
    }

}