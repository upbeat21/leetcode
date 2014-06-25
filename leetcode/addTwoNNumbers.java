/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(-1);
        ListNode curr = l3;
        int k = 0;
        while(l1 != null && l2 != null) {
            int a = l1.val;
            int b = l2.val;
            curr.next = new ListNode((a + b + k) % 10);
            k = (a + b + k) / 10;
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 == null) {
            while(l2 != null) {
                curr.next = new ListNode((l2.val + k) % 10);
                k = (l2.val + k) / 10;
                curr = curr.next;
                l2 = l2.next;
            }
        }
        if(l2 == null) {
            while(l1 != null) {
                curr.next = new ListNode((l1.val + k) % 10);
                k = (l1.val + k) / 10;
                curr = curr.next;
                l1 = l1.next;
            }
        }
        if(k != 0) curr.next = new ListNode(k);
        return l3.next;
    }
}
