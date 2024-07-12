package algorithm.sec12_recursion;

import java.util.function.Function;

public class Factorial {

    // O(n)
    public static int recursive(int number) {
        if (number <= 2) {
            return number;
        } else {
            return number * recursive(number - 1);
        }
    }

    // O(n)
    public static int iterative(int number) {
        int factorial = number;
        while (--number > 1) {
            factorial *= number;
        }
        return factorial;
    }

    private static void findFactorial(int number, Function<Integer, Integer> function) {
        System.err.println(String.format("%d! = %d", number, function.apply(number)));
    }

    public static void main(String[] args) {
        int number = 6;
        findFactorial(number, Factorial::recursive);
        findFactorial(number, Factorial::iterative);
    }

}
