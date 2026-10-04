class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {          // rows
            for (int j = 0; j < 9; j++) {      // cols
                char currVal = board[i][j];

                if (currVal == '.') {
                    continue;                  // empty cell, skip it
                }

                // Build the three "keys" for this cell
                String rowKey  = currVal + " found in row " + i;
                String colKey  = currVal + " found in col " + j;
                String gridKey = currVal + " found in grid " + i / 3 + "-" + j / 3;

                // Row check
                if (seen.contains(rowKey)) {
                    return false;
                }
                seen.add(rowKey);

                // Column check
                if (seen.contains(colKey)) {
                    return false;
                }
                seen.add(colKey);

                // 3x3 grid check
                if (seen.contains(gridKey)) {
                    return false;
                }
                seen.add(gridKey);
            }
        }

        return true;
    }
}