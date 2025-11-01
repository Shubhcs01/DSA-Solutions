class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return solve(0,s, s.length(),dp);
    }

    private int solve(int i, String s, int n, int[] dp) {

        if(i == n) return 1; // reached end -> valid encoding
        if(s.charAt(i) == '0') return 0; // invalid code starting with 0
        if(dp[i] != -1) return dp[i];

        int partition1 = solve(i+1,s,n,dp);
        int partition2 = 0;
        
        if (i+1 < n) {
            int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
            if (num >= 10 && num <= 26) {
                partition2 = solve(i+2, s, n,dp);
            }
        }

        return dp[i] = partition1 + partition2;
    }
}