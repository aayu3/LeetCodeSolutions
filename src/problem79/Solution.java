package problem79;

class Solution {
    public boolean exist(char[][] board, String word) {
        boolean out = false;
        for(int i=0; i< board.length; i++) {
            for(int j=0; j< board[0].length; j++) {
                if(board[i][j] == word.charAt(0))
                    out = existUtil(board, word, i, j, 0);
                if(out)
                    return out;
            }
        }
        return out;
    }

    public boolean existUtil(char[][] board, String word, int i, int j, int index) {

        if(i< 0 || i >= board.length
                || j < 0 || j >= board[0].length
                || board[i][j] == '$' || index >= word.length()
                ||word.charAt(index) != board[i][j]) {

            return false;
        }

        if((index+ 1) == word.length()) {
            return true;
        }

        char ch = board[i][j];
        board[i][j] = '$';

        boolean out = existUtil(board, word, i-1, j, index+1) || existUtil(board, word, i+1, j, index+1) ||
                existUtil(board, word, i, j-1, index+1) || existUtil(board, word, i, j+1, index+1);

        board[i][j] = ch;

        return out;
    }
}
