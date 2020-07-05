package problem10;

import java.util.Arrays;

class Solution {
    private static boolean matrixDone = false;
    private static boolean returnValue = false;

    public static void main(String[] args) {
        System.out.println(isMatch("aaa", "ab*a*c*a"));
    }

    public static boolean isMatch(String s, String p) {
        if (s == null || s.equals("")) {
            return true;
        } else {
            //this just checks if we have any occurences of multiple '*' in a row and replaced them with one '*'
            while (p.contains("**")) {
                p = p.replace("**", "*");
            }
            //if begins with '*' get rid of it
            if (p.charAt(0) == '*') {
                p = p.substring(1);
            }
            if (p == null || p.equals("")) {
                return false;
            }
            //pattern is height, string is width
            //-1 means false, 0 means null, 1 means true
            int[][] dpMatrix = new int[p.length()][s.length()];
            doDP(dpMatrix, s, p, 0, 0);
            for (int i = 0; i < p.length(); i++) {
                System.out.println(Arrays.toString(dpMatrix[i]));
            }
            return returnValue;
        }


    }

    public static void doDP(int[][] dpMatrix, String input, String pattern, int rowIndex, int columnIndex) {
        if (!matrixDone) {
            //check whether entry is already evaluated or not
            if (dpMatrix[rowIndex][columnIndex] == 0) {
                char curI = input.charAt(columnIndex);
                char curP = pattern.charAt(rowIndex);
                if (rowIndex == pattern.length()-1) {
                    if (curI == curP || curP == '.') {
                        matrixDone = true;
                        returnValue = true;
                    }
                    else if (curP == '*' && pattern.charAt(rowIndex-1) == curI) {
                        matrixDone = true;
                        returnValue = true;
                    }
                }
            }
        }
    }
}