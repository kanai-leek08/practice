import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzHarryTest {



    @Test
    void convertIntNumberToStringNumber() {
        Arrays.asList(
                new TestPattern(1, "1"),
                new TestPattern(2, "2")
        ).forEach(testPattern -> {
            String result = new FizzBuzzHarry().convert(testPattern.input);
            assertEquals(testPattern.expected, result);
        });

    }

    @Test
    void convertThreeToFizz() {
        int input = 3;
        String expected = "Fizz";
        String result = new FizzBuzzHarry().convert(input);
        assertEquals(expected,result);
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
