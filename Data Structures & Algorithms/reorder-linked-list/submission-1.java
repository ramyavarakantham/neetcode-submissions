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
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l1 = head;
        while(l1.next != slow){
            l1 = l1.next;
        }

        l1.next = null;

        // middle of linked list is slow
        // reverse from middle to end
        ListNode prev = null;
        ListNode curr = slow;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // head of the reversed list is at prev
        ListNode list2 = prev;
        ListNode list1 = head;
        while(list1 != null && list2 != null) {
            ListNode list1next = list1.next;
            ListNode list2next = list2.next;

            list1.next = list2;
            if(list1next == null){
                list2.next = list2next;
            } else {
                list2.next = list1next;
            }

            list1 = list1next;
            list2 = list2next;
        } 
        
    }
}
