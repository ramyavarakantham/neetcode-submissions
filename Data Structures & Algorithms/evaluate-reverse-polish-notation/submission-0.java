class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String s:tokens){
            if(s.equals("+")){
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                stack.push(operand1+operand2);
            } else if(s.equals("-")){
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                stack.push(operand1-operand2);
            } else if(s.equals("*")) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                stack.push(operand1*operand2);
            } else if(s.equals("/")) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                stack.push(operand1/operand2);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
        
    }
}
