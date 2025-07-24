class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, target, 0, ans, new ArrayList<>());
        return ans;
    }

    private void helper(int[] nums, int i, int tar, int sum, List<List<Integer>> ans, List<Integer> list) {
        //base case
        if(sum == tar){
            ans.add(new ArrayList<>(list));
            return;
        }

        if(i == nums.length || sum > tar) {
            return;
        }

        list.add(nums[i]);
        sum += nums[i];
        helper(nums, i, tar, sum, ans, list);

        list.remove(list.size()-1);
        sum -= nums[i];
        if(i+1 < nums.length) helper(nums, i+1, tar, sum, ans, list);
    }
}