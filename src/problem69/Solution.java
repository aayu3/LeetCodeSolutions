package problem69;

class Solution {
    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        int startVal = 1;
        int endVal = x;
        while (startVal < endVal) {
            int medVal = startVal + (endVal - startVal) / 2;
            int result = x / medVal;
            if (result < medVal) {
                endVal = medVal;
            } else {
                startVal = medVal + 1;
            }
        }
        return startVal - 1;
    }
}