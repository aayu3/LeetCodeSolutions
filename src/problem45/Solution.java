package problem45;

class Solution {
    public int jump(int[] nums) {
        if (nums.length < 2) return 0;
        int maxPos = nums[0], maxSteps = nums[0];
        int jumps = 1;
        for (int i = 0; i < nums.length; i++) {
            if (maxSteps < i) {
                jumps++;
                maxSteps = maxPos;
            }
            maxPos = Math.max(maxPos, nums[i] + i);
        }
        return jumps;
    }
}