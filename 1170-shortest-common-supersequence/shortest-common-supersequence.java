class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        String lcsStr = lcs(str1,str2);
        StringBuilder sb = new StringBuilder();
        int i=0, j=0, k=0;

        while(k < lcsStr.length()){
            while(i < str1.length() && str1.charAt(i) != lcsStr.charAt(k)){
                sb.append(str1.charAt(i));
                i++;
            }

            while(j < str2.length() && str2.charAt(j) != lcsStr.charAt(k)){
                sb.append(str2.charAt(j));
                j++;
            }

            sb.append(lcsStr.charAt(k));
            k++;
            i++;
            j++;
        }

        // append remaining leftover chars
        while (i < str1.length()) sb.append(str1.charAt(i++));
        while (j < str2.length()) sb.append(str2.charAt(j++));

        return sb.toString();
    }

    private String lcs(String text1, String text2) {
        String[][] dp = new String[text1.length()][text2.length()];
        return solve(text1.length()-1,text2.length()-1,text1,text2,dp);
    }

    private String solve(int i, int j, String str1, String str2, String[][] dp){
        //base
        if(i < 0 || j < 0) return "";
        if(dp[i][j] != null) return dp[i][j];

        if(str1.charAt(i) == str2.charAt(j)){
            return dp[i][j] = solve(i - 1, j - 1,str1,str2,dp) + str1.charAt(i);
        }

        String op1 = solve(i - 1, j, str1, str2,dp);
        String op2 = solve(i, j - 1, str1, str2,dp);

        return dp[i][j] = (op1.length() >= op2.length()) ? op1 : op2; // return longest string
    }
}