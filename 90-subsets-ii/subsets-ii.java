class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,0,ans,new ArrayList<>()); // O(2^n * n)
        return ans;
    }

    private void backtrack(int[] nums, int idx, List<List<Integer>> ans, List<Integer> list) {
        ans.add(new ArrayList<>(list)); // O(n)

        for(int i = idx; i<nums.length; i++){
            if(i!=idx && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            backtrack(nums,i+1,ans,list);
            list.remove(list.size()-1);
        }
    }
}