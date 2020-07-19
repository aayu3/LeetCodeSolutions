package problem37;

class Solution {
    public void solveSudoku(char[][] board)
    {
        helper(board,0,0);
    }

    private static boolean helper(char[][] board,int row,int col)
    {
        if(row==9)
            return true;

        if(col==9)
            return helper(board,row+1,0);

        if(board[row][col]!='.')
            return helper(board,row,col+1);
        else
        {
            for(int i=1;i<10;i++)
                if(check(board,row,col,(char)(i+'0')))
                {
                    board[row][col]=(char)(i+'0');
                    if(helper(board,row,col+1))
                        return true;
                    board[row][col]='.';
                }
        }
        return false;
    }

    private static boolean check(char board[][],int start,int end,char c)
    {
        for(int i=0;i<9;i++)
            if(board[start][i]==c||board[i][end]==c)
                return false;

        int a=start/3,b=end/3;

        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(board[3*a+i][3*b+j]==c)
                    return false;

        return true;
    }
}