class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet();

       for(int i = 0; i< 9; i++){ //rows: outer for loop
        for(int j = 0; j < 9; j++){ //cols: inner for loop
        char curr_val = board[i][j];
        if(curr_val != '.') {
            if(
                (!seen.add(curr_val + " found in row " + i)) || 
                (!seen.add(curr_val + " found in col " + j)) || 
                (!seen.add(curr_val + " found in grid " + i/3 + "-" + j/3))
            ){
                return false;
            }
        } 
        }

       }
       return true; 
    }
}
