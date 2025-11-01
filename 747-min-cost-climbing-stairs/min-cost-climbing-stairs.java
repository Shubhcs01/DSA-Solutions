class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp,-1);
       return Math.min(fun(0, cost,dp), fun(1, cost,dp));
    }

    private int fun(int idx, int[]cost, int[] dp){

        if(idx >= cost.length) return 0;
        if(dp[idx] != -1) return dp[idx];

        int cost1 = fun(idx+1,cost, dp) + cost[idx];
        int cost2 = fun(idx+2,cost, dp) + cost[idx];

        return dp[idx] = Math.min(cost1,cost2);

    }
}