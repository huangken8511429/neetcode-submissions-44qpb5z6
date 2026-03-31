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
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = 0;
        ListNode tmp = head;
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        ListNode cur = p0.next;
        ListNode prev = null;
        while (size >= k) {
            size -= k;
            for (int i = 0 ; i < k; i++) {
             ListNode next = cur.next;
             cur.next = prev;
             prev = cur;
             cur = next;
            }
        ListNode next = p0.next;
        p0.next.next = cur;
        p0.next = prev;
        p0 = next;
        }
        return dummy.next;
    }
}
