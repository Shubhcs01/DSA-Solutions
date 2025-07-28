class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(s, 0, ans, new ArrayList<>());
        return ans;
    }

    private void backtrack(String s, int idx, List<List<String>> ans, List<String> list) {
        //base case
        if(idx == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            String substr = s.substring(idx, i + 1); // (0,0) (0,1) ... 
            if (isPalindrome(substr)) {
                list.add(substr);
                backtrack(s, i+1, ans, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str){
        int left = 0, right = str.length()-1;
        while(left <= right) {
            if(str.charAt(left) != str.charAt(right)) return false;
            left++; 
            right--;
        }
        return true;
    }
}