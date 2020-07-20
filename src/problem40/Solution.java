package problem40;

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();

        combinSum(candidates, target, result, new ArrayList<>(), 0, 0);

        return new ArrayList(result);
    }

    private void combinSum(int[] candidates, int target, List<List<Integer>> result, List<Integer> slate, int sum, int pos) {

        if(sum > target)
            return;

        if(sum == target) {
            result.add(new ArrayList<>(slate));
            return;
        }

        for(int i=pos;i<candidates.length;i++) {
            if(i>pos && candidates[i] == candidates[i-1]) continue;

            slate.add(candidates[i]);
            combinSum(candidates, target, result, slate, sum+candidates[i], i+1);
            slate.remove(slate.size()-1);
        }
    }
}