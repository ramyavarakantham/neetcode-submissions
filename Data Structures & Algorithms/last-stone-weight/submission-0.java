class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        for(int stone:stones){
            pq.offer(stone);
        }

        while(pq.size() > 1){ // at least two elements in the heap
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            if(stone1-stone2 > 0){
                pq.offer(stone1-stone2);
            }
        }

        return (pq.size() == 1)? pq.poll():0;
    }
}
