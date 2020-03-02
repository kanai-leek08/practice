package group_c;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestVendingMachine {

    public int TEN = 10;
    public int HUNDRED = 100;
    public int THOUSAND = 1000;

    @Nested
    class getTotalBalance {
        @Test
        void getTotalMoney() {
            VendingMachine vendingMachine = new VendingMachine();
            assertEquals(0,vendingMachine.getTotalMoney());
        }

    }

    @Nested
    public class addBalance {
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
    class getReturnBalance {
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
                    new TestCase("TestCase: water add", Drink.WATER, "water: 1, coke: 0"),
                    new TestCase("TestCase: coke add",Drink.COKE, "water: 0, coke: 1")
            ).forEach(testCase -> {
                assertEquals(testCase.expected, testCase.please().printDrinkCount(), testCase.message);
            });
        }

        private class TestCase {
            private final String message;
            private final String expected;
            VendingMachine vendingMachine;
            public TestCase(String message, Drink drink, String expected) {
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

    @Nested
    class purchase{

        @Test
        void purchaseCoke()
        {
            VendingMachine vendingMachine = new VendingMachine();
            vendingMachine.addDrink(Drink.COKE);
            vendingMachine.addMoney(HUNDRED);
            vendingMachine.addMoney(TEN);
            vendingMachine.addMoney(TEN);
            vendingMachine.purchase(Drink.COKE);
            assertEquals(0, vendingMachine.getReturnMoney());
            assertEquals("water: 0, coke: 0", vendingMachine.printDrinkCount());
        }

        @Test
        void purchaseWater()
        {
            VendingMachine vendingMachine = new VendingMachine();
            vendingMachine.addDrink(Drink.WATER);
            vendingMachine.addMoney(HUNDRED);
            vendingMachine.purchase(Drink.WATER);
            assertEquals(0, vendingMachine.getReturnMoney());
            assertEquals("water: 0, coke: 0", vendingMachine.printDrinkCount());
        }

        @Test
        void purchaseReturnCheck()
        {
            VendingMachine vendingMachine = new VendingMachine();
            vendingMachine.addDrink(Drink.WATER);
            vendingMachine.addDrink(Drink.COKE);
            vendingMachine.addMoney(THOUSAND);
            vendingMachine.purchase(Drink.COKE);
            assertEquals(880, vendingMachine.getReturnMoney());
            assertEquals("water: 1, coke: 0", vendingMachine.printDrinkCount());
            assertEquals(0, vendingMachine.getReturnMoney());
        }
        @Test
        void purchase_CantBuyCoke()
        {
            VendingMachine vendingMachine = new VendingMachine();
            vendingMachine.addDrink(Drink.WATER);
            vendingMachine.addDrink(Drink.COKE);
            vendingMachine.addMoney(HUNDRED);
            vendingMachine.purchase(Drink.COKE);
            assertEquals(100, vendingMachine.getTotalMoney());
            assertEquals("water: 1, coke: 1", vendingMachine.printDrinkCount());
        }

        @Test
        void purchase_CantBuyWater()
        {
            VendingMachine vendingMachine = new VendingMachine();
            vendingMachine.addDrink(Drink.WATER);
            vendingMachine.addDrink(Drink.COKE);
            vendingMachine.addMoney(TEN);
            vendingMachine.purchase(Drink.WATER);
            assertEquals(10, vendingMachine.getTotalMoney());
            assertEquals("water: 1, coke: 1", vendingMachine.printDrinkCount());
        }

    }


}
