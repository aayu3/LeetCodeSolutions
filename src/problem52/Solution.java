package problem52;

import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] positions = new int[n];
        Arrays.fill(positions, -1);
        backtrack(positions, 0, res);
        return res;
    }

    private void backtrack(int[] positions, int row, List<List<String>> res) {
        int n = positions.length;
        if(row == n) {
            List<String> rowResult = new ArrayList<>();
            for(int position : positions) {
                char[] arr = new char[n];
                Arrays.fill(arr, '.');
                arr[position] = 'Q';
                rowResult.add(new String(arr));
            }
            res.add(rowResult);
            return;
        }
        for(int j = 0; j < n; j++) {
            boolean legal = true;
            for(int i = 0; i < row; i++) {
                int position = positions[i];
                if(position == j || j + row - i == position || j - row + i == position) {
                    legal = false;
                }
            }
            if(legal) {
                positions[row] = j;
                backtrack(positions, row + 1, res);
                positions[row] = -1;
            }
        }
    }
}