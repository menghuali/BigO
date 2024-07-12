package algorithm.sec12_recursion;

import java.util.function.Function;

public class ReverseString {

    // O(n)
    public static String recursive(String input) {
        if (input.length() <= 1) {
            return input;
        } else {
            return recursive(input.substring(1)) + input.charAt(0);
        }
    }

    // O(n)
    public static String iterative(String input) {
        char[] reversed = new char[input.length()];
        int i = 0;
        while (i < input.length()) {
            reversed[i] = input.charAt(input.length() - 1 - i);
            i++;
        }
        return new String(reversed);
    }

    private static void reverse(String input, Function<String, String> function) {
        System.out.println(function.apply(input));
    }

    public static void main(String[] args) {
        reverse("yoyo master", ReverseString::recursive);
        reverse("yoyo master", ReverseString::iterative);
    }

}
