class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        getSubsets(nums, new ArrayList<>(), result, 0);
        return result;
    }

    void getSubsets(int[] nums, List<Integer> subsetsForCurrIndex, List<List<Integer>> result, int index){
        if(index == nums.length){
            result.add(new ArrayList<>(subsetsForCurrIndex));
            return;
        }

        subsetsForCurrIndex.addLast(nums[index]);
        getSubsets(nums, subsetsForCurrIndex, result, index+1);

        subsetsForCurrIndex.removeLast();
        getSubsets(nums, subsetsForCurrIndex, result, index+1);
    }
}
