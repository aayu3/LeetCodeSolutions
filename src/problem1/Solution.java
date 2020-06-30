package problem1;
import java.util.*;

class Solution {
    public static void main(String[] args){
        int[] example = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(example,9)));
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        int[] retval = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (hmap.get(target-cur) != null){
                retval[0] =i;

                retval[1] = hmap.get(target-cur);
                return retval;
            }
            else {
                hmap.put(cur,i);
            }

        }
        return new int[] {};
    }
}
