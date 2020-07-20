package problem59;

class Solution {
    public int[][] generateMatrix(int n) {
        int [][] grid = new int[n][n];
        int value = 1;
        int sqr = n*n;
        int row1 = 0;
        int col1 = 0;
        int row2 = n-1;
        int col2 = n-1;
        while(value <= sqr){
            for(int j = col1; j <= col2; j++){
                grid[row1][j] = value++;
            }
            for(int i = row1 + 1; i <= row2; i++){
                grid[i][col2] = value++;
            }
            for(int j = col2-1; j >= col1; j--){
                grid[row2][j] = value++;
            }
            for(int i = row2-1; i >= row1+1; i--){
                grid[i][col1] = value++;
            }
            col1++;
            col2--;
            row1++;
            row2--;

        }
        return grid;
    }
}