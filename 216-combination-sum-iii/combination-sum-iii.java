class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        backtrack(nums,0,n,k,ans,new ArrayList<>());
        return ans;
    }

    private void backtrack(int[] nums, int idx, int tar, int len, List<List<Integer>> ans, List<Integer> list) {
        //base case
        if(tar < 0 || len < 0 ) {
            return;
        }

        if(tar == 0 && len == 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = idx; i<nums.length; i++){
            list.add(nums[i]);
            backtrack(nums,i+1,tar-nums[i],len-1,ans,list);
            list.remove(list.size()-1);
        }
    }
}