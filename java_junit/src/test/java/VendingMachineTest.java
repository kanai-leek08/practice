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
                arguments(100, "water", "water"),
                arguments(120, "water", "water"),
                arguments(120, "tea", "tea"),
                arguments(100, "tea", null)
        );
    }

    @ParameterizedTest
    @MethodSource("buyPatterns")
    public void buy(int money, String order, String expected) {
        String drink = new VendingMachine().buy(money, order);
        assertEquals(expected, drink);
    }

    static Stream<Arguments> paymentPatterns() {
        return Stream.of(
                arguments(Arrays.asList(100), 100),
                arguments(Arrays.asList(500), 500),
                arguments(Arrays.asList(100, 10), 110)
        );
    }

    @ParameterizedTest
    @MethodSource("paymentPatterns")
    public void received(List<Integer> money, int expected) {
        int totalReceive = VendingMachine.receive(money);
        assertEquals(expected, totalReceive);
    }


}
