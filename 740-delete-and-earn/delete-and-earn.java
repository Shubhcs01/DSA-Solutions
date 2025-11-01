class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        for(int num : nums){
            maxValue = Math.max(maxValue,num);
        }

        int[] points = new int[maxValue+1];

        //freq array
        for(int num: nums){
            points[num] += num;
        }

        //[0,0,4,9,4] - points[] -> can't take adjacent points -> house robber

        int[] dp = new int[points.length+1];
        Arrays.fill(dp,-1);
        return fun(points.length-1,points,dp);
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