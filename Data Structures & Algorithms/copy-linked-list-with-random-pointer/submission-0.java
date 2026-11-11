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
        Node curr = head;
        HashMap<Node, Node> hm = new HashMap<>();
        // First pass- new nodes created w/o next and random pointers
        while(curr != null){
            hm.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Second pass - update the pointers
        Node currNode = head;
        Node dummy = new Node(0);
        while(currNode != null){
            // get the listnode corresponding to curr node and update its pointers 
            Node copyNode = hm.get(currNode);

            if(currNode == head){
                dummy.next = copyNode;
            }

            // update next pointer
            copyNode.next = hm.get(currNode.next);

            // update random pointer
            copyNode.random = hm.get(currNode.random);

            currNode = currNode.next;

        }

        return dummy.next;


        
        
    }
}
