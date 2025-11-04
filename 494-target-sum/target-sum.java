class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total=0;
        for(int n : nums) total += n;
        int[][] dp = new int[nums.length+1][2*total+1];
        for(int[] row: dp) Arrays.fill(row, Integer.MIN_VALUE);
        return solve(0,0,nums,target,dp, total);
    }

    private int solve(int idx, int currSum, int[]nums, int tar, int[][] dp, int offset){

        if(idx >= nums.length) {
            if(currSum == tar) return 1;
            else return 0;
        }
        if(dp[idx][currSum + offset] != Integer.MIN_VALUE) 
            return dp[idx][currSum + offset];

        int plus =  solve(idx+1, currSum + nums[idx], nums, tar,dp, offset);
        int minus = solve(idx+1, currSum - nums[idx], nums, tar,dp, offset);

        return dp[idx][currSum + offset] = plus + minus;
    }
}