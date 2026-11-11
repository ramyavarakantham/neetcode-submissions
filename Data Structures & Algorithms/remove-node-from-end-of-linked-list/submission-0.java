/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // distance between two pointers should be n
        // when fast pointer reaches end of list, slow pointer should be at the nth node from the end
        // We need access to n-1 node and n+1 node to adjust the pointers
        // Test cases
        // Empty list - not possible
        // Only one node
        // Two or more nodes- remove first node, remove last node
        // Happy case - remove any random node
        // Slow pointer should run n+1 steps behind
        // Let fast pointer move n+1 steps first a
        // and then move the slow pointer and fast pointer one node at a time
        if(head.next == null) {
            return null;
        }
        ListNode fast = head; // 1
        int count = n;
        while(count > 0){
            fast = fast.next; // 2 // 3
            count--; // 1 // 0
        }
        
        if (fast == null){ // we are asked to remvoe the head of the list
            return head.next; 
        }
        ListNode slow = head;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
        
    }
}
