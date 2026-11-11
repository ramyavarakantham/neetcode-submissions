class Solution {
    public void islandsAndTreasure(int[][] grid) {
        // Find the treasure chests and add to Queue
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 0) {
                    q.offer(new int[]{row, col});
                }
            }
        } // whats added in the queue are treasure chests at level 0

        int level = 1;

        while(!q.isEmpty()){
            int qSize = q.size();
            for(int i = 0; i < qSize; i++){
                 int[] cell = q.poll();
                // add to queue their neighbors- if any neighbor is a land cell - update the value of the neighbor with level - to mark as seen 
                int row = cell[0];
                int col = cell[1];
                if(row > 0 && grid[row-1][col] == Integer.MAX_VALUE) {
                        grid[row-1][col] = level;
                        q.offer(new int[]{row-1, col});
                }
                if(row < grid.length-1 && grid[row+1][col] == Integer.MAX_VALUE){
                    grid[row+1][col] = level;
                    q.offer(new int[]{row+1, col});
                }
                if(col > 0 && grid[row][col-1] == Integer.MAX_VALUE){
                    grid[row][col-1] = level;
                    q.offer(new int[]{row, col-1});
                }
                if(col < grid[0].length-1 && grid[row][col+1] == Integer.MAX_VALUE){
                    grid[row][col+1] = level;
                    q.offer(new int[]{row, col+1});
                }
            }
            level++;
        }
        


    }
}
