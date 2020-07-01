package problem4;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] test1 = {0,0};
        int[] test2 = {0,0};
        System.out.println(findMedianSortedArrays(test1,test2));
        System.out.println(findKthElement(test1, test2,(2+2)/2 + 1));

    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1length = nums1.length;
        int n2length = nums2.length;
        if ((n1length + n2length)%2 == 1) {
            return findKthElement(nums1,nums2,(n1length+n2length + 1)/2);
        }
        else {
            return (double) (findKthElement(nums1,nums2,(n1length+n2length)/2) + findKthElement(nums1,nums2,(n1length+n2length )/2 + 1))/2;
        }
    }
    private static int findKthElement(int[] arr1, int[] arr2, int k) {
        if (arr1.length == 0) {
            return arr2[k-1];
        }
        if (arr2.length == 0) {
            return arr1[k-1];
        }
        int mid1 = arr1.length/2;
        int mid2 = arr2.length/2;
        if (mid1+mid2 < k-1) {
            if (arr1[mid1] > arr2[mid2]) {
                int[] newArr2 = new int[arr2.length - mid2 - 1];
                if (newArr2.length > 0) {
                    System.arraycopy(arr2,mid2 + 1,newArr2,0,arr2.length - mid2 - 1);
                }
                return findKthElement(arr1,newArr2,k-mid2-1);
            }
            else {
                int[] newArr1 = new int[arr1.length - mid1 - 1];
                if (newArr1.length > 0) {
                    System.arraycopy(arr1, mid1+1, newArr1, 0, arr1.length-mid1-1);
                }
                return findKthElement(newArr1,arr2,k-mid1-1);
            }
        }
        else {
            if (arr1[mid1] > arr2[mid2]) {
                int[] newArr1 = new int[mid1];
                System.arraycopy(arr1,0,newArr1,0,mid1);
                return findKthElement(newArr1,arr2,k);
            }
            else {
                int[] newArr2 = new int[mid2];
                System.arraycopy(arr2,0,newArr2,0,mid2);
                return findKthElement(arr1,newArr2,k);
            }

        }


    }


}
