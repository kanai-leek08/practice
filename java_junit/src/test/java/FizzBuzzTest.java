import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    @Test
    public void testInput1got1() {
        String actual = new FizzBuzz().execute(1);
        assertEquals("1", actual);
    }

    @Test
    public void testInput2got2() {
        String actual = new FizzBuzz().execute(2);
        assertEquals("2", actual);
    }


}


