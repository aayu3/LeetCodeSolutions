package problem90;

import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length <= 0)
            return new ArrayList<>();

        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, subset, res);
        return new ArrayList<>(res);
    }

    private void helper(int[] nums, int pos, List<Integer> subset, List<List<Integer>> res) {
        res.add(new ArrayList<>(subset));
        for (int i = pos; i < nums.length; ++i) {
            if (i > pos && nums[i] == nums[i - 1]) continue;
            subset.add(nums[i]);
            helper(nums, i + 1, subset, res);
            subset.remove(subset.size() - 1);
        }
    }
}
