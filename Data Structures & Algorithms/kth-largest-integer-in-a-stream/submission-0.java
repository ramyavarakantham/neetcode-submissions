class KthLargest {


    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num:nums){
            addToHeap(num);
        }
    }
    
    public int add(int val) {
        addToHeap(val);
        return heap.peek(); 
    }

    void addToHeap(int val){
        if(heap.size() < k){
            heap.add(val);
        } else {
            if(val > heap.peek()){
                heap.poll();
                heap.add(val);
            }
        }
    }
}
