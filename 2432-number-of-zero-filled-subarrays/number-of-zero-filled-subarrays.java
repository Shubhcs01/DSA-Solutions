class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long cnt = 0, ans = 0;
        for (int n : nums) {
            if (n == 0) {
                cnt++;
            } else {
                ans += cnt * (cnt + 1) / 2;
                cnt = 0;
            }
        }
        ans += cnt * (cnt + 1) / 2;
        return ans;
    }
}