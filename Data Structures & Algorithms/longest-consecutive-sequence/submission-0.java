class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for(int num:nums){
            hs.add(num);
        }
        int longestSequenceSoFar = 0;
        for(int num:nums){
            // If the curr num is the start of a new sequence
            if(!hs.contains(num-1)){
                int lenOfCurrSequence = 1;
                int nextNum = num+1;
                while(hs.contains(nextNum)){
                    lenOfCurrSequence++;
                    nextNum += 1;
                }
                longestSequenceSoFar = Math.max(longestSequenceSoFar, lenOfCurrSequence);
            }
        }

        return longestSequenceSoFar;
    }
}
