package problem17;

import java.util.*;

public class Solution {
    private Map<Character, String[]> telephone = new HashMap<Character, String[]>();
    public List<String> retVal = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        telephone.put('2',new String[] {"a","b","c"});
        telephone.put('3',new String[] {"d","e","f"});
        telephone.put('4',new String[] {"g","h","i"});
        telephone.put('5',new String[] {"j","k","l"});
        telephone.put('6',new String[] {"m","n","o"});
        telephone.put('7',new String[] {"p","q","r", "s"});
        telephone.put('8',new String[] {"t","u","v"});
        telephone.put('9',new String[] {"w","x","y","z"});
        if (digits.length() != 0)
            recurse("", digits);
        return retVal;
    }
    public void recurse(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            retVal.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String[] letters = telephone.get(next_digits.charAt(0));
            for (int i = 0; i < letters.length; i++) {
                String letter = letters[i];
                // append the current letter to the combination
                // and proceed to the next digits
                recurse(combination + letter, next_digits.substring(1));
            }
        }
    }


}
