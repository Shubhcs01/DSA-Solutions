class Solution {
    static final int MOD = 1000000007;

    public int numDecodings(String s) {
        long[] dp = new long[s.length()+1];
        Arrays.fill(dp,-1);
        return (int) solve(0,s, s.length(),dp);
    }

    private long solve(int i, String s, int n, long[] dp) {

        if(i == n) return 1; // reached end -> valid encoding
        if(s.charAt(i) == '0') return 0; // invalid code starting with 0
        if(dp[i] != -1) return dp[i];

        char ch1 = s.charAt(i);

        // 1-character decode
        long partition1 = 0;
        if(ch1 == '*'){
            partition1 =  (9 * solve(i+1,s,n,dp)) % MOD;
        } else {
            partition1 = solve(i+1,s,n,dp) % MOD;
        }

        // 2-character decode
        long partition2 = 0;
        if (i+1 < n) {
            char ch2 = s.charAt(i + 1);
            if(ch1=='*' && ch2=='*'){
                partition2 = (15 * solve(i+2, s, n,dp)) % MOD;
            } else if (ch1 == '*'){
                if(ch2 >= '0' && ch2 <= '6'){
                    partition2 = (2 * solve(i+2, s, n,dp)) % MOD; // both 1 0r 2 possible
                } else {
                    partition2 = solve(i+2, s, n,dp) % MOD;
                }
            } else if(ch2 == '*'){
                if(ch1=='1'){
                    partition2 = (9 * solve(i+2, s, n,dp)) % MOD;
                } else if(ch1=='2'){
                    partition2 = (6 * solve(i+2, s, n,dp)) % MOD;
                }
            } else {
                int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
                if (num >= 10 && num <= 26) {
                    partition2 = solve(i+2, s, n,dp);
                }
            }
        }

        return dp[i] = (partition1 + partition2) % MOD;
    }
}