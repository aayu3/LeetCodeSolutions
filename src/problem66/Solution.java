package problem66;

class Solution {
    public int[] plusOne(int[] digits) {
        int l = digits.length;
        digits[l-1] += 1;
        for (int i = 0; i < l; i ++){
            if (digits[l-1-i] == 10){
                if (l-1-i == 0){
                    digits[l-1-i] = 0;
                    int[] rArray = new int[l+1];
                    rArray[0] = 1;
                    System.arraycopy(digits, 0, rArray, 1,l);
                    return rArray;
                }
                digits[l-1-i] = 0;
                digits[l-2-i] ++;
            }
        }

        return digits;
    }
}