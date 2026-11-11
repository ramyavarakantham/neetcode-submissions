class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // when n==k, The array itself is the top k elements
        if(k == nums.length){
            return nums; 
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num:nums){
            hm.put(num, hm.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> hm.get(a)-hm.get(b)); //comparator takes frequency into consideration - min heap 

        for(int num:hm.keySet()){
            pq.offer(num); //insert - heap will be constructed based on comparator condition
            if(pq.size()>k){ // when insertion increases the heap size beyond k, remove the top element
                pq.poll();
            }
        }

        int[] result = new int[k];
        int index = 0;
        while(pq.size()>0){
            result[index] = pq.poll();
            index++;
        }
        return result;
        
    }
}
