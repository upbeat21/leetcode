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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode curr = fake;
        while(curr.next != null) {
            int val = curr.next.val;
            ListNode loop = curr.next;
            if(loop.next == null) break;
            if(loop.next.val != val) {
                curr = curr.next;
                continue;
            } else {
                while(loop.next != null && loop.next.val == val) loop = loop.next;
                curr.next = loop.next;
            }
        }
        return fake.next;
    }
}
