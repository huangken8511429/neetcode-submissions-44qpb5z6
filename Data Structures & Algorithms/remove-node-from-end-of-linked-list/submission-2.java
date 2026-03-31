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
       ListNode cur = head;
       int size = 0;
    
       while (cur != null) {
         cur = cur.next;
         size++;
       }

       int removeIndex = size - n;

       if (removeIndex == 0) {
        return head.next;
       }

       cur = head;

       for (int i = 0 ; i < size - 1; i++) {
         if ((i+1) == removeIndex) {
            cur.next = cur.next.next;
         }
         cur = cur.next;
       }

       return head; 
    }

    
}
