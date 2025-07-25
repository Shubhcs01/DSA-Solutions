class Solution {

    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>(); // only contains +ve nums

        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }

        if (set.isEmpty()) {
            return Arrays.stream(nums).max().getAsInt(); //max value is ans
        }
        return set.stream().mapToInt(Integer::intValue).sum(); // sum of set values
    }
}