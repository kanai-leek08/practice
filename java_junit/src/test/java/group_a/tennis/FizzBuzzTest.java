package group_a.tennis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    @Test
    void FizzBuzzTest0() {
        assertEquals(1,1);
    }

    @Test
    void FizzBuzzTest_mum1() {
        FizzBuzz fizzbuzz = new FizzBuzz();
        assertEquals("1",fizzbuzz.fizzbuzz(1));
    }

    @Test
    void FizzBuzzTest_num2() {
        FizzBuzz fizzbuzz = new FizzBuzz();
        assertEquals("2",fizzbuzz.fizzbuzz(2));
    }

    @Test
    void FizzBuzzTest_num3() {
        FizzBuzz fizzbuzz = new FizzBuzz();
        assertEquals("fizz",fizzbuzz.fizzbuzz(3));
    }
}
