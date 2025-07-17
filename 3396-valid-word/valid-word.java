class Solution {
    public boolean isValid(String word) {
        return validate(word);
    }

    private boolean validate(String str) {
        if (str.length() < 3) return false;

        int v = 0, c = 0;
        str = str.toLowerCase();

        for (char ch : str.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) return false;
            if ("aeiou".indexOf(ch) >= 0) {
                v++;
            } else if(!Character.isDigit(ch)) {
                c++;
            }
        }

        return v > 0 && c > 0;
    }
}