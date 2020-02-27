package group_a;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFizzBuzz0227And {
    @Test
    void _3の場合はFizzを返す(){
        FizzBuzz0227And fizzbuzz = new FizzBuzz0227And();
        String result = fizzbuzz.onegai(3);
        assertEquals("Fizz", result);
    }

    @Test
    void _5の場合はBuzzを返す(){
        FizzBuzz0227And fizzbuzz = new FizzBuzz0227And();
        String result = fizzbuzz.onegai(5);
        assertEquals("Buzz", result);
    }

    @Test
    void _15の場合はFizzBuzzを返す(){
        FizzBuzz0227And fizzbuzz = new FizzBuzz0227And();
        String result = fizzbuzz.onegai(15);
        assertEquals("FizzBuzz", result);
    }
}
