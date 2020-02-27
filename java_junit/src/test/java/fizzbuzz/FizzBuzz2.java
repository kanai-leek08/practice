package fizzbuzz;

public class FizzBuzz2 {
    public static String get_fizzbuzz(int i) {
        if(i%3 == 0){
            return "fizz";
        }
        return String.valueOf(i);
    }
}
