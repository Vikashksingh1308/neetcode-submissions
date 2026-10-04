class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> xs = new HashSet<>(); // this is for row
        HashSet<Integer> ys = new HashSet<>(); // this is for col


        // Find any zero and remember the coordinates
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j<matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    xs.add(i);
                    ys.add(j);
                }
            }
        }

        // Set the entire row of x to zero
        for(int x: xs){
            for(int i = 0; i< matrix[0].length; i++){
                matrix[x][i] = 0;
            }
        }

        // Set the entire column y to zero
        for(int y : ys){
            for(int i = 0; i<matrix.length; i++){
                    matrix[i][y] = 0;
            }
        }
    }
}