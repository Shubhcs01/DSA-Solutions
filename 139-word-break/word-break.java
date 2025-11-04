class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict); // for O(1) lookup
        Boolean[] dp = new Boolean[s.length()+1]; // use Boolean class, bydefault null values
        return solve(0,s,dict,dp);
    }

    private boolean solve(int idx, String str, Set<String> set, Boolean[] dp){
        if(idx == str.length()) return true;
        if(dp[idx] != null) return dp[idx];

        for(int j = idx+1; j<=str.length(); j++){
            String substr = str.substring(idx,j);
            if(set.contains(substr) && solve(j, str, set,dp)){
                return dp[idx] = true;
            }
        }

        return dp[idx] = false;
    }
}