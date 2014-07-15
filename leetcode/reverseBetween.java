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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode curr = fake;
        for(int i=1;i<m;i++) {
            curr = curr.next;
        }
        ListNode loop = curr.next;
        curr.next = null;
        for(int i=m;i<=n;i++) {
            ListNode next = loop.next;
            ListNode tmp = curr.next;
            curr.next = loop;
            loop.next = tmp;
            loop = next;
        }
        while(curr.next != null) curr = curr.next;
        curr.next = loop;
        return fake.next;
    }
}
