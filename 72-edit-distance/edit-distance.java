class Solution {

    public int minDistance(String text1, String text2) { // LCS variation + String Matching
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] row: dp) Arrays.fill(row,-1);
        return solve(text1.length()-1,text2.length()-1,text1,text2,dp);
    }

    private int solve(int i, int j, String str1, String str2, int[][] dp){
        //base
        if(i < 0) return j+1; // str1 exhausted -> create rest in str1
        if(j < 0) return i+1; // str2 exhausted -> delete rest in str1
        if(dp[i][j] != -1) return dp[i][j];

        if(str1.charAt(i) == str2.charAt(j)){
            return dp[i][j] = 0 + solve(i - 1, j - 1,str1,str2,dp);
        }

        // not match

        int insert = 1 + solve(i, j-1, str1, str2, dp);
        int delete = 1 + solve(i-1, j, str1, str2, dp);
        int replace = 1 + solve(i-1, j-1, str1, str2, dp);

        return dp[i][j] = Math.min(Math.min(insert,delete),replace); //minimun operation
    }
}