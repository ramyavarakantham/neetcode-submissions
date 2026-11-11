class Solution {
    public int characterReplacement(String s, int k) {
        // window size - highest freq <= k
        HashMap<Character, Integer> hm = new HashMap<>();
        char[] arr = s.toCharArray();
        int windowStart = 0;
        int maxFreq = 0;
        int maxWindowSize = 0;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            int currFreq = hm.getOrDefault(arr[windowEnd], 0)+1;
            maxFreq = Math.max(maxFreq, currFreq);

            hm.put(arr[windowEnd], currFreq);

            while(windowStart < windowEnd && (windowEnd-windowStart+1) - maxFreq > k){
                hm.put(arr[windowStart], hm.get(arr[windowStart])-1);
                if(hm.get(arr[windowStart]) == 0){
                    hm.remove(arr[windowStart]);
                }
                windowStart++;
            }

            maxWindowSize = Math.max(maxWindowSize, windowEnd-windowStart+1);

        }
        return maxWindowSize;
        
    }
}
