import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HolidayTest {

    @Test
    void isNotXmas() {
        final boolean actual = new Holiday().isXmas();
        assertEquals(false, actual);
    }
}