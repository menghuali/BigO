package sec4_solve_coding_problems;

import java.util.HashSet;

/**
 * Coding Problem to Resovle:
 * Given an arry of numbers, find a matching pair where the sum equals to a
 * given number.
 * 
 * Sample 1: given the array [4, 2, 1, 3] and the given number is 6. The
 * function should return true
 * because because the sum of pair (4, 2) equals 6.
 * 
 * Sample 2: given the arry [4, 2, 1, 3] and the given number is 8. The function
 * should return false.
 * 
 */
public class GoogleInterviewHasPairWithSum {

    /**
     * 1. When the interviewer says the question, write down the key points at the
     * top (i.e. sorted array).
     * Make sure you have all the details. Show how organized you are.
     * 
     * Input 1: An array of numbers
     * Input 2: A number
     * Output: A Boolean indicates if Input1 array has a pair of numbers where their
     * sum equals to Input 2.
     */

    /**
     * 2. Make sure you double check: What are the inputs?
     * What are the outputs? There will be to input: 1) An array of numbers, 2) A
     * number. The output is a Boolean. I need to look for a pair of number from the
     * Input 1 where their sum equals to Input 2. If the pair is found, the function
     * returns true; otherwise return false. Do I understand the problem correctly?
     * Yes
     */

    /**
     * 3. What is the most important value of the problem? Do you have time, and
     * space and memory, etc.. What is the main goal?
     * 
     * Is there memory restriction for running the fuction?
     * Yes
     * 
     * Is there time restriction for running the fuction?
     * The faster the better
     */

    /**
     * 4. Don't be annoying and ask too many questions.
     * 
     * Is this array sorted?
     * No
     * 
     * How is the array given, by memory or by file?
     * By memory
     * 
     * Can array have negative number?
     * Yes
     * 
     * Does array only have integer or it can have float?
     * Only integer.
     * 
     * Can array have duplicated numbers?
     * Yes
     * 
     * What's the size of the array?
     * No size limitation.
     */

    public static void main(String[] args) {
        int expected = 8;
        System.out.println(findSumPair2(new int[] { 3, 1, 2, 4}, expected));
        System.out.println(findSumPair2(new int[] { 3, 1, 2, 4, 5 }, expected));
        System.out.println(findSumPair2(new int[] { 9, 1, 2, -1, 5 }, expected));
        System.out.println(findSumPair2(new int[] {1}, expected));
        System.out.println(findSumPair2(new int[] {expected}, expected));
        System.out.println(findSumPair2(new int[] {8,1}, expected));
        System.out.println(findSumPair2(new int[] {8,0}, expected));
    }

    /**
     * 5. Start with the naive/brute force approach. First thing that comes into
     * mind.
     * It shows that you’re able to think well and critically
     * (you don't need to write this code, just speak about it).
     * 
     * Brutal force approach.
     * 
     * 6. Tell them why this approach is not the best (i.e. O(n^2) or higher, not
     * readable, etc...)
     * In the worst case, the total number of operation is SUM(n-1, n-2, n-3,..., 1)
     * = n * (n / 2) = n^2 / 2.
     * So the Big O notation is O(n^2).
     * 
     */
    public static boolean findSumPair(int[] array, int expected) {
        // 1. Loop through array, get the current item array[i]
        // 2. Embedded look: loop the array, check if sum equals to the expected number.
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == expected)
                    return true;
            }
        }
        return false;
        // BigO: O(n^2)
    }

    /**
     * 
     * 7. Walk through your approach, comment things and see where you may be able
     * to break things. Any repetition, bottlenecks like O(N^2), or unnecessary
     * work? Did you use all the information the interviewer gave you? Bottleneck is
     * the part of the code with the biggest Big O. Focus on that. Sometimes this
     * occurs with repeated work as well.
     * 
     * I can improve the function in this way...
     * I still need a loop to go through the array. For the current item array[i], I
     * know if the previous array items has a number equals to expected - array[i],
     * then the pair is found. I can put the iterated number in a hash set, adding
     * an item to a hash set will be O(1). If the hash set=, aka iterated items
     * doesn't have the number that array[i] needed, add array[i] to the hash set
     * and iterate the next item in the array util found pair or each the end of the
     * array.
     * 
     * Example 1:
     * i = 0; array = {4, 3, 1, 2, 5}; current = 4; need = 4; hash set = {}; pair
     * not found yet, contiue
     * i = 1; array = {3, 1, 2, 5}; current = 3; need = 5; hash set = {4}; pair not
     * found yet, contiue
     * i = 2; array = {1, 2, 5}; current = 1; need = 7; hash set = {4, 3}; pair not
     * found yet, contiue
     * i = 3; array = {2, 5}; current = 2; need = 6; hash set = {4, 3, 1}; pair not
     * found yet, contiue
     * i = 4; array = {5}; current = 5; need = 3; hash set = {4, 3, 1, 2}; pair
     * found, return true
     * 
     * Example 1:
     * i = 0; array = {4, 3, 1, 2}; current = 4; need = 4; hash set = {}; pair not
     * found yet, contiue
     * i = 1; array = {3, 1, 2}; current = 3; need = 5; hash set = {4}; pair not
     * found yet, contiue
     * i = 2; array = {1, 2}; current = 1; need = 7; hash set = {4, 3}; pair not
     * found yet, contiue
     * i = 3; array = {2}; current = 2; need = 6; hash set = {4, 3, 1}; pair not
     * found yet, contiue
     * i = 4: reach the end of array, return false.
     * 
     * Add and look up item in a hash set is O(1). Since there is one loop, so the
     * worst case is O(n).
     * 
     * 9. Modularize your code from the very beginning. Break up your code into
     * beautiful small pieces and add just comments if you need to.
     * 
     * 10. Start actually writing your code now.
     * 
     * 11. Think about error checks and how you can break this code.
     * What if the array is empty or null;
     */
    public static boolean findSumPair2(int[] array, int expected) {
        if (array == null || array.length <= 1)
            return false;
        HashSet<Integer> iterated = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (iterated.contains(expected - array[i])) {
                return true;
            } else {
                iterated.add(array[i]);
            }
        }
        return false;
    }

}
