package problem50;

class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == Integer.MIN_VALUE){
            x = x * x;
            n = n/2;
        }

        if(n < 0) {
            n = -n;
            x = 1/x;
        }

        double temp = myPow(x,n/2);
        return (n%2 == 0) ? temp*temp : x *  temp*temp;
    }
}