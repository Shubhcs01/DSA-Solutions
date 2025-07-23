class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int tar) {
            
        List<List<Integer>> ans = new ArrayList<>();
        f(arr,0,tar,ans,new ArrayList<>());
        return ans;
        
    }
    
    void f(int[] arr,int idx, int tar, List<List<Integer>> ans, List<Integer> list){
        
        if(idx == arr.length){
            if(tar == 0) 
                ans.add(new ArrayList<>(list));
            return;
        }

        if(arr[idx] <= tar){
            //pick
            list.add(arr[idx]);
            f(arr,idx,tar-arr[idx],ans,list);
            list.remove(list.size()-1);
        }

        //not pick
        f(arr,idx+1,tar,ans,list);
        
    }
}