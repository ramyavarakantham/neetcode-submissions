class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            //skip duplicates for target
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = -nums[i];
            int j = i+1;
            int k = nums.length -1;
            while(j < k){
                if(nums[j] + nums[k] == target){
                    List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                    result.add(triplet);

                    j++;
                    while(j < k && nums[j] == nums[j-1]){
                        j++;
                    }

                    k--;
                    while(j < k && nums[k] == nums[k+1]){
                        k--;
                    }

                } else if(nums[j] + nums[k] > target){
                    k--;
                    while(j < k && nums[k] == nums[k+1]){
                        k--;
                    }
                } else {
                    j++;
                    while(j < k && nums[j] == nums[j-1]){
                        j++;
                    }
                }
            }
        }

        return result;
        
    }
}
