class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        for(int i=0; i<strs.length; i++){
            for(int j=0; j<m+1; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(0, m, n, strs,dp);
    }

    private int solve(int i, int m, int n, String[] strs,int[][][]dp) {
        // base case
        if (i == strs.length) return 0;
        if(dp[i][m][n] != -1) return dp[i][m][n];

        // count zeros and ones in current string
        int zeros = 0, ones = 0;
        for (char ch : strs[i].toCharArray()) {
            if (ch == '0') zeros++;
            else ones++;
        }

        int notPick = 0 + solve(i + 1, m, n, strs,dp);
        int pick = 0;
        if (m - zeros >= 0 && n - ones >= 0) {
            pick = 1 + solve(i + 1, m - zeros, n - ones, strs,dp);
        }

        return dp[i][m][n] = Math.max(pick, notPick);
    }
}
