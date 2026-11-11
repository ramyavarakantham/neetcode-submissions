class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //for every string, sort, check hashmap if key exists 
        // if not, create new entry with key as sorted string, value [str]
        // if yes, append to the list of value strings 
        //return all values
        // Time complextiy- n strings -> n* (O(klogk)) //k avg length of string
        // Space - O(n)
        HashMap<String, List<String>> hm = new HashMap<>();
        for(String s:strs){
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String sortedStr = new String(charArr);
            hm.computeIfAbsent(sortedStr, k-> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(hm.values());
        
    }
}
