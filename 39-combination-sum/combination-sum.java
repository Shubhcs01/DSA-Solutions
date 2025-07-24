class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, target, ans, new ArrayList<>());
        return ans;
    }

    private void backtrack(int[] nums, int i, int tar, List<List<Integer>> ans, List<Integer> list) {
        //base case
        if(tar == 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        if(i == nums.length || tar < 0) {
            return;
        }

        list.add(nums[i]);
        backtrack(nums, i, tar - nums[i], ans, list);

        list.remove(list.size()-1);
        backtrack(nums, i+1, tar, ans, list);
    }
}