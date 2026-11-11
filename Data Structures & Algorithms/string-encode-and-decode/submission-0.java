class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s:strs){
            sb.append(s.length());
            sb.append(':');
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int currIndex = 0;

        while(currIndex < str.length()){

            StringBuilder wordLen = new StringBuilder();

            while(str.charAt(currIndex) !=':'){
                wordLen.append(str.charAt(currIndex));
                currIndex++;
            }

            int wordStart = currIndex +1;
            int wordEnd = wordStart + Integer.parseInt(wordLen.toString());

            strs.add(str.substring(wordStart, wordEnd));

            currIndex = wordEnd;

        }

        return strs;


    }
}
