class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(board, word, i, j, 0, visited))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int i, int j, int k, int[][] visited) {
        //base case
        if(k == word.length()){
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(k)
                || visited[i][j] == 1) {
            return false;
        }

        k++;
        visited[i][j] = 1;
        boolean ans = backtrack(board, word, i + 1, j, k, visited) || backtrack(board, word, i - 1, j, k, visited) || backtrack(board, word, i, j + 1, k, visited) || backtrack(board, word, i, j - 1, k, visited);
        visited[i][j] = 0;

        return ans;
    }
}