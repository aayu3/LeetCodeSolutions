package problem128;

import java.util.Arrays;
import java.util.HashMap;

class Solution {

    public int find(int index, int[] graph) {
        if (graph[index] < 0)
            return index;

        int currIndex = graph[index];
        int newIndex = find(graph[index], graph);

        if (newIndex != currIndex) {
            graph[index] = newIndex;
            graph[newIndex]--;
        }
        return newIndex;
    }

    public void union(int index1, int index2, int[] graph) {
        int xset = find(index1, graph);
        int yset = find(index2, graph);

        if (graph[xset] < graph[yset]) {
            graph[yset] = xset;
            graph[xset]--;
        } else {
            graph[xset] = yset;
            graph[yset]--;
        }

    }

    public int longestConsecutive(int[] nums) {
        int[] graph = new int[nums.length];
        HashMap<Integer, Integer> mp = new HashMap<>();

        Arrays.fill(graph, -1);

        for (int i = 0; i < nums.length; i++) {

            if (mp.containsKey(nums[i]))
                continue;
            mp.put(nums[i], i);
            int num = nums[i];


            if (mp.containsKey(num + 1)) {
                union(mp.get(num + 1), mp.get(num), graph);
            }

            if (mp.containsKey(num - 1)) {
                union(mp.get(num - 1), mp.get(num), graph);
            }
        }

        int smallest = 0;

        for (int num : nums) {
            int count = find(mp.get(num), graph);
            if (graph[count] < smallest)
                smallest = graph[count];
        }

        return smallest * -1;
    }
}