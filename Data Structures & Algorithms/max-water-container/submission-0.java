class Solution {
    public int maxArea(int[] nums) {
        int i = 0;
        int j = nums.length -1;
        int maxAreaSoFar = 0; // area cannot be negative 
        while(i < j){
            int minHeight = Math.min(nums[i], nums[j]);
            int distance = j-i;
            int area = minHeight * distance;
            maxAreaSoFar = Math.max(maxAreaSoFar, area);
            // move away from shorter height
            if(nums[i] < nums[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxAreaSoFar;
        
    }
}
