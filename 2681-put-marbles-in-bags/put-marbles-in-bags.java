class Solution {

    public long putMarbles(int[] weights, int k) {

        int n = weights.length;
        int[] pairWeights = new int[weights.length-1];
        
        for (int i = 0; i < weights.length-1; i++) {
            pairWeights[i] = weights[i] + weights[i+1];
        }

        //sort only the first (n - 1) elems
        Arrays.sort(pairWeights, 0, n-1);

        long res = 0L;
        for (int i = 0; i < k-1; i++) {
            res += pairWeights[n-2-i] - pairWeights[i];
        }

        return res;
    }
}