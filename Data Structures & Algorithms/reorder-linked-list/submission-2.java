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
    public void reorderList(ListNode head) {
        if(head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null; // split first half cleanly - first half contains slow node
        // Reverse from curr to end of list
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // new head is at prev
        // two lists will be of equal length for even num of nodes
        // first list will be longer for odd num of nodes
 
        ListNode list2 = prev;
        ListNode list1 = head;
        while(list2 != null) {
            ListNode list1Next = list1.next;
            ListNode list2Next = list2.next;
            list1.next = list2;
            list2.next = list1Next;
            list1 = list1Next;
            list2 = list2Next;
        }

        
    }
}
