class Solution {

    public boolean isMatch(String text1, String text2) {
        Boolean[][] dp = new Boolean[text1.length()][text2.length()];
        return solve(text1.length()-1,text2.length()-1,text1,text2,dp);
    }

    private boolean solve(int i, int j, String str1, String pattern, Boolean[][] dp){
        // str1 = s
        // str2 = pattern

        //base
        //If pattern finished
        if (j < 0) {
            if(i < 0) return true;
            else return false;
        }

        //If s finished, remaining pattern must be all '*'
        if (i < 0) {
            for (int k = 0; k <= j; k++) {
                if (pattern.charAt(k) != '*') return false;
            }
            return true;
        }

        if(dp[i][j] != null) return dp[i][j];

        if(str1.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?'){
            return dp[i][j] = solve(i-1, j-1, str1, pattern, dp);
        } else if(pattern.charAt(j) == '*'){
            return dp[i][j] = solve(i-1, j, str1, pattern, dp) || solve(i, j-1, str1, pattern, dp);
        }

        return dp[i][j] = false;
    }
}