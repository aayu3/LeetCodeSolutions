package problem47;

import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        Set<List<Integer>> finalList = new HashSet<>();
        recur(nums,0,new ArrayList<>(),new ArrayList<>(),finalList);
        return new ArrayList<>(finalList) ;
    }



    void recur(int[] nums,int index, List<Integer> currList, List<Integer> addedIndex ,Set<List<Integer>> finalList){

        if(index>=nums.length)
            return;

        for(int i=0;i<nums.length;i++){
            if(addedIndex.contains(i)){
                continue;
            }
            currList.add(nums[i]);
            addedIndex.add(i);
            recur(nums,index+1,currList,addedIndex,finalList);
            if(index==nums.length-1){
                finalList.add(new ArrayList(currList));

            }
            currList.remove(currList.size() -1);
            addedIndex.remove(addedIndex.size()-1);
        }

    }
}