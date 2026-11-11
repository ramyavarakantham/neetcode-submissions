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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        int carry = 0;


        while(l1!= null || l2 != null){
            int resVal = 0;

            if(l1 != null){
                resVal += l1.val;
            }

            if(l2 != null){
                resVal += l2.val;
            }

            resVal += carry;
            carry = resVal/10;
            int actVal = resVal %10;

            res.next = new ListNode(actVal);

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }

            res= res.next;

        }

        if(carry != 0){
            res.next = new ListNode(carry);
        }

        return dummy.next;
        
    }
}
