package problem74;



class Solution {
    public boolean searchMatrix(int[][] arr, int target) {

        // Solving the problem using time complexity O(log(m*n))

        //if the arr is empty
        if(arr==null || arr.length==0){
            return false;
        }

        //Calculating total number of row and columns
        int m=arr.length;       //total number of rows
        int n=arr[0].length;    //total number of columns

        int l=0;                //taking first index
        int r=m*n-1;            //taking last index

        //very simple binary search logic
        while(l<=r){
            int mid=l+(r-l)/2;  //cur element no.

            int row=mid/n;     //current element row no.
            int col=mid%n;     //current element col no.

            if(arr[row][col]==target){
                return true;
            }else if(arr[row][col]>target){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }

        return false;

    }
}