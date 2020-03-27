import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class VendingMachineTest {

    static Stream<Arguments> buyPatterns() {
        return Stream.of(
                arguments("water: can buy with same price", Arrays.asList("water"), Arrays.asList(100), "water", "water"),
                arguments("water: can buy with over price", Arrays.asList("water"), Arrays.asList(100, 10, 10), "water", "water"),
                arguments("rich water: can buy with same price", Arrays.asList("richWater"), Arrays.asList(100, 10, 10), "richWater", "richWater"),
                arguments("", Arrays.asList("tea"), Arrays.asList(100, 10, 10), "tea", "tea"),
                arguments("", Arrays.asList("superRichWater"), Arrays.asList(100, 50), "superRichWater", "superRichWater"),
                arguments("", Arrays.asList("tea"), Arrays.asList(100), "tea", null),
                arguments("", Arrays.asList(), Arrays.asList(1000), "tea", null),
                arguments("", Arrays.asList("tea"), Arrays.asList(1000), "water", null)
        );
    }

    @ParameterizedTest
    @MethodSource("buyPatterns")
    public void buy(String description, List<String> stockList, List<Integer> depositList, String order, String expected) {
        //given
        VendingMachine vendingMachine = new VendingMachine();
        stockList.forEach(vendingMachine::stock);
        depositList.forEach(money -> { vendingMachine.receive(new Money(money)); });
        //when
        String drink = vendingMachine.provide(order);
        //then
        assertEquals(expected, drink, description);
    }

    static Stream<Arguments> paymentPatterns() {
        return Stream.of(
                arguments(Arrays.asList(1), 0),
                arguments(Arrays.asList(5), 0),
                arguments(Arrays.asList(5000), 0),
                arguments(Arrays.asList(10000), 0),
                arguments(Arrays.asList(100), 100),
                arguments(Arrays.asList(500), 500),
                arguments(Arrays.asList(1000), 1000),
                arguments(Arrays.asList(10, 100), 110),
                arguments(Arrays.asList(1, 100), 100),
                arguments(Arrays.asList(1, 5000), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("paymentPatterns")
    public void received(List<Integer> depositList, int expected) {
        VendingMachine vendingMachine = new VendingMachine();
        //when
        depositList.forEach(money -> { vendingMachine.receive(new Money(money)); });
        //then
        assertEquals(expected, vendingMachine.totalDeposit);
        assertEquals(expected, vendingMachine.displayTotalDeposit());
    }

    @Test
    public void sample() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.receive(new Money(100));
        assertEquals(100, vendingMachine.totalDeposit);
    }


    static Stream<Arguments> changePatterns() {
        return Stream.of(
                arguments(Arrays.asList("water"), Arrays.asList(500), "water", 400),
                arguments(Arrays.asList("tea"), Arrays.asList(500), "tea", 380),
                arguments(Arrays.asList("richWater"), Arrays.asList(500), "richWater", 380),
                arguments(Arrays.asList("superRichWater"), Arrays.asList(500), "superRichWater", 350),
                arguments(Arrays.asList("superRichWater"), Arrays.asList(100), "superRichWater", 100)
        );
    }

    @ParameterizedTest
    @MethodSource("changePatterns")
    public void returnChange(List<String> stockList, List<Integer> depositList, String order, int expected) {
        //given
        VendingMachine vendingMachine = new VendingMachine();
        stockList.forEach(vendingMachine::stock);
        depositList.forEach(money -> { vendingMachine.receive(new Money(money)); });
        vendingMachine.provide(order);
        //when
        int actual = vendingMachine.returnChange();
        //then
        assertEquals(expected, actual);
        assertEquals(0, vendingMachine.displayTotalDeposit());
    }

    static Stream<Arguments> stockPatterns() {
        return Stream.of(
                arguments(Arrays.asList("water"), "water", 1),
                arguments(Arrays.asList("tea"), "tea", 1),
                arguments(Arrays.asList("richWater"), "richWater", 1),
                arguments(Arrays.asList("superRichWater"), "superRichWater", 1),
                arguments(Arrays.asList("water", "water"), "water", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("stockPatterns")
    public void stock(List<String> drinkList, String drink, int expected) {
        //given
        VendingMachine vendingMachine = new VendingMachine();

        //when
        drinkList.forEach(vendingMachine::stock);

        //then
        assertEquals(expected, vendingMachine.getStock(drink));
    }

    static Stream<Arguments> leftStockPatterns() {
        return Stream.of(
                arguments(Arrays.asList("water"), Arrays.asList(100), "water", 0),
                arguments(Arrays.asList("water", "tea"), Arrays.asList(100, 10, 10), "tea", 0),
                arguments(Arrays.asList("tea"), Arrays.asList(100, 10, 10), "water", 0),
                arguments(Arrays.asList(), Arrays.asList(100, 10, 10), "water", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("leftStockPatterns")
    public void leftStock(List<String> drinkList, List<Integer> paymentList, String order, int expected) {
        //given
        VendingMachine vendingMachine = new VendingMachine();
        drinkList.forEach(vendingMachine::stock);
        paymentList.forEach(money -> { vendingMachine.receive(new Money(money)); });

        //when
        vendingMachine.provide(order);

        //then
        assertEquals(expected, vendingMachine.getStock(order));
    }

}
