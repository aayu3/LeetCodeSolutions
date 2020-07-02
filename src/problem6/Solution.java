package problem6;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",1));
    }
    public static String convert(String s, int numRows) {
        if ((s.length() <= numRows) || (numRows == 1)) {
            return s;
        }
        char[] newStr = new char[s.length()];
        char[] oldStr = s.toCharArray();
        //just use a couple of examples to observe this rule
        int cycle = 2*(numRows-1);
        int[] quotaForRows = new int[numRows];
        //how many spaces in a current row that have been filled
        int[] rowCapacity = new int[numRows];
        for (int i = 0; i<cycle; i++) {
            if (i > numRows-1) {
                quotaForRows[(numRows-1)-(i%(numRows-1))] += (int) Math.ceil((double) (s.length() - i) / cycle);
            }
            else {
                    quotaForRows[i] += (int) Math.ceil((double) (s.length() - i) / cycle);
            }
        }
        for (int i = 0; i<oldStr.length; i++) {
            int rowNum = i % cycle;
            if (rowNum > (numRows-1)) {
                rowNum = numRows-1-(i%(numRows-1));
            }
            int newStrIndex = 0;
            for (int j = 0; j<rowNum; j++) {
                newStrIndex += quotaForRows[j];
            }
            newStrIndex += rowCapacity[rowNum];
            rowCapacity[rowNum] += 1;
            newStr[newStrIndex] = oldStr[i];
        }
        return new String(newStr);

    }
}
