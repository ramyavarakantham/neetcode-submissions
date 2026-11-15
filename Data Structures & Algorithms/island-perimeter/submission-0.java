class Solution {
    public int islandPerimeter(int[][] grid) {
        int[] per = new int[]{0};
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1){
                    dfs(row, col, grid, per);
                }
            }
        }
        return per[0];
    }

    void dfs(int row, int col, int[][] grid, int[] per){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1){
            return;
        }
        grid[row][col] = -1;
        if(row <= 0 || grid[row-1][col] == 0){
            per[0] += 1;
        }
        if(row >= grid.length-1 || grid[row+1][col] == 0){
            per[0]  += 1;
        }
        if(col <= 0 || grid[row][col-1] == 0){
            per[0]  += 1;
        }
        if(col >= grid[0].length-1 || grid[row][col+1] == 0){
            per[0] += 1;
        }
        dfs(row-1, col, grid, per);
        dfs(row+1, col, grid, per);
        dfs(row, col-1, grid, per);
        dfs(row, col+1, grid, per);
    }
}