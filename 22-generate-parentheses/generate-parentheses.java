class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(sb, n * 2, ans);
        return ans;
    }

    private void backtrack(StringBuilder sb, int n, List<String> ans) {
        //base case
        if (sb.length() == n) {
            if (isValid(sb.toString())) {
                ans.add(sb.toString());
            }
            return;
        }

        backtrack(sb.append('('), n, ans);
        sb.deleteCharAt(sb.length() - 1);
        backtrack(sb.append(')'), n, ans);
        sb.deleteCharAt(sb.length() - 1);
    }

    private boolean isValid(String str) {
        Stack<Character> st = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (st.size() > 0 && ch == ')' && st.peek() == '(') {
                st.pop();
                continue;
            }
            st.push(ch);
        }
        return st.isEmpty();
    }
}