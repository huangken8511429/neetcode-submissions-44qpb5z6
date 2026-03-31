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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        for (int i = 1; i < lists.length; i++) {
            if (result == null) {
             result = mergeTwoList(lists[i-1], lists[i]);
            } else {
              result = mergeTwoList(result, lists[i]);
            }
        }
        return result;
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode(0);
      ListNode cur = dummy;

       while (l1 != null && l2 != null) {
         if (l1.val < l2.val) {
           cur.next = l1;
           l1 = l1.next;
        } else {
           cur.next = l2;
           l2 = l2.next;
         }
         cur = cur.next;
        }


        cur.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }
}
