package algorithm.sec15_dynamicprogram;

import java.util.HashMap;
import java.util.Map;

public class FibonacciDP {

    // O(n)
    private static long recursive(int n, Map<Integer, Long> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            long solution = n < 2 ? n : recursive(n - 1, cache) + recursive(n - 2, cache);
            cache.put(n, solution);
            return solution;
        }
    }

    public static long fibonnaci(int n) {
        long result = recursive(n, new HashMap<>());
        System.err.println(String.format("f(%d) = %d", n, result));
        return result;
    }

    public static void main(String[] args) {
        fibonnaci(100);
    }

}
