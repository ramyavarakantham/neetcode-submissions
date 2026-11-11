class Solution {
    public int removeElement(int[] nums, int val) {
        int cloud = -1;
        for(int i=0; i < nums.length; i++){
            if(nums[i] != val){
                cloud++;
                nums[cloud] = nums[i];
            }
        }
        return cloud+1;
    }
}