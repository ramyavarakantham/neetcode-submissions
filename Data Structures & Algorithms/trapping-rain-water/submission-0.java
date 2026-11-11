class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        leftMax[0] = 0;
        int leftMaxSoFar = height[0];
        for(int i = 1; i < height.length; i++){
            leftMax[i] = leftMaxSoFar;
            leftMaxSoFar = Math.max(leftMaxSoFar, height[i]);
        }

        int[] rightMax = new int[height.length];
        rightMax[height.length-1] = 0;
        int rightMaxSoFar = height[height.length-1];
        for(int i = height.length-2; i >= 0; i--){
            rightMax[i] = rightMaxSoFar;
            rightMaxSoFar = Math.max(rightMaxSoFar, height[i]);
        }

        int trappedWater = 0;
        for(int i = 0; i < height.length; i++){
            int minHeight = Math.min(leftMax[i], rightMax[i]);

            if(minHeight > height[i]) {
                trappedWater += (minHeight - height[i]);
            }

            //System.out.println(trappedWater);
        }


        return trappedWater;
    }
}
