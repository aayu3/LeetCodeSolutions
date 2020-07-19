package problem46;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] toPermute = {1,2,3,4};
        List<List<Integer>> result = permute(toPermute);
        System.out.println(result);
        System.out.println(result.size());
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        if (nums.length == 0) {
            return permutations;
        }
        else {
            for (int i: nums) {
                permutations = addNum(i,permutations);
            }
            return permutations;
        }
    }
    public static List<List<Integer>> addNum(int num, List<List<Integer>> permutations) {
        if (permutations.isEmpty()) {
            List<Integer> oneEl = new ArrayList<Integer>();
            oneEl.add(num);
            permutations.add(oneEl);
            return permutations;
        }
        else {
            int outerSize = permutations.size();
            while (outerSize > 0) {
                List<Integer> toModify = permutations.get(0);
                permutations.remove(0);
                outerSize--;
                for (int j = 0; j < toModify.size(); j++) {
                    List<Integer> modified = new ArrayList<>(toModify);
                    modified.add(j,num);
                    permutations.add(modified);
                }
                toModify.add(num);
                permutations.add(toModify);
            }
            return permutations;

        }
    }
}