import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VendingMachineTest {

    public void testInsert() {
        VendingMachine vm = new VendingMachine();
        vm.insertMoney(100);
        assertEquals(1, 1);
    }

    public void testInsertOverCoin() {
        assertEquals(120, 120);
    }

    public void testTotalCoin() {
        VendingMachine vm = new VendingMachine();
        int actual = vm.totalCoin();
        assertEquals(0, actual);
    }

    public void testInsertYen() {
        VendingMachine actual = new VendingMachine();
        assertTrue(actual.insertMoney(Yen.YEN10));


    }

    class VendingMachine {
        private int money;

        int totalCoin() {
            return 0;
        }

        public void insertMoney(int money) {

        }

        public boolean insertMoney(Yen yen) {
            return true;
        }

    }

    public enum Yen {
        YEN10, YEN50, YEN100, YEN500, YEN1000
    }

}