class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, target, ans, new ArrayList<>()); // 0th element
        return ans;
    }

    private void backtrack(int[] nums, int idx, int tar, List<List<Integer>> ans, List<Integer> list) {
        
        if(tar == 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        if(idx == nums.length || tar < 0) {
            return;
        }

        for(int i = idx; i < nums.length; i++){

            if(i!=idx && nums[i] == nums[i-1]){
                continue;
            }

            list.add(nums[i]);
            backtrack(nums, i+1, tar - nums[i], ans, list);
            list.remove(list.size()-1);
        }


    }
}