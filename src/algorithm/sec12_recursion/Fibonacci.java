package algorithm.sec12_recursion;

import java.util.function.Function;

public class Fibonacci {

    // O(2^n) Exponetial Time
    public static long recursive(int n) {
        if (n < 2) {
            return n;
        } else {
            return recursive(n - 1) + recursive(n - 2);
        }
    }

    // O(n)
    public static long iterative(int n) {
        if (n < 2) {
            return n;
        }

        long first = 0, second = 1, fb = 0;
        while (n-- > 1) {
            fb = first + second;
            first = second;
            second = fb;
        }
        return fb;
    }

    private static void fibonnaci(int n, Function<Integer, Long> function) {
        System.out.println(String.format("f(%d) = %d", n, function.apply(n)));
    }

    public static void main(String[] args) {
        fibonnaci(5, Fibonacci::iterative);
        fibonnaci(5, Fibonacci::recursive); // much slower
        
    }

}
