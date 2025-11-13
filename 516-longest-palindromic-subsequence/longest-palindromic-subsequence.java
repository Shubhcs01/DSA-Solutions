class Solution {
    public int longestPalindromeSubseq(String s) {
        return longestCommonSubsequence(s, new StringBuilder(s).reverse().toString());
    }

    public int longestCommonSubsequence(String text1, String text2) {
    int[][] dp = new int[text1.length()][text2.length()];
    for(int[] row: dp) Arrays.fill(row,-1);
    return solve(text1.length()-1,text2.length()-1,text1,text2,dp);
    }

    private int solve(int i, int j, String str1, String str2, int[][] dp){
        //base
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(str1.charAt(i) == str2.charAt(j)){
            return dp[i][j] = 1 + solve(i - 1, j - 1,str1,str2,dp);
        }

        return dp[i][j] = 0 + Math.max(solve(i - 1, j, str1, str2,dp), solve(i, j - 1, str1, str2,dp));
    }
}