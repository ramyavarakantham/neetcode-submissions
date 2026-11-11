class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        getSubsets(nums, new ArrayList<>(), result, target, 0);
        return result;
    }

    void getSubsets(int[] nums, List<Integer> currSubset, List<List<Integer>> result, int target, int index){
        if(target == 0){
            result.add(new ArrayList<>(currSubset));
            return;
        }

        if(target < 0 || index >= nums.length){
            return;
        }

        currSubset.addLast(nums[index]);
        getSubsets(nums, currSubset, result, target-nums[index], index);
        currSubset.removeLast();
        getSubsets(nums, currSubset, result, target, index+1);
    }
}
