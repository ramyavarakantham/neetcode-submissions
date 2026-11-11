class LRUCache {

    class Node{
        int key;
        int val;
        Node left;
        Node right;

        Node(int key, int val){
            this.key =key;
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    HashMap<Integer, Node> hm;
    Node dummyHead;
    Node dummyTail;
    int capacity;

    public LRUCache(int capacity) {
        // Initialize a linked hashmap
        // Hashmap should contain keys mapped to nodes
        // Each node should be key, value pair
        // Nodes must be in a doubly linked list

        this.capacity = capacity;
        hm = new HashMap<>();

        // Initialize sentinel nodes at the head and the tail of the dll
        dummyHead = new Node(0,0);
        dummyTail = new Node(0,0);

        dummyHead.right = dummyTail;
        dummyTail.left = dummyHead;

    }

    public void remove(Node node){
        Node prev = node.left;
        Node next = node.right;
        prev.right = next;
        next.left = prev;
    }

    // You always insert at the head of the list- most recently used
    public void insert(Node node){
        Node head = dummyHead.right;
        dummyHead.right = node;
        node.left = dummyHead;
        node.right = head;
        head.left = node;
    }
    
    public int get(int key) {
        // we return the node value associated with the key - O(1)
        // And remvoe the node from the linked list and add it to the front/head to indicate most recently used
        if(!hm.containsKey(key)){
            return -1;
        }
        Node currNode = hm.get(key);

        // Remove node from dll
        remove(currNode);

        // Add to the front of the dll
        insert(currNode);

        return currNode.val;
        
    }
    
    public void put(int key, int value) {
        
        // We check hashmap for existence, if so repeat the above process
        // For a new insertion, check hashmap for capacity, if at capacity already, remove the last node/tail node (least recently used)
        // Remove hashmap entry 
        // Then insert at the head - update both hashmap and linked list
        if(hm.containsKey(key)){ 
            Node currNode = hm.get(key);
            currNode.val = value; // update the value

            remove(currNode);
            insert(currNode);
        } else {
            //System.out.println(hm.size());
            // check if hashmap is at capacity before insertion
            if(hm.size() == capacity){

                Node lru = dummyTail.left;
                //update hashmap reference
                hm.remove(lru.key);
                // remove least recently used
                remove(lru);

                //System.out.println("Remvoing key: "+ key);
            }
            Node newNode = new Node(key, value);
            insert(newNode);
            hm.put(key, newNode);
        }
    }
}
