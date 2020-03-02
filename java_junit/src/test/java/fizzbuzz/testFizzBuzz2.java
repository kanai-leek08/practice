package fizzbuzz;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testFizzBuzz2 {

    @Test
    void fizzbuzz_1() {
        assertEquals("1",FizzBuzz2.get_fizzbuzz(1));
    }
    @Test
    void fizzbuzz_2() {
        assertEquals("2",FizzBuzz2.get_fizzbuzz(2));
    }
    @Test
    void fizzbuzz_3() {
        assertEquals("fizz",FizzBuzz2.get_fizzbuzz(3));
    }
    @Test
    void fizzbuzz_6() {
        assertEquals("fizz",FizzBuzz2.get_fizzbuzz(6));
    }

}
