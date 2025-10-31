class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return fun(nums.length-1,nums,dp);
    }

    public int fun(int n, int[] nums, int[] dp){
        ///base case
        if(n == 0) return nums[0];
        if(n < 0) return 0;
        if(dp[n] != -1) return dp[n];

        int pickfirst = nums[n] + fun(n-2,nums,dp);
        int notpickfirst = 0 + fun(n-1,nums,dp);
        return dp[n] = Math.max(pickfirst, notpickfirst);
    }
}