class Solution {
        public int numDistinct(String text1, String text2) {
         int[][] dp = new int[text1.length()][text2.length()];
        for(int[] row: dp) Arrays.fill(row,-1);
        return solve(text1.length()-1, text2.length()-1, text1,text2,dp);
    }

    private int solve(int i, int j, String str1, String str2, int[][] dp){
        //base
        if(j < 0) return 1;
        if(i < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(str1.charAt(i) == str2.charAt(j)){
            return dp[i][j] = solve(i - 1, j,str1,str2,dp) + solve(i - 1, j - 1,str1,str2,dp);
        }

        return dp[i][j] = solve(i - 1, j, str1, str2, dp);
    }
}