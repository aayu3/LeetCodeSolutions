package problem15;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Set<List<Integer>> triples = new HashSet<List<Integer>>();
        for (int i = 0; i < length - 1; i++)
        {
            // Find all pairs with sum equalens to
            // "-arr[i]"
            HashSet<Integer> s = new HashSet<Integer>();
            for (int j = i + 1; j < length; j++)
            {
                int x = -(nums[i] + nums[j]);
                if (s.contains(x))
                {
                    List<Integer> triple = new ArrayList<Integer>();
                    triple.add(x);
                    triple.add(nums[i]);
                    triple.add(nums[j]);
                    Collections.sort(triple);
                    triples.add(triple);

                }
                else
                {
                    s.add(nums[j]);
                }
            }
        }
        return new ArrayList<>(triples);

    }
}