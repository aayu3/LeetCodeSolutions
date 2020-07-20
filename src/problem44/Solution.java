package problem44;

class Solution {
    public boolean isMatch(String s, String p) {
        int size1 = s.length(), size2 = p.length();
        boolean[][] dp = new boolean[size1 + 1][size2 + 2];
        dp[0][0] = true;
        for (int i = 1; i <= size2; ++i){
            if (p.charAt(i - 1) == '*'){
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i <= size1; ++i){
            for (int j = 1; j <= size2; ++j){
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (sc == pc || pc == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*'){
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[size1][size2];
    }
}