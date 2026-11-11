class Solution {
    public boolean isPalindrome(String s) {
        char[] sArr = s.toCharArray();
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            while(i < j && !(Character.isDigit(sArr[i])|| Character.isLetter(sArr[i]))){
                i++;
            }
            while( i < j && !(Character.isDigit(sArr[j])|| Character.isLetter(sArr[j]))){
                j--;
            }
            if(i < j && Character.toLowerCase(sArr[i])!= Character.toLowerCase(sArr[j])){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
