class Solution {
    public int orangesRotting(int[][] grid) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 2){
                    q.offer(new int[]{row, col});
                } else if (grid[row][col] == 1){
                    fresh++;
                }
            }
        }

        int numOfMinutes = 0;

        while(fresh > 0 && !q.isEmpty()){
            numOfMinutes++;
            int qSize = q.size();
            for(int i = 0; i < qSize; i++){
                int[] currRottenCell = q.poll();
                int row = currRottenCell[0];
                int col = currRottenCell[1];
                if(row > 0 && grid[row-1][col] == 1){
                    grid[row-1][col] = 2;
                    q.offer(new int[]{row-1, col});
                    fresh--;
                }
                if(row < grid.length-1 && grid[row+1][col] == 1){
                    grid[row+1][col] = 2;
                    q.offer(new int[]{row+1, col});
                    fresh--;
                }
                if(col > 0 && grid[row][col-1] == 1){
                    grid[row][col-1] = 2;
                    q.offer(new int[]{row, col-1});
                    fresh--;
                }
                if(col < grid[0].length-1 && grid[row][col+1] == 1){
                    grid[row][col+1] = 2;
                    q.offer(new int[]{row, col+1});
                    fresh--;
                }
            }
        }
        return fresh == 0? numOfMinutes: -1;
    }
}
