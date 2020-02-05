/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {

        ListNode cur = head;

        if (cur == null || cur.next == null) {
            return cur;
        }


        ListNode rem = cur.next.next;
        ListNode n = cur.next;
        cur.next.next = cur;
        // Recur for remaining list and change next of head
        cur.next = swapPairs(rem);
        // Returning new head of modified list
        return n;

        //Alternative
        /*ListNode cur = head;
        int t;
        while(cur!=null && cur .next!=null)
        {
            t = cur.val;
            cur.val = cur.next.val;
            cur.next.val = t;
            cur = cur.next.next;
        }
        return head;*/
    }
}
