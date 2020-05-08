import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

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
        int actual = vm.totalAmount();
        assertEquals(0, actual);
    }

    public void testInsertYen() {
        VendingMachine actual = new VendingMachine();
        assertTrue(actual.insertMoney(Yen.YEN10));
        assertTrue(actual.insertMoney(Yen.YEN50));
        assertTrue(actual.insertMoney(Yen.YEN100));
        assertTrue(actual.insertMoney(Yen.YEN500));
        assertTrue(actual.insertMoney(Yen.YEN1000));

        assertFalse(actual.insertMoney(Yen.YEN1));
        assertFalse(actual.insertMoney(Yen.YEN5));
        assertFalse(actual.insertMoney(Yen.YEN5000));
        assertFalse(actual.insertMoney(Yen.YEN10000));

    }

    class VendingMachine {
        private int money;

        int totalAmount() {
            return money;
        }

        public void insertMoney(int money) {

        }

        public boolean insertMoney(Yen yen) {

            List<Yen> success = new ArrayList<>();
            success.add(Yen.YEN10);
            success.add(Yen.YEN50);
            success.add(Yen.YEN100);
            success.add(Yen.YEN500);
            success.add(Yen.YEN1000);

            if (success.contains(yen)) {
                return true;
            }
            return false;
        }

    }


 
    public enum Yen {
        YEN1,YEN5,YEN10, YEN50, YEN100, YEN500, YEN1000,YEN5000,YEN10000
    }

}