class Solution {
    public String makeFancyString(String s) {
        int i = 0;
        StringBuilder ans = new StringBuilder();
        while(i < s.length()){
            char ch = s.charAt(i);
            if(ans.length() == 0 || ch != s.charAt(i-1) || i < 2 || ch != s.charAt(i-2)){
                ans.append(ch);
            }
            i++;
        }
        return ans.toString();
    }
}