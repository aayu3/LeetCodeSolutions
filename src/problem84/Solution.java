package problem84;

import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) {
            return 0;
        }
        Stack<Integer> st = new Stack();
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        // fill up left array
        left[0] = 0;
        st.push(0);
        for(int i = 1; i < n; i++) {
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? 0 : st.peek()+1;
            st.push(i);
        }

        // fill up right array
        st.clear();
        right[n-1] = n-1;
        st.push(n-1);
        for(int i = n-2; i >= 0; i--) {
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n-1 : st.peek()-1;
            st.push(i);
        }

        // calculate max height
        int maxArea = heights[0];
        for(int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, (right[i]-left[i]+1)*heights[i]);
        }
        return maxArea;
    }
}