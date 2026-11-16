class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for(int i = 1; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int index = stack.pop();
                result[index] = i-index;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            result[stack.pop()] = 0;
        }
        return result;
        
    }
}
