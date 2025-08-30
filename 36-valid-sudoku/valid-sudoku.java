public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>(); // Map <(row or col) -> [values]>
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> sqs = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.')
                    continue;
                String squareIndex = (r / 3) + "," + (c / 3);
                if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]) ||
                        cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]) ||
                        sqs.computeIfAbsent(squareIndex, k -> new HashSet<>()).contains(board[r][c])) {
                    return false;
                }
                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                sqs.get(squareIndex).add(board[r][c]);
            }
        }
        return true;
    }
}