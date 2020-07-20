package problem53;

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSub = nums[0], curSum = 0;

        for (int n : nums) {
            if (curSum < 0)
                curSum = 0;
            curSum += n;
            maxSub = Math.max(maxSub, curSum);
        }
        return maxSub;
    }
}