class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int[] row: dp) Arrays.fill(row,-1);
        return solve(0,0,m-1,n-1,dp,grid);
    }

    private int solve(int i, int j, int m, int n,int[][] dp,int[][] grid){
        //base
        if(i>m || j>n || grid[i][j]==1) return 0;
        if(i==m && j==n) return 1;
        if(dp[i][j] != -1) return dp[i][j];

        //options
        int way1 = solve(i, j+1,m,n,dp,grid); //right
        int way2 = solve(i+1, j,m,n,dp,grid); //down

        return dp[i][j] = way1 + way2;
    }
}