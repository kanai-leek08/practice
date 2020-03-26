import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzHarryTest {

    @Test
    void convertIntNumberToStringNumber() {
        Arrays.asList(
                new TestPattern(1, "1"),
                new TestPattern(2, "2"),
                new TestPattern(3, "Fizz"),
                new TestPattern(6, "Fizz")
        ).forEach(testPattern -> {
            String result = new FizzBuzzHarry().convert(testPattern.input);
            assertEquals(testPattern.expected, result);
        });
        Pair<Integer, String> p = new Pair<>(1, "1");
        assertEquals(p.getValue(), new FizzBuzzHarry().convert(p.getKey()));
    }


    private class TestPattern {
        private final int input;
        private final String expected;

        public TestPattern(int input, String expected) {
            this.input = input;
            this.expected = expected;
        }
    }
}
