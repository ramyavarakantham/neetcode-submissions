class Solution {
    
    public int numIslands(char[][] grid) {
        // When you land at a 1, increase the island count and we need to explore the entire island and mark it as visited- all the neighbors- given they are within the bounds of the matrix
        int numOfIslands = 0;
        for(int row = 0; row< grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == '1'){
                    numOfIslands++;
                    dfs(row, col, grid);
                }
            }
        }
        return numOfIslands;
    }

    void dfs(int row, int col, char[][] grid){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0'){
            return;
        }
        if(grid[row][col] == '1'){
            grid[row][col] = '0'; // mark this as visited
            dfs(row-1, col, grid);
            dfs(row+1, col, grid);
            dfs(row, col-1, grid);
            dfs(row, col+1, grid);
        }

    }
}
