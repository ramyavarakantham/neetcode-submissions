class Solution {
    public int removeElement(int[] nums, int val) {
        int cloud = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[cloud+1] = nums[i];
                cloud += 1;
            }
        }
        return cloud+1;
    }
}