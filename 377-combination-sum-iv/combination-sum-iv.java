class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(target==0) return 0;
        int[][] dp = new int[nums.length+1][target+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return solve(0, nums,target,dp);
    }

    private int solve(int idx, int[] nums, int tar, int[][] dp){

        if(tar == 0 ) return 1;
        if(idx >= nums.length || tar < 0) return 0;
        if(dp[idx][tar] != -1) return dp[idx][tar];

        int pickways = solve(0, nums, tar-nums[idx], dp); // re-start when taking
        int notpickways = solve(idx + 1,nums, tar, dp);

        return dp[idx][tar] = (pickways + notpickways);

    }
}