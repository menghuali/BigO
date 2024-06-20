package datastructure.array;

/**
 * Create a function that reverses a string. For example, 'Hello, World!' should
 * be: '!dlroW ,olleH'
 */
public class ReverseString {

    public static void main(String[] args) {
        solution1();
        solution2();
    }

    private static void solution2() {
        System.out.println("\n\nSolution 2");
        System.out.println("012345 > " + reverse2("012345"));
        System.out.println("0123456 > " + reverse2("0123456"));
        System.out.println("Hello, World! > " + reverse2("Hello, World!"));
        System.out.println("0 > " + reverse2("0"));
        System.out.println("01 > " + reverse2("10"));
        System.out.println("null > " + reverse2(null));
    }

    private static void solution1() {
        System.out.println("\n\nSolution 1");
        System.out.println("012345 > " + reverse("012345"));
        System.out.println("0123456 > " + reverse("0123456"));
        System.out.println("Hello, World! > " + reverse("Hello, World!"));
        System.out.println("0 > " + reverse("0"));
        System.out.println("01 > " + reverse("10"));
        System.out.println("null > " + reverse(null));
    }

    // Suppose the length of the string is N. The char[i] should go to char[N - 1 -
    // i], and char[N - 1 - i] should go to char[i]. Thus, I can swith char[N - 1
    // -i] and char[N - 1 - i]. If i equals N/2 + 1, don't reverse
    // For example, suppose I have character array {0, 1, 2, 3, 4, 5}, the reverse
    // process shall be...
    // 0) switch 0 and 5 (6 - 1 - 0): {5, 1, 2, 3, 4, 0}
    // 1) switch 1 and 4 (6 - 1 - 1): {5, 4, 2, 3, 1, 0}
    // 2) switch 2 and 3 (6 - 1 - 2): {5, 4, 2, 3, 1, 0}
    // The time Big O notation of this function is O(n)
    // The memory Big O notation of this function is O(n)

    private static String reverse(String text) {
        if (text == null || text.length() < 2) {
            return text;
        }
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            var temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        return new String(chars);
    }

    private static String reverse2(String text) {
        if (text == null || text.length() < 2) {
            return text;
        }
        char[] chars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(text.length() - 1 - i);
        }
        return new String(chars);
    }

}
