package problem88;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Idx = m - 1; // Index of last element in array nums1
        int nums2Idx = n - 1; // Index of last element in array nums2
        int mergedIdx = m + n - 1;

        while (nums2Idx >= 0) {
            if (nums1Idx >= 0 && nums1[nums1Idx] > nums2[nums2Idx]) {
                nums1[mergedIdx] = nums1[nums1Idx]; // copy nums1
                nums1Idx--;
            } else {
                nums1[mergedIdx] = nums2[nums2Idx]; // copy num2
                nums2Idx--;
            }
            mergedIdx--;
        }
    }
}