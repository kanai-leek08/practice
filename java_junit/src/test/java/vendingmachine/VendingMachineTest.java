package vendingmachine;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendingMachineTest {

    @Nested
    class CaseFailedPurchase {

        @Test
        void case_shortage_money() {
            VendingMachine machine = new VendingMachine();
            machine.insertMoney(50);
            String item = machine.purchase("water");
            assertEquals("", item);
        }

        @Test
        void case_shortage_money_after_succeeded_purchase() {
            // 150円入れて、水を買うと、50円お釣りが出る
            VendingMachine machine = new VendingMachine();
            machine.insertMoney(50);
            machine.insertMoney(50);
            machine.insertMoney(50);
            String item = machine.purchase("water");
            assertEquals("water", item);
            int change = machine.getChange();
            assertEquals(50, change);

            // 50円を入れても、買えない
            machine.insertMoney(50);
            item = machine.purchase("water");
            assertEquals("", item);
            change = machine.getChange();
            assertEquals(0, change);
        }

    }

    @Nested
    class CaseReject {
        @Test
        void case_unacceptable_type() {
            Arrays.asList(1, 5).forEach((money -> {
                VendingMachine machine = new VendingMachine();
                machine.insertMoney(money);
                int change = machine.getChange();
                assertEquals((int) money, change);
            }));
        }

        @Test
        void case_acceptable_unacceptable() {
            VendingMachine machine = new VendingMachine();
            machine.insertMoney(50);
            machine.insertMoney(50);
            machine.insertMoney(50);
            machine.insertMoney(1);
            int change = machine.getChange();
            assertEquals(1, change);
        }
    }

    @Nested
    class CaseSucceededPurchase {
        @Test
        void case_water() {
            VendingMachine machine = new VendingMachine();
            machine.insertMoney(100);
            String item = machine.purchase("water");
            assertEquals("water", item);
        }

        @Test
        void case_water_twice_insert_money() {
            VendingMachine machine = new VendingMachine();
            machine.insertMoney(50);
            machine.insertMoney(50);
            String item = machine.purchase("water");
            assertEquals("water", item);
        }

        @Test
        void case_water_change_exist() {
            VendingMachine machine = new VendingMachine();
            machine.insertMoney(50);
            machine.insertMoney(50);
            machine.insertMoney(50);
            String item = machine.purchase("water");
            assertEquals("water", item);
            int change = machine.getChange();
            assertEquals(50, change);
        }

        @Test
        void case_cola() {
            VendingMachine machine = new VendingMachine();
            machine.insertMoney(100);
            machine.insertMoney(10);
            machine.insertMoney(10);
            String item = machine.purchase("cola");
            assertEquals("cola", item);
        }
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


}
