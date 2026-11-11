class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> hs = new HashSet<>();

        // Check if each row satisfies the condition
        for(int row = 0; row < 9; row++) {
            
            for(int col = 0; col < 9; col++){
                
                if(board[row][col] != '.'){
                    if(!hs.add(board[row][col] + " found in row " + row) || 
                    !hs.add(board[row][col] + " found in col "+ col) ||
                    !hs.add(board[row][col] + " found in grid " + row/3 + "-" + col/3)) {
                        return false;
                    }
                }
            }
        }
        return true;



    }
}
