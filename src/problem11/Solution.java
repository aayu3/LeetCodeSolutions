package problem11;



class Solution {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {1,3,2,5,25,24,5}));
    }
    public static int maxArea(int[] height) {
        //keys are the heights of bars, values are the distance
        int maxVol = 0;
        int leftPointer = 0;
        int rightPointer = height.length-1;
        while (leftPointer < rightPointer) {
            int leftHeight = height[leftPointer];
            int rightHeight = height[rightPointer];
            if (leftHeight <= rightHeight) {
                maxVol = Math.max(maxVol,leftHeight*(rightPointer-leftPointer));
                //amount to increment left pointer by without being greater than curr leftpointer
                //i.e. how many things we can skip while incrementing leftpointer to the right
                int amtIncr = 1;
                while (leftHeight >= height[leftPointer + amtIncr]) {
                    if (leftPointer + amtIncr >= rightPointer) {
                        //if this happens, everything to the right of left pointer is smaller than curr left pointer and
                        //we are done
                        return maxVol;
                    }
                    amtIncr += 1;
                }
                leftPointer += amtIncr;
            }
            else {
                maxVol = Math.max(maxVol,rightHeight*(rightPointer-leftPointer));
                //amount we can decrement right pointer by without being greater than curr rightpointer
                //i.e. how many things we can skip while decrementing rightpointer to the left
                int amtDcr = 1;
                while (rightHeight >= height[rightPointer - amtDcr]) {
                    if (rightPointer - amtDcr <= leftPointer) {
                        //if this happens, everything to the left of right pointer is smaller than curr right pointer and
                        //we are done
                        return maxVol;
                    }
                    amtDcr += 1;
                }
                rightPointer -= amtDcr;
            }
        }
        return maxVol;


    }
}