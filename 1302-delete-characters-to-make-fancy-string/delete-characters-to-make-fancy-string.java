class Solution {
    public String makeFancyString(String s) {

        if(s.length() < 3) return s;

        StringBuilder ans = new StringBuilder();
        ans.append(s.charAt(0)).append(s.charAt(1));

        int i = 2;
        while(i < s.length()){
            char ch = s.charAt(i);
            if(ch != s.charAt(i-1) || ch != s.charAt(i-2)){
                ans.append(ch);
            }
            i++;
        }
        return ans.toString();
    }
}