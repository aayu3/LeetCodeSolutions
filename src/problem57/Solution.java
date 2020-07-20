package problem57;

import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        boolean inserted = false;
        for (int i = 0; i < n; i++) {
            int[] current = intervals[i];
            if (!inserted && newInterval[0] < intervals[i][0]) {
                current = newInterval;
                i--;
                inserted = true;
            }
            merge(list, current);
        }
        if (!inserted) merge(list, newInterval);
        return list.toArray(new int[list.size()][2]);
    }


    private void merge(List<int[]> list, int[] interval) {
        int[] top = list.size() == 0 ? null : list.get(list.size()-1);
        if (list.isEmpty() || top[1] < interval[0]) {
            list.add(interval);
        } else {
            top[1] = Math.max(top[1], interval[1]);
        }
    }
}