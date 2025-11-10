class Solution {
    public int minFallingPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Integer[][] dp = new Integer[m + 1][n + 1];
        int min = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            min = Math.min(min, solve(0, j, m-1, n-1, dp, grid));
        }
        return min;
    }

    private int solve(int i, int j, int m, int n, Integer[][] dp, int[][] grid) {
        //base
        if (i > m || j > n || j<0) return (int) 1e7;
        if (i == m ) return grid[i][j];
        if (dp[i][j] != null) return dp[i][j];

        int way1 = grid[i][j] + solve(i + 1, j - 1, m, n, dp, grid);
        int way2 = grid[i][j] + solve(i + 1, j, m, n, dp, grid);
        int way3 = grid[i][j] + solve(i + 1, j + 1, m, n, dp, grid);

        return dp[i][j] = Math.min(Math.min(way1, way2),way3);
    }
}