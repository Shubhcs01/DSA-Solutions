class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currRow = null;
        List<Integer> prevRow = null;
        
        for(int i=0; i<numRows; i++){
            currRow = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0 || j==i){
                    currRow.add(1);
                    continue;
                }
                currRow.add(prevRow.get(j-1)+prevRow.get(j));
            }
            ans.add(currRow);
            prevRow = currRow;
        }
        
        return ans;
    }
}