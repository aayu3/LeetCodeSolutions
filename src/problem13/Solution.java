package problem13;


import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
    public static int romanToInt(String s) {
        int cumulative = 0;
        Map<Character,Integer> values = new HashMap<Character,Integer>();

        values.put('I',1);
        values.put('V',5);
        values.put('X',10);
        values.put('L',50);
        values.put('C',100);
        values.put('D',500);
        values.put('M',1000);
        int index = 0;
        while (index < s.length()) {
            int curValue = values.get(s.charAt(index));
            if (s.length() - index == 1) {
                cumulative += curValue;
                return cumulative;
            }
            else if (curValue < values.get(s.charAt(index+1))) {
                cumulative -= curValue;
            }
            else {
                cumulative += curValue;
            }
            index ++;
        }
        return cumulative;
    }

}
