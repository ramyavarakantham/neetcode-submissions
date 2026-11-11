class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for(int pile:piles){
            maxPile = Math.max(pile, maxPile);
        }
        int low = 1;
        int high = maxPile;
        while(low <= high){
            int mid = low + (high-low)/2;
            int totalTimeTaken = 0;
            for(int pile:piles){
                // if(pile < mid){
                //     totalTimeTaken++;
                // } else {
                    totalTimeTaken += Math.ceil((double)pile/mid);
                //}
            }
            if(totalTimeTaken > h){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return low;
        
    }
}
