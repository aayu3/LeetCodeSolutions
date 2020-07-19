package problem30;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(findSubstring("aaaaaaaaaaaa", new String[] {"aaa","aaa"}));
    }
    public static List<Integer> findSubstring(String s, String[] words) {
         List<Integer> retval = new ArrayList<Integer>();
         if (words.length == 0) {
             return retval;
         }
        int lenOfWord = words[0].length();
        int lenOfArrayWords = lenOfWord*words.length;
        if (s.length() < lenOfArrayWords) {
            return retval;
        }
        int index = 0;
        Arrays.sort(words);
        System.out.println("Words sorted:" + Arrays.toString(words));
        while (index + lenOfArrayWords <= s.length()) {
            if (matchArrayString(words,s.substring(index,index+lenOfArrayWords))) {
                retval.add(index);
            }
            index++;
        }
        return retval;
    }
    public static boolean matchArrayString(String[] words, String str) {
        int lenOfWord = words[0].length();
        String[] strToArray = new String[words.length];
        for (int i = 0; i < strToArray.length; i++) {
            strToArray[i] = str.substring(i*lenOfWord,i*lenOfWord+lenOfWord);
        }
        Arrays.sort(strToArray);
        System.out.println(Arrays.toString(strToArray));

        return Arrays.equals(strToArray,words);
    }
}