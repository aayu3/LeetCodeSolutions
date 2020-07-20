package problem64;

class Solution {
    public int minPathSum(int[][] grid) {
        int i =0;
        for(i=1; i<grid[0].length; i++){
            grid[0][i] = grid[0][i-1]+grid[0][i];
        }
        for(i=1; i<grid.length; i++){
            grid[i][0] = grid[i-1][0]+grid[i][0];
        }
        int j =1;
        for( i=1; i<grid.length; i++){
            for(j=1; j<grid[0].length; j++){
                grid[i][j] = Math.min(grid[i-1][j]+grid[i][j], grid[i][j-1] + grid[i][j]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

}
