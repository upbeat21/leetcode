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
        ListNode fake = new ListNode(-1);
		ListNode curr = fake;
		int t = 0;
		while(l1 != null && l2 != null) {
			int n = (l1.val + l2.val + t) % 10;
			t = (l1.val + l2.val + t) / 10;
			curr.next = new ListNode(n);
			curr = curr.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		while(l1 != null) {
			int n = (l1.val + t) % 10;
			t = (l1.val + t) / 10;
			curr.next = new ListNode(n);
			curr = curr.next;
			l1 = l1.next;
		}
		while(l2 != null) {
			int n = (l2.val + t) % 10;
			t = (l2.val + t) / 10;
			curr.next = new ListNode(n);
			curr = curr.next;
			l2 = l2.next;
		}
		if(t != 0) curr.next = new ListNode(t);
		return fake.next;
    }
}
