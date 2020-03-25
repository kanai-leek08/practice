import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Nested
    class IsValid {
        @Test
        void validUser() {
            Arrays.asList(
                    new TestPattern("12345678", true),
                    new TestPattern("1234567", false)
            ).forEach(testPattern -> {
                boolean isValid = new User("Bob", "Odd-e", testPattern.password).isValid();
                assertEquals(testPattern.expected, isValid);
            });
        }

        private class TestPattern {
            public String password;
            public boolean expected;

            public TestPattern(String password, boolean expected) {
                this.password = password;
                this.expected = expected;
            }
        }
    }

    @Nested
    class GetSign {

        @Test
        void changeByPasswordValidation() {

            Arrays.asList(
                    new IsValidTestPattern("12345678", "Odd-e: Bob OK"),
                    new IsValidTestPattern("1234567", "Odd-e: Bob NG")
            ).forEach(testPattern -> {
                String sign = new User("Bob", "Odd-e", testPattern.password).getSign();
                assertEquals(testPattern.expected, sign);
            });

        }

        private class IsValidTestPattern {
            private final String password;
            private final String expected;

            public IsValidTestPattern(String password, String expected) {
                this.password = password;
                this.expected = expected;
            }
        }

        @Test
        void changeByCompany() {
            Arrays.asList(
                    new CompanyTestPattern("Odd-e", "Odd-e: Harry OK"),
                    new CompanyTestPattern("tdi", "tdi: Harry OK"),
                    new CompanyTestPattern(null, "Harry OK")
            ).forEach(companyTestPattern -> {
                String sign = new User("Harry", companyTestPattern.company, "12345678").getSign();
                assertEquals(companyTestPattern.expected, sign);
            });
        }

        private class CompanyTestPattern {
            private final String company;
            private final String expected;

            public CompanyTestPattern(String company, String expected) {

                this.company = company;
                this.expected = expected;
            }
        }

        @Test
        void changeByName() {
            Arrays.asList(
                    new NameTestPattern("Harry", "Odd-e: Harry OK"),
                    new NameTestPattern("Bob", "Odd-e: Bob OK")
            ).forEach(nameTestPattern -> {
                String sign = new User(nameTestPattern.name, "Odd-e", "12345678").getSign();
                assertEquals(nameTestPattern.expected, sign);
            });
        }

        private class NameTestPattern {
            private final String name;
            private final String expected;

            public NameTestPattern(String name, String expected) {

                this.name = name;
                this.expected = expected;
            }
        }


    }
}



