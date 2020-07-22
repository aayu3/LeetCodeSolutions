package problem85;

import java.util.*;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int maxRectangle = 0;
        int[] histogram = new int[n];
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                for (int j = 0; j < n; j++) {
                    histogram[j] = (matrix[i][j]  - '0');
                }
            } else {
                int[] tempHistogram = new int[n];
                for (int j = 0; j < n; j++) {
                    tempHistogram[j] = (matrix[i][j] - '0') * (histogram[j] + (matrix[i][j]  - '0'));
                }
                histogram = tempHistogram;
            }
            maxRectangle = Math.max(maxRectangle, largestRectangleInHistogram(histogram));
        }
        return maxRectangle;
    }

    private int largestRectangleInHistogram(int[] hist) {
        int n = hist.length;
        Stack<Integer> s = new Stack<>(); // stack is increasing
        s.add(-1);
        int maxArea = 0;
        for (int i = 0; i < hist.length; i++) {
            while(s.peek() != -1 && hist[s.peek()] >= hist[i]) {
                int peek = s.pop();
                // calculate height of stack top forming rectangle from last value till i-1
                maxArea = Math.max(maxArea, hist[peek] * (i - s.peek()-1));
            }
            s.add(i);
        }
        while(s.peek() != -1) {
            int peek = s.pop();
            maxArea = Math.max(maxArea, hist[peek] * (n - s.peek()-1));
        }
        return maxArea;
    }
}