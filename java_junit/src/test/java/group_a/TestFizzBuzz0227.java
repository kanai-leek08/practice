package group_a;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFizzBuzz0227 {
    @Test
    void testFizzBuzz(){
        FizzBuzz0227 Target = new FizzBuzz0227();
        String result = Target.getResult(1);
        assertEquals("1",result);

    }

    @Test
    void testFizzBuzz2(){
        FizzBuzz0227 Target = new FizzBuzz0227();
        String result = Target.getResult(2);
        assertEquals("2",result);

    }

    @Test
    void testFizzBuzz3(){
        FizzBuzz0227 Target = new FizzBuzz0227();
        String result = Target.getResult(3);
        assertEquals("fizz",result);

    }
}
