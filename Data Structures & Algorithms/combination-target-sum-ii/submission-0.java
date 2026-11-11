class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        getSubsets(candidates, target, new ArrayList<>(), result, 0);
        return result;
        
    }

    void getSubsets(int[] nums, int target, List<Integer> currSubset, List<List<Integer>> result, int index){
        if(target == 0){
            result.add(new ArrayList<>(currSubset));
            return;
        }

        if(target < 0 || index == nums.length){
            return;
        }

        currSubset.addLast(nums[index]);
        getSubsets(nums, target-nums[index], currSubset, result, index+1);
        currSubset.removeLast();
        int i = index+1;
        while(i < nums.length && nums[i] == nums[i-1]){
            i++;
        }
        getSubsets(nums, target, currSubset, result, i);
    }
}
