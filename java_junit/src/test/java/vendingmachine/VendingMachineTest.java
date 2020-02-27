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

    @Test
    void case_no_purchase_no_change() {
        VendingMachine machine = new VendingMachine();
        machine.insertCoin(50);
        machine.insertCoin(50);
        machine.insertCoin(50);
        int change = machine.getChange();
        assertEquals(0, change);
    }

    @Test
    void case_no_purchase_with_change_reject() {
        VendingMachine machine = new VendingMachine();
        machine.insertCoin(50);
        machine.insertCoin(50);
        machine.insertCoin(50);
        machine.insertCoin(1);
        int change = machine.getChange();
        assertEquals(1, change);
    }
    @Test
    void case_succeeded_twice_purchase() {
        // 150円入れて、水を買うと、50円お釣りが出る
        VendingMachine machine = new VendingMachine();
        machine.insertCoin(50);
        machine.insertCoin(50);
        machine.insertCoin(50);
        String item = machine.purchase();
        assertEquals("water", item);
        int change = machine.getChange();
        assertEquals(50, change);

        // 50円を入れても、買えない
        machine.insertCoin(50);
        item = machine.purchase();
        assertEquals("", item);
        change = machine.getChange();
        assertEquals(0, change);
    }
}
