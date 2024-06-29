package datastructure.sec7_hashtable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Google Question
 * Given an array = [2,5,1,2,3,5,1,2,4]:
 * It should return 2
 * 
 * Given an array = [2,1,1,2,3,5,1,2,4]:
 * It should return 1
 * 
 * Given an array = [2,3,4,5]:
 * It should return undefined
 * 
 * Bonus... What if we had this:
 * [2,5,5,2,3,5,1,2,4]
 * return 5 because the pairs are before 2,2
 */
public class FirstRecurringCharacter {

    public Character firstRecurringCharacter(char[] chars) {
        if (chars == null || chars.length < 2) {
            return null;
        }
        var occurred = new HashSet<Character>();
        for (int i = 0; i < chars.length; i++) {
            if (occurred.contains(chars[i])) {
                return chars[i];
            } else {
                occurred.add(chars[i]);
            }
        }
        return null;
    }

    public Character bonus(char[] chars) {
        if (chars == null || chars.length < 2) {
            return null;
        }
        var occurred = new HashMap<Character, Integer>();
        var firstRecurring = Integer.MAX_VALUE;
        for (int i = 0; i < chars.length; i++) {
            if (occurred.containsKey(chars[i])) {
                firstRecurring = Math.min(firstRecurring, occurred.get(chars[i]));
            } else {
                occurred.put(chars[i], i);
            }
        }
        return firstRecurring == Integer.MAX_VALUE ? null : chars[firstRecurring];
    }

    public static void main(String[] args) {
        FirstRecurringCharacter frc = new FirstRecurringCharacter();
        System.out.println(frc.firstRecurringCharacter(new char[] { '2', '5', '1', '2', '3', '5', '1', '2', '4' }));
        System.out.println(frc.firstRecurringCharacter(new char[] { '2', '1', '1', '2', '3', '5', '1', '2', '4' }));
        System.out.println(frc.firstRecurringCharacter(new char[] { '2', '3', '4', '5' }));
        System.out.println(frc.firstRecurringCharacter(new char[] { '2', '5', '5', '2', '3', '5', '1', '2', '4' }));
        System.out.println(frc.bonus(new char[] { '2', '5', '5', '2', '3', '5', '1', '2', '4' }));
        System.out.println(frc.bonus(new char[] { '2', '5', '5', '3', '5', '1', '2', '4' }));
    }

}
