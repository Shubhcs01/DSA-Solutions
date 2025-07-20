class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        printSubsequence(nums,0,ans,temp);
        return ans;
    }

    private void printSubsequence(int[] nums, int i, List<List<Integer>> ans, List<Integer> temp){
        
        //base case
        if(i == nums.length){
            ans.add(new ArrayList<>(temp)); // ** Don't store temp directly, as it's a reference which is cont. changing
            return;
        }

        temp.add(nums[i]);
        printSubsequence(nums, i+1, ans,temp);
        temp.remove(temp.size()-1);
        printSubsequence(nums, i+1, ans,temp);
    }
}