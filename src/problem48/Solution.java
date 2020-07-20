package problem48;

class Solution {
    public void rotate(int[][] matrix) {

        for(int r = 0 ; r < matrix.length ; r++){
            for(int c = 0 ; c < r ; c++){
                int temp =  matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }

        for(int i = 0 ; i < matrix.length ; i++){
            int s = 0 ;
            int ep = matrix.length-1;

            while( s <= ep ){
                int temp = matrix[i][s];
                matrix[i][s] = matrix[i][ep];
                matrix[i][ep] = temp;
                s++;
                ep--;
            }
        }
    }
}