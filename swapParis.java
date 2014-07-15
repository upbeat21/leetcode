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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode curr = fake;
        while(curr.next != null && curr.next.next != null) {
            ListNode next = curr.next.next.next;
            ListNode tmp = curr.next;
            curr.next = curr.next.next;
            curr.next.next = tmp;
            tmp.next = next;
            curr = curr.next.next;
        }
        return fake.next;
    }
}
