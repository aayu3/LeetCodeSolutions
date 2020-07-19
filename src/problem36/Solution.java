package problem36;

import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int row=0; row < board.length; row++){
            if(!checkRow(board, row)){
                return false;
            }
            if(!checkColumn(board, row)){
                return false;
            }
        }
        for(int row=0; row < board.length; row+=3){
            for(int column=0; column < board.length; column+=3){
                if(!checkCube(board, row, column)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkRow(char[][] board, int row){
        Set<Character> set = new HashSet<>();
        int column = 0;
        while(column < 9) {
            if(board[row][column] != '.' && set.add(board[row][column]) == false) {
                return false;
            }
            column++;
        }
        return true;
    }

    public boolean checkColumn(char[][] board, int row){
        Set<Character> set = new HashSet<>();
        int column = 0;
        while(column < 9) {
            if(board[column][row] != '.' && set.add(board[column][row]) == false) {
                return false;
            }
            column++;
        }
        return true;
    }

    public boolean checkCube(char[][] board, int row, int column){
        Set<Character> set = new HashSet<>();
        int temp = column;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(board[row][temp] != '.' && set.add(board[row][temp]) == false) {
                    return false;
                }
                temp++;
            }
            temp = column;
            row++;
        }
        return true;
    }
}