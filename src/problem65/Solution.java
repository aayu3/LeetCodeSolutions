package problem65;

import java.util.*;

class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if(s.length() == 0 || Character.isAlphabetic(s.charAt(s.length()-1))) return false;

        Set<Character> sign = Set.of('+', '-');
        Set<Character> numbers = Set.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        Set<Character> dec = Set.of('.');
        Set<Character> exp = Set.of('e');

        char[] a = s.toCharArray();
        if(a.length == 1 && !numbers.contains(a[0])) return false;

        boolean isNum = false;
        boolean isSigned = false;
        boolean isDec = false;
        boolean isExp = false;

        Set<Character> allowedSet = new HashSet<>();
        allowedSet.addAll(sign);
        allowedSet.addAll(numbers);
        allowedSet.addAll(dec);

        for(int i=0; i<a.length;i++) {
            char c = a[i];
            if(allowedSet.contains(c)){
                allowedSet.clear();
                if(c == '+' || c == '-'){
                    isSigned = true;
                    if(isExp && (i+1 >= a.length || !numbers.contains(a[i+1]))) return false;
                    if(!isExp && !isDec) allowedSet.addAll(dec);
                    allowedSet.addAll(numbers);
                } else if(c == 'e') {
                    if(!isNum) return false;
                    isExp = true;
                    isSigned = false;
                    allowedSet.addAll(sign);
                    allowedSet.addAll(numbers);
                } else if(c == '.'){
                    if(isSigned && (i+1 >= a.length || !numbers.contains(a[i+1]))) return false;
                    else isSigned = false;

                    isDec = true;
                    allowedSet.addAll(exp);
                    allowedSet.addAll(numbers);
                } else {
                    isSigned = false;
                    isNum = true;
                    if(!isExp) allowedSet.addAll(exp);
                    if(!isDec && !isExp) allowedSet.addAll(dec);
                    allowedSet.addAll(numbers);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}