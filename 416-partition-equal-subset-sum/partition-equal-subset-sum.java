class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int num:nums) total+= num;

        if (total % 2 != 0) return false; // odd sum

        int target = total/2;
        Boolean[][] dp = new Boolean[nums.length+1][target+1];
        return solve(0,nums,target,dp);
    }

    private boolean solve(int idx, int[] nums, int tar, Boolean[][] dp){
        //base case
        if(idx == nums.length) return false; 
        if(tar == 0) return true;
        if(dp[idx][tar] != null) return dp[idx][tar];

        boolean pick = false;
        if(tar-nums[idx] >= 0)
         pick = solve(idx+1,nums,tar-nums[idx],dp);

        boolean notpick = solve(idx+1,nums,tar,dp);

        return dp[idx][tar] = pick || notpick;
    }
}