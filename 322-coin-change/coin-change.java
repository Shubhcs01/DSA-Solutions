class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int[] row: dp) Arrays.fill(row,-1);
        int res = solve(n-1,coins,amount,dp);
        if(res == (int)1e9) {
            return -1;
        } else 
         return res;
    }

    private int solve(int n, int[] coins, int tar, int[][] dp) {
        //base case
        if(tar == 0) return 0;
        if(n == 0){
            if(tar % coins[n] == 0){
                return tar / coins[n];
            } else {
                return (int)1e9;
            }
        }
        if(dp[n][tar] != -1) return dp[n][tar];

        int pick = (int)1e9;
        if(tar-coins[n] >= 0)
         pick = 1 + solve(n,coins,tar-coins[n],dp);

        int notpick = 0 + solve(n-1,coins,tar,dp);

        return dp[n][tar] = Math.min(pick,notpick);
    }
}