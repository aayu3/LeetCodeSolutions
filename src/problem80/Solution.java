package problem80;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {return 0;}
        int i = 0;
        int count = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[i] && count < 2) {
                i++;
                nums[i] = nums[j];
                count++;
            }
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
                count = 1;
            }
        }
        return i + 1;
    }
}