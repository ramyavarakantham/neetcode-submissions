class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        char[] sArr = s.toCharArray();
        for(char c:sArr){
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        char[] tArr = t.toCharArray();
        for(char c:tArr){
            if(!hm.containsKey(c)){
                return false;
            }
            hm.put(c, hm.get(c)-1);
            if(hm.get(c) == 0){
                hm.remove(c);
            }
        }

        return true;
    }
}