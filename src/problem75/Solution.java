package problem75;


class Solution {
    public void sortColors(int[] nums)
    {
        int count[] = new int[3];//It will Store count of 0, 1, 2
        int counter = 0;
        for (int i = 0; i < nums.length; i++)
        {
            count[nums[i]] = count[nums[i]] + 1;//Incrementing the number of 0, 1, 2
        }
        for (int i = 0; i < 3; i++)
        {
            while(count[i] != 0)//Suppose count[0] = 2, So it will put 0 from index 0 to 1 and we keep on decrementing the count of zeros after each step
            {
                nums[counter] = i;
                counter++;
                count[i] = count[i] - 1;
            }
        }
    }
}