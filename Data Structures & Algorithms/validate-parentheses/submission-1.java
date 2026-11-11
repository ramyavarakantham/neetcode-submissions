class Solution {
    public boolean isValid(String str) {
        // Open bracket goes into the Stack
        // For every close bracket, pop from stack and check if valid pair
        // At the end if stack is not empty- open bracket with no closed bracket=> return false
        Deque<Character> s = new ArrayDeque<>();
        char[] arr = str.toCharArray();
        for(char c: arr){
            if(c == '{' || c == '[' || c== '('){
                s.push(c);
            } else {
                if(s.isEmpty()){
                    return false;
                }
                char top = s.pop();
                if((c== ')' && top != '(') ||
                (c == ']' && top != '[') ||
                (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return s.isEmpty();
        
    }
}
