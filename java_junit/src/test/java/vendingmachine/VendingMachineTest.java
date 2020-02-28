package vendingmachine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendingMachineTest {

    @Test
    void Test() {
        VendingMachine machine = new VendingMachine();
        machine.insertMoney(100);
        String item = machine.purchase("water");
        assertEquals("water", item);
    }

    @Test
    void case_failed_purchase() {
        VendingMachine machine = new VendingMachine();
        machine.insertMoney(50);
        String item = machine.purchase();
        assertEquals("", item);
    }

    @Test
    void case_reject_coin() {
        VendingMachine machine = new VendingMachine();
        machine.insertMoney(1);
        int change = machine.getChange();
        assertEquals(1, change);
    }

    @Test
    void case_succeeded_purchase() {
        VendingMachine machine = new VendingMachine();
        machine.insertMoney(50);
        machine.insertMoney(50);
        String item = machine.purchase();
        assertEquals("water", item);
    }

    @Test
    void case_succeeded_purchase_with_change() {
        VendingMachine machine = new VendingMachine();
        machine.insertMoney(50);
        machine.insertMoney(50);
        machine.insertMoney(50);
        String item = machine.purchase();
        assertEquals("water", item);
        int change = machine.getChange();
        assertEquals(50, change);
    }

    @Test
    void case_no_purchase_no_change() {
        VendingMachine machine = new VendingMachine();
        machine.insertMoney(50);
        machine.insertMoney(50);
        machine.insertMoney(50);
        int change = machine.getChange();
        assertEquals(0, change);
    }

    @Test
    void case_no_purchase_with_change_reject() {
        VendingMachine machine = new VendingMachine();
        machine.insertMoney(50);
        machine.insertMoney(50);
        machine.insertMoney(50);
        machine.insertMoney(1);
        int change = machine.getChange();
        assertEquals(1, change);
    }
    @Test
    void case_succeeded_twice_purchase() {
        // 150円入れて、水を買うと、50円お釣りが出る
        VendingMachine machine = new VendingMachine();
        machine.insertMoney(50);
        machine.insertMoney(50);
        machine.insertMoney(50);
        String item = machine.purchase();
        assertEquals("water", item);
        int change = machine.getChange();
        assertEquals(50, change);

        // 50円を入れても、買えない
        machine.insertMoney(50);
        item = machine.purchase();
        assertEquals("", item);
        change = machine.getChange();
        assertEquals(0, change);
    }

    @Test
    void Test_purchase_cola() {
        VendingMachine machine = new VendingMachine();
        machine.insertMoney(100);
        machine.insertMoney(10);
        machine.insertMoney(10);
        String item = machine.purchase("cola");
        assertEquals("cola", item);
    }
}
