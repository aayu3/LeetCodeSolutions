package problem91;

class Solution {
    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') return 0;

        int[] dp = {1, (s.charAt(0) == '0')? 0 : 1};
        int flag = 1;

        for (int i = 2; i <= s.length(); i++) {
            int n2 = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            int sum = 0;
            if (s.charAt(i - 1) != '0')
                sum += dp[flag];
            if (n2 >= 10 && n2 <= 26)
                sum += dp[flag^1];

            flag ^= 1;
            dp[flag] = sum;
        }

        return dp[flag];
    }
}