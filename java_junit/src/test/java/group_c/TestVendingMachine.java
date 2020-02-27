package group_c;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestVendingMachine {

    @Nested
    class getTotalMoney{
        @Test
        void getTotalMoney() {
            VendingMachine vendingMachine = new VendingMachine();
            assertEquals(0,vendingMachine.getTotalMoney());
        }

    }

    @Nested
    public class addMoney {
        @Test
        void addMoney_once() {
            VendingMachine vendingMachine = new VendingMachine();
            vendingMachine.addMoney(100);
            assertEquals(100, vendingMachine.getTotalMoney());
        }

        @Test
        void addMoney_twice() {
            VendingMachine vendingMachine = new VendingMachine();
            vendingMachine.addMoney(100);
            vendingMachine.addMoney(100);
            assertEquals(200, vendingMachine.getTotalMoney());
        }

        @Test
        void addMoney_BadPattern() {
            Arrays.asList(
                    1,
                    5,
                    5000,
                    10000
            ).forEach(testCase -> {
                VendingMachine vendingMachine = new VendingMachine();
                vendingMachine.addMoney(testCase);
                assertEquals(0, vendingMachine.getTotalMoney());
            });
        }
    }

    @Nested
    class getReturnMoney{
        @Test
        void getReturnMoney_once(){
            VendingMachine vendingMachine = new VendingMachine();
            vendingMachine.addMoney(100);
            assertEquals(100, vendingMachine.getReturnMoney());
        }

        @Test
        void getReturnMoney_twice(){
            VendingMachine vendingMachine = new VendingMachine();
            vendingMachine.addMoney(100);
            vendingMachine.addMoney(20);
            assertEquals(120, vendingMachine.getReturnMoney());
        }

    }

    @Nested
    class printDrinkCount{
        @Test
        void printDrinkCount()
        {
            VendingMachine vendingMachine = new VendingMachine();
            assertEquals("water: 0, coke: 0", vendingMachine.printDrinkCount());
        }
    }

    @Nested
    class addDrink {
        @Test
        void addDrinkPattern() {
            Arrays.asList(
                    new TestCase("TestCase: water add", "water", "water: 1, coke: 0"),
                    new TestCase("TestCase: coke add","coke", "water: 0, coke: 1")
            ).forEach(testCase -> {
                assertEquals(testCase.expected, testCase.please().printDrinkCount(), testCase.message);
            });
        }

        private class TestCase {
            private final String message;
            private final String expected;
            VendingMachine vendingMachine;
            public TestCase(String message, String drink, String expected) {
                this.message = message;
                this.expected = expected;
                vendingMachine = new VendingMachine();
                vendingMachine.addDrink(drink);
            }

            public VendingMachine please() {
                return this.vendingMachine;
            }
        }
    }

    @Test
    void purchase()
    {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addDrink("coke");
        vendingMachine.addMoney(100);
        vendingMachine.addMoney(10);
        vendingMachine.addMoney(10);
        vendingMachine.purchase("coke");
        assertEquals(0, vendingMachine.getReturnMoney());
        assertEquals("water: 0, coke: 0", vendingMachine.printDrinkCount());


    }
}
