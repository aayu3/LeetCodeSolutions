package problem87;

class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        final char[] A = s1.toCharArray();
        final char[] B = s2.toCharArray();
        final int N = A.length;
        return search(A, B, 0, 0, N, new boolean[N][N][N + 1], new boolean[N][N][N + 1]);
    }

    private boolean search(char[] A, char[] B, int i, int j, int n, boolean[][][] dp, boolean[][][] visited) {
        if (visited[i][j][n]) {
            return dp[i][j][n];
        }
        visited[i][j][n] = true;
        if (n == 0) {
            dp[i][j][n] = true;
        } else if (n == 1) {
            dp[i][j][n] = A[i] == B[j];
        } else {
            for (int k = 1; k < n; k++) {
                // dp[i][j][k] && dp[i + k][j + k][n - k]
                boolean ff = search(A, B, i, j, k, dp, visited) && search(A, B, i + k, j + k, n - k, dp, visited);
                // dp[i][j + n - k][k] && dp[i + k][j][n - k]
                boolean fl = search(A, B, i, j + n - k, k, dp, visited) && search(A, B, i + k, j, n - k, dp, visited);
                if (ff || fl) {
                    dp[i][j][n] = true;
                    break;
                }
            }
        }
        return dp[i][j][n];
    }
}