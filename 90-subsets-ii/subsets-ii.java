class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        backtrack(nums,0,set,new ArrayList<>());
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

    private void backtrack(int[] nums, int i, Set<List<Integer>> ans, List<Integer> list) {
        //base case
        if(i == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[i]);
        backtrack(nums,i+1,ans,list); // pick

        list.remove(list.size()-1);
        backtrack(nums,i+1,ans,list); // not pick
    }
}