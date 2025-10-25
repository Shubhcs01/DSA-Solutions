class Solution {
    int triSum(int n) {
        return (n * (n + 1)) >> 1;
    }

    public int totalMoney(int days) {
        int w = days / 7;
        int d = days % 7;

        return triSum(days) - 42 * triSum(w - 1) - 6*w*d;
    }
}
