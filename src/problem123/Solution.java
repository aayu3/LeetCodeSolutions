package problem123;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int[] changes = new int[prices.length-1];
        for (int i = 0; i < changes.length; i++) {
            changes[i] = prices[i+1] - prices[i];
        }

        int curr = 0;
        int max = 0;
        int maxStart = -1;
        int maxEnd = -1;
        int start = -1;

        for (int i = 0; i < changes.length; i++) {
            if (curr == 0 && changes[i] > 0) {
                start = i;
            }
            curr += changes[i];
            curr = Math.max(curr, 0);
            if (curr > max) {
                maxStart = start;
                maxEnd = i;
            }
            max = Math.max(max, curr);
        }

        int secondMax = Math.max(maxProfit(changes, 0, maxStart-1),
                maxProfit(changes, maxEnd+1, changes.length-1));

        int maxLoss = Math.abs(maxLoss(changes, maxStart, maxEnd));

        return max + Math.max(secondMax, maxLoss);

    }

    public int maxProfit(int[] changes, int start, int end) {
        if (start < 0 || end >= changes.length) return 0;
        int curr = 0;
        int max = 0;
        for (int i = start; i <= end; i++) {
            curr += changes[i];
            curr = Math.max(curr, 0);
            max = Math.max(max, curr);
        }
        return max;
    }

    public int maxLoss(int[] changes, int start, int end) {
        if (start < 0 || end >= changes.length) return 0;
        int curr = 0;
        int min = 0;
        for (int i = start; i <= end; i++) {
            curr += changes[i];
            curr = Math.min(curr, 0);
            min = Math.min(min, curr);
        }
        return min;
    }
}