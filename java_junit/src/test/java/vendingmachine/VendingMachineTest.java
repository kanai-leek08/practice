package vendingmachine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendingMachineTest {

    @Test
    void Test() {
        VendingMachine machine = new VendingMachine();
        machine.insertCoin(100);
        String item = machine.purchase();
        assertEquals("water", item);
    }

    @Test
    void case_failed_purchase() {
        VendingMachine machine = new VendingMachine();
        machine.insertCoin(50);
        String item = machine.purchase();
        assertEquals("", item);
    }

    @Test
    void case_reject_coin() {
        VendingMachine machine = new VendingMachine();
        machine.insertCoin(1);
        int change = machine.getChange();
        assertEquals(1, change);
    }

    @Test
    void case_succeeded_purchase() {
        VendingMachine machine = new VendingMachine();
        machine.insertCoin(50);
        machine.insertCoin(50);
        String item = machine.purchase();
        assertEquals("water", item);
    }

    @Test
    void case_succeeded_purchase_with_change() {
        VendingMachine machine = new VendingMachine();
        machine.insertCoin(50);
        machine.insertCoin(50);
        machine.insertCoin(50);
        String item = machine.purchase();
        assertEquals("water", item);
        int change = machine.getChange();
        assertEquals(50, change);
    }
}
