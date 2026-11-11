class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Two strings are permutations of each other when they contain same chars with the same freq
        // First check s2.length() >= s1.length()
        // Window of size s1- slide forward
        // Window valid ie. permutation when s1HashMap.size() == windowHashMap.size() hashmaps equality - need not check for full hashmap check every time
        // First time check if hashmaps are equal - yes- return true
        // no - slide window forward
        // remove windowStart from windowHashMap and windowStart++ 
        // add windowEnd to windowHashMap and windowEnd++ 
        if(s2.length() < s1.length()){
            return false;
        }
        char[] s1arr = s1.toCharArray();
        HashMap<Character, Integer> s1hm = new HashMap<>();
        for(char c: s1arr){
            s1hm.put(c, s1hm.getOrDefault(c, 0)+1);
        }

        HashMap<Character, Integer> s2hm = new HashMap<>();
        char[] s2arr = s2.toCharArray();
        int windowStart = 0;
        int windowEnd = 0;
        // create a hashmap for the initial window
        for(;windowEnd<s1.length(); windowEnd++){
            s2hm.put(s2arr[windowEnd], s2hm.getOrDefault(s2arr[windowEnd], 0)+1);
        }

        // count the number of matches btw 2 hashmaps - match = same char, same freq
        int matches = 0;
        for(char c:s1hm.keySet()){
            System.out.println("Checking match for char " + c + " s1 count "+ s1hm.get(c) + " s2 count "+ s2hm.get(c));
            if(s2hm.containsKey(c) && s1hm.get(c) == s2hm.get(c)){
                matches++;
            }
        }

        System.out.println("Initial set of  matches " + matches);

        // slide the window fwd
        for(; windowEnd < s2.length(); windowEnd++){
            // if the window is a permutation - all chars match = return true
            if(matches == s1hm.size()){
                return true;
            }
            // add to window and increment match as needed
            int currCharCount = s2hm.getOrDefault(s2arr[windowEnd], 0)+1;
            s2hm.put(s2arr[windowEnd], currCharCount);
            if(s1hm.containsKey(s2arr[windowEnd]) && s1hm.get(s2arr[windowEnd]) == currCharCount) {
                matches++;
            }
            if(s1hm.containsKey(s2arr[windowEnd]) && s1hm.get(s2arr[windowEnd])+1 == currCharCount){
                matches--;
            }

            System.out.println("windowEnd added: matches " + matches);

            // remove windowStart and decrease match as needed

            s2hm.put(s2arr[windowStart], s2hm.get(s2arr[windowStart])-1);
            if(s1hm.containsKey(s2arr[windowStart])){
                // after window slide fwd, we arrived at the right count - increment match count
                if(s1hm.get(s2arr[windowStart]) == s2hm.get(s2arr[windowStart])){
                    matches++;
                } 
                // it was a match before we slide the window fwd- so decrease match count
                if(s2hm.get(s2arr[windowStart])+1 == s1hm.get(s2arr[windowStart])){
                    matches--;
                }
            }
            if(s2hm.get(s2arr[windowStart]) == 0){
                s2hm.remove(s2arr[windowStart]);
            }
            windowStart++;
        }
        System.out.println(matches);
        return matches == s1hm.size();
    }
}
