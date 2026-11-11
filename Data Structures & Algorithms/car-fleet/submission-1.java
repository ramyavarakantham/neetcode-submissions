class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int[][] cars = new int[position.length][2];
        for(int i = 0; i < position.length; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b)-> Integer.compare(b[0], a[0]));

        int numOfFleets = 0;
        double lastFleetTime = 0;

        for(int[] car:cars){
            double currCarTime = (double)(target-car[0])/car[1];
            if(currCarTime > lastFleetTime) {
                numOfFleets++;
                lastFleetTime = currCarTime;
            } 
        }

        return numOfFleets;
        
    }
}
