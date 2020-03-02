package group_a.tennis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzzTest {

    private Fizzz f;

    @BeforeEach
    void setUp() {
        f = new Fizzz();
    }

    @Test
    void fizzbuzz2() {
        assertEquals("2", f.run(2));
    }

    @Test
    void fizzbuzz3() {
        assertEquals("Fizz", f.run(3));
    }

    @Test
    void fizzbuzz5() {
        assertEquals("Buzz", f.run(5));
    }
}
