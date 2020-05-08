import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    @Test
    public void testInput1got1() {
        String actual = new FizzBuzz().execute();
        assertEquals("1", actual);
    }

    class FizzBuzz {

        String execute() {
            return "1";
        }

    }

}


