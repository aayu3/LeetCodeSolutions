package problem41;

import java.util.*;

class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int i=1;
        while(i<Integer.MAX_VALUE){
            if(!set.contains(i)){
                return i;
            }
            i++;
        }
        return i;
    }
}