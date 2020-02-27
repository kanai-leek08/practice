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
}
