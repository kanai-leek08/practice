/**
 * FizzBuzz問題を解決するクラスです。
 */
public class FizzBuzz {
    /**
     * 任意の数値を以下のとおり変換します。
     * 3の倍数：Fizz、5の倍数：Buzz、15の倍数：FizzBuzz、その他：数字
     *
     * @param number (int) 変換したい任意の数値
     * @return (String) 3の倍数：Fizz、5の倍数：Buzz、15の倍数：FizzBuzz、その他：数字
     */
    public static String convert(int number) {
        String result = "";
        if (number % 3 == 0) {
            result += "Fizz";
        }
        if (number % 5 == 0) {
            result += "Buzz";
        }
        if (result.equals("")) {
            result += String.valueOf(number);
        }
        return result;
    }
}
