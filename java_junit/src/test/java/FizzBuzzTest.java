import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    @Nested
    class ConvertIntNumberToStringNumber {

        @Test
        void convertOneToOne() {
            String result = FizzBuzz.convert(1);
            assertEquals("1", result);
        }

        @Test
        void convertTwoToTwo() {
            String result = FizzBuzz.convert(2);
            assertEquals("2", result);
        }
    }

    @Nested
    class ConvertMultiplesOfThreeToFizz {

        @Test
        void convertThreeToFizz() {
            String result = FizzBuzz.convert(3);
            assertEquals("Fizz", result);
        }

        @Test
        void convertSixToFizz() {
            String result = FizzBuzz.convert(6);
            assertEquals("Fizz", result);
        }
    }

    @Nested
    class ConvertMultiplesOfFiveToBuzz {

        @Test
        void convertFiveToBuzz() {
            String result = FizzBuzz.convert(5);
            assertEquals("Buzz", result);
        }

        @Test
        void convertTenToBuzz() {
            String result = FizzBuzz.convert(10);
            assertEquals("Buzz", result);
        }
    }

    @Nested
    class ConvertMultiplesOfFifteenToFizzBuzz {

        @Test
        void convertFifteenToFizzBuzz() {
            String result = FizzBuzz.convert(15);
            assertEquals("FizzBuzz", result);
        }

    }

}
