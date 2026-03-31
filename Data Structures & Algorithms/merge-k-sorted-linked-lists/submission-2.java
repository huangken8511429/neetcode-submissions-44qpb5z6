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
      if (lists == null || lists.length == 0) return null; 
      int left = 0, right = lists.length - 1; 
      while (right > 0) { 
        left = 0; 
        while (left < right) { 
            lists[left] = mergeTwoList(lists[left], lists[right]); 
            left++; 
            right--;
            } 
         } 
      return lists[0];
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
