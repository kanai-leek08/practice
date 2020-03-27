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
                arguments(Arrays.asList(100), "water", "water"),
                arguments(Arrays.asList(100, 10, 10), "water", "water"),
                arguments(Arrays.asList(100, 10, 10), "tea", "tea"),
                arguments(Arrays.asList(100), "tea", null)
        );
    }

    @ParameterizedTest
    @MethodSource("buyPatterns")
    public void buy(List<Integer> depositList, String order, String expected) {
        //given
        VendingMachine vendingMachine = new VendingMachine();
        depositList.forEach(vendingMachine::receive);
        //when
        String drink = vendingMachine.provide(order);
        //then
        assertEquals(expected, drink);
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
        depositList.forEach(vendingMachine::receive);
        //then
        assertEquals(expected, vendingMachine.displayTotalDeposit());
    }

    static Stream<Arguments> changePatterns() {
        return Stream.of(
                arguments(Arrays.asList(500), "water", 400),
                arguments(Arrays.asList(500), "tea", 380)
        );
    }

    @ParameterizedTest
    @MethodSource("changePatterns")
    public void returnChange(List<Integer> depositList, String order, int expected) {
        VendingMachine vendingMachine = new VendingMachine();
        depositList.forEach(vendingMachine::receive);
        vendingMachine.provide(order);

        assertEquals(expected, vendingMachine.returnChange());
        assertEquals(0, vendingMachine.displayTotalDeposit());
    }
}
