package algorithm.recursion;

import java.util.function.Function;

public class Fibonacci {

    public static int recursive(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return recursive(n - 1) + recursive(n - 2);
        }
    }

    public static int iterative(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int first = 0, second = 1, fb = 0;
        while (n-- > 1) {
            fb = first + second;
            first = second;
            second = fb;
        }
        return fb;
    }

    private static void fibonnaci(int n, Function<Integer, Integer> function) {
        System.out.println(String.format("f(%d) = %d", n, function.apply(n)));
    }

    public static void main(String[] args) {
        fibonnaci(15, Fibonacci::recursive);
        fibonnaci(15, Fibonacci::iterative);
    }

}
