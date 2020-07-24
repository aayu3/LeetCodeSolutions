package problem97;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        final int M = s1.length();
        final int N = s2.length();
        final int K = s3.length();
        // corner case
        if (M + N != K) {
            return false;
        }
        // initial state
        boolean[][] dp = new boolean[2][N + 1];
        dp[0][0] = true;
        for (int j = 1; j <= N; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        // induction rule
        for (int i = 1; i <= M; i++) {
            dp[i % 2][0] = dp[(i - 1) % 2][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
            for (int j = 1; j <= N; j++) {
                if (dp[(i - 1) % 2][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1) || dp[i % 2][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
                    dp[i % 2][j] = true;
                } else {
                    dp[i % 2][j] = false;
                }
            }
        }
        return dp[M % 2][N];
    }
}