class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int countOnes = 0;
        
        for (int num : nums) {
            if (num == 1) countOnes++;
        }

        // Already have 1's
        if (countOnes > 0) return n - countOnes;

        // Need to create 1
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int g = nums[i];
            for (int j = i + 1; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    minDist = Math.min(minDist, j - i);
                    break; // no need to check further; gcd can't get smaller
                }
            }
        }

        if (minDist == Integer.MAX_VALUE) return -1;

        // Total operations = (to make one 1) + (to spread it)
        return minDist + (n - 1);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
