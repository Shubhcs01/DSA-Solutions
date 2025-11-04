class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(0,nums,target);
    }

    private int solve(int idx, int[]nums, int tar){

        if(idx >= nums.length) {
            if(tar == 0) return 1;
            else return 0;
        }

        int plus = solve(idx+1,nums,tar-nums[idx]);
        int minus = solve(idx+1,nums,tar+nums[idx]);

        return plus + minus;
    }
}