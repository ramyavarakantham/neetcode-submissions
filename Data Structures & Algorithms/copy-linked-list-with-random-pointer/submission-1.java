/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        HashMap<Node, Node> hm = new HashMap<>();

        // First pass- new nodes created w/o next and random pointers
        for(Node curr = head; curr != null; curr = curr.next){
            hm.put(curr, new Node(curr.val));
        }

        // Second pass - update the pointers
        for(Node curr = head; curr != null; curr = curr.next){
            Node copy = hm.get(curr);
            copy.next = hm.get(curr.next);
            copy.random = hm.get(curr.random);
        }

        return hm.get(head);
        
    }
}
