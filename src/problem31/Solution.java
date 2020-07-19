package problem31;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] nums = {1,3,2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void nextPermutation(int[] nums) {

        if (nums.length == 0 || nums.length == 1) {
            //do nothing
        }
        else {
            boolean unpermutable = false;
            int biggerPointer = nums.length-1;
            int smallerPointer = nums.length-2;
            int prevVal = nums[biggerPointer];
            while (smallerPointer >= 0 && smallerPointer < biggerPointer) {
                if (nums[smallerPointer] < nums[biggerPointer]) {
                    unpermutable = true;
                    int temp = nums[smallerPointer];
                    nums[smallerPointer] = nums[biggerPointer];
                    nums[biggerPointer] = temp;
                    System.out.println("smallerPointer: " + smallerPointer);
                    System.out.println("biggerPointer: " + biggerPointer);
                    Arrays.sort(nums,smallerPointer+1,nums.length);
                    break;
                }
                else if (nums[smallerPointer] < prevVal) {
                    biggerPointer -= 1;
                }
                else {
                    prevVal = nums[smallerPointer];
                    smallerPointer -=1;
                }
            }
            if (unpermutable == false) {
                Arrays.sort(nums);
            }
        }


    }
}