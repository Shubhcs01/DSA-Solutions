class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        int i = 0, j = 0;
        int max = 0, sum = 0;

        // Sliding window
        while (j < nums.length) {

            // Shrink window
            while (seen.contains(nums[j])) {
               seen.remove(nums[i]);
               sum -= nums[i];
               i++;
            }

            seen.add(nums[j]);
            sum += nums[j];
            max = Math.max(max,sum);
            j++;
        }

        return max;
    }
}