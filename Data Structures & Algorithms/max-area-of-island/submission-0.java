class Solution {
    int currArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1){
                    dfs(row, col, grid);
                    maxArea = Math.max(maxArea, currArea);
                    currArea = 0;
                }
            }
        }
        return maxArea;
        
    }

    void dfs(int row, int col, int[][] grid){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0){
            return;
        }
        if(grid[row][col] == 1){
            currArea++;
            grid[row][col] = 0;
            dfs(row-1, col, grid);
            dfs(row+1, col, grid);
            dfs(row, col-1, grid);
            dfs(row, col+1, grid);
        }
    }
}
