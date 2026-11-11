class Solution {
    public int removeDuplicates(int[] nums) {
        int cloud = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[++cloud] = nums[i];
            }
        }
        return cloud+1;
    }
}