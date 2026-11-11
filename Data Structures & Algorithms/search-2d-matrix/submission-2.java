class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int low = 0;
        int high = (numRows * numCols)-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            int midRow = mid/numCols;
            int midCol = mid%numCols;
            //System.out.println(mid + " "+ midRow + " " + midCol);
            if(matrix[midRow][midCol] == target){
                return true;
            } else if(matrix[midRow][midCol] > target){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return false;
    }
}
