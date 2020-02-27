package fizzbuzz;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testFizzBuzz1 {

    @Nested
    public class get
    {
     /*   @Test
        public void patterns()
        {
            Arrays.asList(new TestCase(1, "1").forEach(testCase->{
                assertEquals(testCase.exepted, testCase.setParam(1).get());
            });
        }*/

        @Test
        public void getTest_one(){
            assertEquals("1",FizzBuzz1.get(1));
        }

        @Test
        public void getTest_two(){
            assertEquals("2",FizzBuzz1.get(2));
        }

        @Test
        public void getTest_fizz(){
            assertEquals("fizz",FizzBuzz1.get(3));
        }

        @Test
        public void getTest_fizz2(){
            assertEquals("fizz",FizzBuzz1.get(6));
        }

        @Test
        public void getTest_buzz(){
            assertEquals("buzz",FizzBuzz1.get(5));
        }

        @Test
        public void getTest_buzz2(){
            assertEquals("buzz",FizzBuzz1.get(10));
        }

        @Test
        public void getTest_fizzbuzz(){
            assertEquals("fizzbuzz",FizzBuzz1.get(15));
        }

        @Test
        public void getTest_fizzbuzz2(){
            assertEquals("fizzbuzz",FizzBuzz1.get(30));
        }
    }






}
