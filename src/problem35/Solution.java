package problem35;

class Solution {
    public int searchInsert(int[] arr, int target) {
        if(arr.length==0){
            return 1;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=target){
                return i;
            }

        }
        return arr.length;

    }
}