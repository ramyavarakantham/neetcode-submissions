class Solution {
    public int findMin(int[] nums) {
        // find min in unsorted search space- figure out which half is unsorted
        int low = 0;
        int high = nums.length -1;
        while(low < high){
            int mid = low + (high-low)/2;
            if(nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return nums[high];
    }
}
