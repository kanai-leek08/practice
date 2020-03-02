package group_a.tennis;

public class Fizzz {
    public String run(int inputNumber) {
        if (inputNumber % 3 == 0){
            return "Fizz";
        }
        if (inputNumber % 5 == 0){
            return "Buzz";
        }

        return String.valueOf(inputNumber);
    }
}
