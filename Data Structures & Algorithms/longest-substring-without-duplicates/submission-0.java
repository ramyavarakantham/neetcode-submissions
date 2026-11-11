class Solution {
    public int lengthOfLongestSubstring(String s) {
        // expand the window as long as window remains valid
        // continue to shrink as long as invalid
        char[] arr = s.toCharArray();
        Set<Character> hs = new HashSet<>();
        int maxWindowLength = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++){
            // window invalid - shrink
            while(hs.contains(arr[windowEnd]) && windowStart < windowEnd){
                hs.remove(arr[windowStart]);
                windowStart++;
            }   
            maxWindowLength = Math.max(maxWindowLength, windowEnd-windowStart+1);
            hs.add(arr[windowEnd]);
        }
        return maxWindowLength;
        
    }
}
