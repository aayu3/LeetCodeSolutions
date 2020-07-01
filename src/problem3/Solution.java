package problem3;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("au"));
    }
    public static int lengthOfLongestSubstring(String s) {
        char[] str = s.toCharArray();
        int longest = 0;
        Map<Character, Integer> lastPos = new HashMap<>();
        int leftIndex = 0;
        for (int i = 0; i < str.length; i++) {
            if (lastPos.containsKey(str[i])) {
                leftIndex = Math.max(lastPos.get(str[i]),leftIndex);
            }
            longest = Math.max(longest, i - leftIndex);
            lastPos.put(str[i],i);
        }
        return longest;
    }
}