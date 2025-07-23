class Solution {
    public int maximumGain(String s, int x, int y) {

        if (y > x) {
            return helper(s, y, x, 'b', 'a');
        } else {
            return helper(s, x, y, 'a', 'b');
        }
    }

    private int helper(String s, int firstScore, int secondScore, char firstChar, char secondChar) {
        StringBuilder sb = new StringBuilder();
        int totalScore = 0;

        // remove higher priority pair
        for (char c : s.toCharArray()) {
            int len = sb.length();
            if (len > 0 && sb.charAt(len - 1) == firstChar && c == secondChar) {
                sb.deleteCharAt(len - 1);
                totalScore += firstScore;
            } else {
                sb.append(c);
            }
        }

        // remove the other pair
        StringBuilder finalSb = new StringBuilder();
        for (char c : sb.toString().toCharArray()) {
            int len = finalSb.length();
            if (len > 0 && finalSb.charAt(len - 1) == secondChar && c == firstChar) {
                finalSb.deleteCharAt(len - 1);
                totalScore += secondScore;
            } else {
                finalSb.append(c);
            }
        }

        return totalScore;
    }
}
